<template>
  <div>
    <!-- 로그인 상태 따라서 달라짐 -->
    <header-nav-login/>
    <header-nav-logout/>
    <div>
      <home-side-bar/>
      <home-main/>
      <router-view />
    </div>

    
  </div>
</template>

<script>
import HeaderNavLogin from "@/components/common/HeaderNavLogin.vue";
import HeaderNavLogout from "@/components/common/HeaderNavLogout.vue";
import HomeSideBar from "@/components/home/HomeSideBar.vue";
import HomeMain from "@/components/home/HomeMain.vue";


export default {
  name: 'Home',
  components:{
    HeaderNavLogin,
    HeaderNavLogout,
    HomeSideBar,
    HomeMain,

  },
}
</script>

<style scoped>


</style>