<template>
  <div class="d-flex flex-column">
    <!-- 로그인 상태 따라서 달라짐 -->
    <header-nav-login />
    <v-row class="px-0">
      <v-col cols="3" sm="4" md="3" lg="3" class="pb-0" max-width="300">
        <home-side-bar class="side-bar" />
      </v-col>
      <v-col cols="9" sm="8" md="9" lg="9">
        <router-view />
      </v-col>
    </v-row>

  </div>
</template>

<script>
import HeaderNavLogin from "@/components/common/HeaderNavLogin.vue";

import HomeSideBar from "@/components/home/include/HomeSideBar.vue";



export default {
  name: "Home",
  components: {
    HeaderNavLogin,
    HomeSideBar,

  },
};
</script>

<style scoped>
/* .content-wrapper {
  display: flex;
} */

/* .side-bar {
  flex: 0 0 25rem;
  background-color: rgb(190, 237, 255);
  height: 100vh;
} */
</style>
