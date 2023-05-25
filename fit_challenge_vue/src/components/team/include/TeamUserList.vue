<template>
  <div>
    <v-container class="d-flex overflow-x-auto" width="100%">
      <team-user-card
        v-for="(userCard, index) in userCards"
        :key="index"
        :img="userCard.userImg"
        :nickname="userCard.nickname"
        :archieve="userCard.totalArchieve"
        :weeklys="userCard.personalWeekly"
        :userId="userCard.userId"
      />
    </v-container>
  </div>
</template>

<script>
import { mapState } from "vuex";
import TeamUserCard from "./TeamUserCard.vue";

export default {
  name: "TeamUserList",
  components: {
    TeamUserCard,
  },
  computed: {
    ...mapState(["userCards"]),
  },
};
</script>

<style scoped></style>
