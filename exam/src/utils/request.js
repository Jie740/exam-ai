import axios from 'axios'
import VueCookies from 'vue-cookies'
import router from '@/router'

const service = axios.create()


// 请求拦截器
service.interceptors.request.use(
  config => {
    const role = VueCookies.get("role")
    const userId = VueCookies.get("cid")
    const token = VueCookies.get(`${role}_${userId}_token`)
    if (token) {
      config.headers.Authorization = `Bearer ${token}`
      config.headers.token = token
    }
    return config
  },
  error => Promise.reject(error)
)

// 响应拦截器
service.interceptors.response.use(
  response => {
    const role = VueCookies.get("role")
    const userId = VueCookies.get("cid")
    // 优先从响应头中获取新token（后端通过request.setAttribute设置）
    let newToken = response.headers['authorization']
    // 如果找到新token，更新cookies
    if (newToken) {
      VueCookies.set(`${role}_${userId}_token`, newToken)
    }
    //如果没有token
    if(response.status===401){

      VueCookies.remove("cname")
      VueCookies.remove("cid")
      VueCookies.remove("role")
      if (role && userId) {
        VueCookies.remove(`${role}_${userId}_token`)
      }
      this.$message.error('token已失效,请重新登录')
      router.push({ path: '/' })
    }
    return response
  }
)

export default service
