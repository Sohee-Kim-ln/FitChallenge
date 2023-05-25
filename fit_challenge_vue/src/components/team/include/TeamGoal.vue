<template>
  <div class="container">
    <div class="text-h4 text-start"><strong>주간 목표</strong></div>
    <v-row>
      <v-col>
        <v-timeline align-top dense>
          <v-timeline-item
            class="text-start"
            v-for="(goal, index) in goals"
            :key="index"
            small
          >
            
            <div class="text-h6">
              <strong> {{ goal.sportsId | sportsFilter }}</strong>
              {{ goal.goalTime | timeFilter }}
              {{ goal.goalDistance | distFilter }}
            </div>
          </v-timeline-item>
          <div v-if="goals.length===0" class="text-h6">설정된 목표가 없습니다.</div>
        </v-timeline>
      </v-col>
      <v-col class="d-flex align-center justify-center flex-column">
        <div class="text-h6">전체 달성률</div>
        <div class="text-h4">{{ team.teamArchieve | archieveFilter }}</div>
      </v-col>
    </v-row>
    <v-row v-if="loginUser.teamId==this.$route.params.teamId"> 
      <v-col v-if="loginUser.isOwner">
        <v-btn color="primary white--text text-h6" elevation="2" @click="updateGoal" >목표 수정하기</v-btn>
      </v-col>
      <v-spacer></v-spacer>
      </v-row>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "TeamGoal",
  computed: {
    ...mapState(["goals"]),
    ...mapState(["team"]),
    ...mapState(["loginUser"]),
  },
  methods:{
    updateGoal(){
      let url = "/team/"+this.team.teamId+"/goalUpdate";
      this.$router.push(url);
    }
  }
};
</script>

<style></style>
