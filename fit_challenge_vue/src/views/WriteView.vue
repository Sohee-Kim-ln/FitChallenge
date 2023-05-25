<template>
  <div>
    <header-nav-login/>
    <router-view />
  </div>
</template>

<script>
import HeaderNavLogin from '@/components/common/HeaderNavLogin.vue';
export default {
    name: "WriteView",
    components:{
      HeaderNavLogin,
    }
}
</script>

<style>

</style>