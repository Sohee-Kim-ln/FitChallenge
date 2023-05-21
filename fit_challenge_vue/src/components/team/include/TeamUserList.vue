<template>
  <div>
    <h2>팀 유저리스트 컴포넌트</h2>
    <team-user-card/>
    <team-user-card/>
    <team-user-card/>
    <team-user-card/>
  </div>
</template>

<script>
import TeamUserCard from "./TeamUserCard.vue";
export default {
  components: {
    TeamUserCard,
  },
};
</script>

<style></style>
