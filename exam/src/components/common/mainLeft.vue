<!--左边下拉导航栏-->
<template>
  <div id="left">
    <el-menu
      active-text-color="#ffffff" 
      text-color="#ffffff"
      :default-active="this.$route.path"
      class="el-menu-vertical-demo" 
      @open="handleOpen" 
      @close="handleClose" 
      :collapse="flag"
      background-color="#124280"  
      menu-trigger="click" router>
      <el-submenu v-for="(item,index) in menu" :index='item.index' :key="index">
        <template slot="title">
          <div class="left-width">
            <i class="iconfont" :class="item.icon"></i>
            <span slot="title" class="title">{{item.title}}</span>
          </div>
        </template>
        <el-menu-item-group v-for="(list,index1) in item.content" :key="index1">
          <el-menu-item @click="handleTitle(item.index)" :index="list.path" v-if="list.item1 != null">{{list.item1}}</el-menu-item>
          <el-menu-item @click="handleTitle(item.index)" :index="list.path" v-if="list.item2 != null">{{list.item2}}</el-menu-item>
          <el-menu-item @click="handleTitle(item.index)" :index="list.path" v-if="list.item3 != null">{{list.item3}}</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
  name: "mainLeft",
  data() {
    return {
      
    }
  },
  computed: mapState(["flag","menu"]),
  created() {
    this.addData()
  },
  methods: {
    handleOpen(key, keyPath) {
      // console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      // console.log(key, keyPath);
    },
    //点击标题传递参数给navigator组件
    handleTitle(index) {
      this.bus.$emit('sendIndex',index)
    },
    addData() {
      let role = this.$cookies.get("role")
      if(role == 0) {
        this.menu.push({
          index: '5',
          title: '教师管理',
          icon: 'icon-Userselect',
          content:[{item1:'教师管理',path:'/teacherManage'},{item2: '添加教师',path: '/addTeacher'}],
        })
      }
    }
  },
}
</script>

<style>
.el-menu-vertical-demo .el-submenu__title {
  overflow: hidden;
  color: #ffffff !important; /* 确保子菜单标题是白色 */
  font-weight: 500;
  font-size: 15px;
}
.left-width .iconfont {
  font-size: 18px;
  color: #ffffff !important;
}
.left-width {
  width: 213px;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  min-height: 900px;
}
#left {
  height: 900px;
  background-color: #124280;
  z-index: 0;
}
#left .el-menu-vertical-demo .title {
  color: #ffffff !important;
  font-size: 16px;
  font-weight: bold;
  margin-left: 14px;
  letter-spacing: 0.5px;
}
.el-submenu {
  border-bottom: 1px solid #eeeeee20 !important;
}
.el-submenu__title:hover {
  background-color: #1a57a8 !important;
  color: #ffffff !important;
}
.el-submenu__title i {
  color: #ffffff !important;
}
/* 菜单项样式 */
.el-menu-item {
  color: #f0f0f0 !important;
  font-size: 14px;
  font-weight: 500;
  transition: all 0.3s ease;
}
.el-menu-item:hover {
  background-color: #1a57a8 !important;
  color: #ffffff !important;
}
.el-menu-item.is-active {
  background-color: #2569be !important;
  color: #ffffff !important;
  font-weight: bold;
}
</style>
