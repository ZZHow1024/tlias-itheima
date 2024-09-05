<script setup>
import { ref, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const time = ref(5)
const timer = setInterval(() => {
  if (--time.value === 0) {
    handleClick()
    clearInterval(timer)
  }
}, 1000)

const handleClick = () => {
  router.replace('/home')
}

onUnmounted(() => {
  clearInterval(timer)
})
</script>

<template>
  <div class="not-found">
    <div class="content">404 Not Found.</div>
    <div class="time">{{ time }}s 后跳转回首页</div>
    <el-button @click="handleClick" type="primary"> 点击立即跳转</el-button>
  </div>
</template>

<style scoped lang="scss">
.not-found {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
  width: 100%;

  .content {
    font-size: 50px;
    margin: 35px auto;
  }

  .time {
    font-size: 30px;
    margin: 15px auto;
  }
}
</style>
