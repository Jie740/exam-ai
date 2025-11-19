package com.exam.controller;

import com.exam.domain.Adminuser;
import com.exam.domain.Student;
import com.exam.domain.Teacher;
import com.exam.domain.dto.LoginDto;
import com.exam.service.impl.LoginServiceImpl;
import com.exam.util.JwtUtils;
import com.exam.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.exam.constants.JwtConstants.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginServiceImpl loginService;

    private final StringRedisTemplate stringRedisTemplate;
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto) {
        String role = loginDto.getRole();
        Long username = loginDto.getUsername();
        String password = loginDto.getPassword();
        return switch (role) {
            case "admin" -> {
                Adminuser adminuser = loginService.adminLogin(username, password);
                if (adminuser!= null){
                    String token = JwtUtils.createToken(adminuser.getAdminId(), role);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("token", token);
                    map.put("userInfo", adminuser);
                    stringRedisTemplate.opsForValue().set(TOKEN_KEY_PREFIX + role + ":" + adminuser.getAdminId(), token, TOKEN_TTL, TimeUnit.HOURS);
                    yield Result.ok(map);
                }else yield Result.error("用户名或密码错误");
            }
            case "teacher" -> {
                Teacher teacher = loginService.teacherLogin(username, password);
                if (teacher!= null){
                    String token = JwtUtils.createToken(teacher.getTeacherId(), role);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("token", token);
                    map.put("userInfo", teacher);
                    stringRedisTemplate.opsForValue().set(TOKEN_KEY_PREFIX + role + ":" + teacher.getTeacherId(), token, TOKEN_TTL, TimeUnit.HOURS);
                    yield Result.ok(map);
                }else yield Result.error("用户名或密码错误");
            }
            case "student" -> {
                Student student = loginService.studentLogin(username, password);
                if (student!= null){
                    String token = JwtUtils.createToken(student.getStudentId(), role);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("token", token);
                    map.put("userInfo", student);
                    stringRedisTemplate.opsForValue().set(TOKEN_KEY_PREFIX + role + ":" + student.getStudentId(), token, TOKEN_TTL, TimeUnit.HOURS);
                    yield Result.ok(map);
                }else yield Result.error("用户名或密码错误");
            }
            default -> Result.error("用户角色错误");
        };
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        // 从请求头获取 Token
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        // 解析 Token 获取过期时间（以 JWT 为例）
        Date expiration = null;
        try {
            expiration = JwtUtils.getExpiration(token);
            if(expiration==null){
                return Result.error("token已过期");
            }
        } catch (NullPointerException e) {
            log.debug("token:{},过期时间:{}",token,expiration);
        }
        // 计算 Token 剩余有效期（秒）
        long currentTime = System.currentTimeMillis();
        long remaining = (expiration.getTime() - currentTime)/1000;
        // 将 Token 存入 Redis 黑名单，设置过期时间
        stringRedisTemplate.opsForValue().set(TOKEN_BLACKLIST_KEY_PREFIX + token, "invalid", remaining, TimeUnit.SECONDS);
        return Result.ok();
    }
}
