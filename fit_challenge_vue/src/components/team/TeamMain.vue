<template>
  <div>
    <h1>팀 메인 뷰</h1>
    <team-goal/>
    <div>
        팀 유저 카드 플로우
        <team-user-card></team-user-card>
        <team-user-card></team-user-card>
        <team-user-card></team-user-card>
        <team-user-card></team-user-card>
    </div>
  </div>
</template>

<script>
import TeamGoal from './include/TeamGoal.vue';
import TeamUserCard from './include/TeamUserCard.vue';

export default {
    name: "TeamMain",
    components:{
        TeamGoal,
        TeamUserCard,
    }
}
</script>

<style>

</style>