<script setup>
import { onMounted } from 'vue'
// 侧边栏
import { Document, House, DocumentRemove } from '@element-plus/icons-vue'
import router from '@/router/index.js'

onMounted(() => {
  router.replace('/home')
})
</script>

<template>
  <div class="common-layout">
    <el-container>
      <!-- 顶栏 -->
      <el-header class="header">
        <a href="/">
          <img class="logo" src="@/assets/logo.png" alt="tlias_logo" />
        </a>
        <div class="title">tlias 后台系统</div>
      </el-header>

      <!-- 侧边栏 -->
      <el-aside class="aside">
        <el-col>
          <el-menu
            router
            active-text-color="#ffd04b"
            background-color="#545c64"
            class="el-menu"
            default-active="/"
            text-color="#fff"
            @open="handleOpen"
            @close="handleClose"
          >
            <el-menu-item index="/">
              <el-icon><House /></el-icon>
              <span>首页</span>
            </el-menu-item>
            <el-sub-menu index="2">
              <template #title>
                <el-icon><Document /></el-icon>
                <span>管理</span>
              </template>
              <el-menu-item index="/department">部门管理</el-menu-item>
              <el-menu-item index="employee">员工管理</el-menu-item>
            </el-sub-menu>
            <el-menu-item index="/login">
              <el-icon><DocumentRemove /></el-icon>
              <span>退出登录</span>
            </el-menu-item>
          </el-menu>
        </el-col>
      </el-aside>

      <el-main class="main"> <router-view /></el-main>
      <el-footer class="footer">
        <div class="footer-context">Author: ZZHow(ZZHow1024)</div>
      </el-footer>
    </el-container>
  </div>
</template>

<style scoped lang="scss">
body {
  margin: 0;
  padding: 0;
}

.common-layout {
  position: fixed;
  top: 0;
  left: 0;
  height: 100vh;
  width: 100vw;

  .header {
    height: 8vh;
    width: 100%;
    position: fixed;
    top: 0;
    left: 0;
    background: rgb(213, 213, 213);
    display: flex;
    align-items: center;

    .logo {
      width: 50px;
      height: 50px;
    }

    .title {
      margin-left: 30px;
      font-size: 30px;
      align-content: center;
    }
  }

  .aside {
    position: fixed;
    left: 0;
    top: 8vh;
    width: 15vw;
    height: 85vh;
    background: white;

    .el-menu {
      min-height: 85vh;
    }
  }

  .main {
    position: fixed;
    top: 8vh;
    left: 15vw;
    padding: 0;
    width: 85vw;
    min-height: 100%;
  }

  .footer {
    background: rgb(213, 213, 213);
    width: 100%;
    height: 7vh;
    bottom: 0;
    left: 0;
    position: fixed;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    .footer-context {
      align-content: center;
    }
  }
}
</style>
