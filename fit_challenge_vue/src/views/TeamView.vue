<template>
  <div>
    <h1>팀뷰</h1>
    <team-side-bar/>
    <router-view />
  </div>
</template>

<script>
import TeamSideBar from '@/components/team/include/TeamSideBar.vue';
export default {
  name: 'Team',
  components:{
    TeamSideBar,
  }
}
</script>

<style scoped>


</style>