<template>
  <div class="container">
    <team-info-box/>
    <team-goal />
    <team-member-list/>
  </div>
</template>

<script>
import { mapState } from "vuex";
import TeamInfoBox from "@/components/team/include/TeamInfoBox.vue"
import TeamGoal from "./include/TeamGoal.vue";
import TeamMemberList from "./include/TeamMemberList.vue";


export default {
  name: "TeamInfo",
  components: {
    TeamInfoBox,
    TeamGoal,
    TeamMemberList
  },
  data() {
    return {};
  },
  computed: {
    ...mapState(["team"]),

  },
  created() {},
};
</script>

<style></style>
