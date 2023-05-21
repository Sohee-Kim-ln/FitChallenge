<template>
  <div>
    <HeaderNav/>
    <h1>index 뷰</h1>
    <router-view />
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
export default {
  name: 'Index',
  components:{
    HeaderNav,
  },
}
</script>

<style scoped>


</style>