<template>
  <div class="d-flex flex-column">
    <header-nav-login />
    <v-row class="px-0 my-10">
      <v-col cols="3" sm="4" md="3" lg="3" class="pb-0">
        <user-side-bar class="side-bar" />
      </v-col>
      <v-divider vertical class="black my-2"></v-divider>
      <v-col cols="9" sm="8" md="9" lg="9">
        <router-view />
      </v-col>
    </v-row>
  </div>
</template>



<script>
import HeaderNavLogin from '@/components/common/HeaderNavLogin.vue';
import UserSideBar from '@/components/user/include/UserSideBar.vue';
export default {
  name: 'User',
  components:{
    HeaderNavLogin,
    UserSideBar,
  },
  created(){
    
  }
}
</script>

<style scoped>


</style>