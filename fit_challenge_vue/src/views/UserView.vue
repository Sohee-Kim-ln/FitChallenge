<template>
  <div>
    <user-side-bar/>
    <router-view />
  </div>
</template>

<script>
import UserSideBar from '@/components/user/include/UserSideBar.vue';
export default {
  name: 'User',
  components:{
    UserSideBar,
  }
}
</script>

<style scoped>


</style>