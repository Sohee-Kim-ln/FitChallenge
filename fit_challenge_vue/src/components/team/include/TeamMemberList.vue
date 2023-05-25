<template>
  <div class="container">
    <div class="text-h4 text-start"><strong>팀원 목록</strong></div>
    <v-container>
      <v-row class="d-flex flex-column">
        <team-user-row
          v-for="(user, index) in userCards"
          :key="index"
          :nickname="user.nickname"
          :regDate="user.regDate"
          :totalArchieve="user.totalArchieve"
        />
      </v-row>
    </v-container>
  </div>
</template>

<script>
import { mapState } from "vuex";
import TeamUserRow from "@/components/team/include/TeamUserRow.vue";

export default {
  name: "TeamMemberList",
  components: {
    TeamUserRow,
  },
  computed: {
    ...mapState(["team"]),
    ...mapState(["userCards"]),
  },
};
</script>

<style></style>
