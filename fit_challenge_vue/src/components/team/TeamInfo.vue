<template>
  <div class="container">
    <h2>팀 정보 컴포넌트</h2>
    <div>팀 정보</div>
    <team-goal/>
  <div>
    <h2>팀원 목록</h2>
    <team-user-row/>
    <team-user-row/>
    <team-user-row/>
    <team-user-row/>
    <team-user-row/>
  </div>

  </div>
</template>

<script>
import TeamGoal from './include/TeamGoal.vue';
import TeamUserRow from './include/TeamUserRow.vue';

export default {
  name:"TeamInfo",
  components:{
    TeamGoal,
    TeamUserRow,
  }
};
</script>

<style>
</style>
