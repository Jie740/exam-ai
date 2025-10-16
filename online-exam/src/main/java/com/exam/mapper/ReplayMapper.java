//package com.exam.mapper;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.exam.domain.Replay;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
///**
//* @author ajie
//* @description 针对表【replay(回复表)】的数据库操作Mapper
//* @createDate 2025-10-16 00:21:31
//* @Entity com.exam.domain.Replay
//*/
//public interface ReplayMapper extends BaseMapper<Replay> {
//    @Select("select message_id,replay_id,replay,replaytime from replay")
//    List<Replay> findAll();
//
//    @Select("select message_id,replay_id,replay,replaytime from replay where message_id = #{messageId}")
//    List<Replay> findAllById(Integer messageId);
//
//    @Select("select message_id,replay_id,replay,replaytime from replay where message_id = #{messageId}")
//    Replay findById(Integer messageId);
//
//    @Delete("delete from replay where replay_id = #{replayId}")
//    int delete(Integer replayId);
//
//    @Update("update replay set title = #{title}, replay = #{replay}, replaytime = #{replayTime} where replay_id = #{replayId}")
//    int update(Replay replay);
//
//    @Options(useGeneratedKeys = true,keyProperty = "replayId")
//    @Insert("insert into replay(message_id,replay,replaytime) values(#{messageId}, #{replay},#{replayTime})")
//    int add(Replay replay);
//}
//
//
//
//
