<template>
  <div>
    <v-container class="d-flex flex-column">
      <div class="text-h4 text-start"><strong>주간 목표 수정</strong></div>
      <v-card outlined class="py-5 my-9">
        <v-row class="d-flex justify-center align-center">
          <v-col cols="2" class="text-h5 font-weight-bold">종목</v-col>
          <v-col>
            <v-row class="d-flex justify-center align-center">
              <v-col cols="2">
                <v-btn-toggle
                  v-model="newGoal.sportsId"
                  dense
                  small
                  color="deep-orange darken-1"
                  elevation="2"
                  class="d-flex flex-column"
                >
                  <v-btn value="1"> 등산 </v-btn>
                  <v-btn value="2"> 러닝 </v-btn>
                  <v-btn value="3"> 수영 </v-btn>
                  <v-btn value="4"> 자전거 </v-btn>
                  <v-btn value="5"> 헬스 </v-btn>
                </v-btn-toggle>
              </v-col>
              <v-col cols="1">을/를</v-col>
              <v-col cols="2">최소</v-col>
              <v-col cols="3">
                <v-text-field
                  v-model.trim="newGoal.goalTime"
                  type="number"
                  min="1"
                  suffix="시간"
                  name="goalTime"
                  id="time"
                  placeholder="목표 시간"
                  ref="goalTime"
                  oninput="javascript: this.value = this.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' );"
                  @keyup.enter="createGoal"
                  @blur="overOneTime"
                  :rules="[rules.notEmpty]"
                  clearable
                  inline
                />

                <v-text-field
                  v-model.trim="newGoal.goalDistance"
                  type="number"
                  min="1"
                  suffix="m"
                  name="goalDistance"
                  id="time"
                  placeholder="목표 거리"
                  ref="goalDistance"
                  oninput="javascript: this.value = this.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' );"
                  @keyup.enter="createGoal"
                  @blur="overOneDist"
                  :rules="[rules.notEmpty]"
                  clearable
                  inline
                />
              </v-col>
              <v-col cols="2">
                <div>만큼 하자!!</div>
              </v-col>
              <v-col cols="2">
                <v-btn
                  color="primary white--text text-h6"
                  elevation="2"
                  @click="createGoal"
                  >추가하기</v-btn
                >
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-card>

      <v-card class="py-5 my-9">
        <v-row class="d-flex justify-center align-center">
          <v-col cols="2" class="text-h5 font-weight-bold">현재 목표</v-col>
          <v-col>
            <v-row
              v-for="(goal, index) in goals"
              :key="index"
              class="d-flex justify-center align-center"
            >
              <v-col cols="2">{{ goal.sportsId | sportsFilter }}</v-col>
              <v-col cols="1">을/를</v-col>
              <v-col cols="2">일주일에</v-col>
              <v-col cols="1">최소</v-col>
              <v-col cols="2">
                <div>{{ goal.goalTime | timeFilter }}</div>
                <div>{{ goal.goalDistance | distFilter }}</div>
              </v-col>
              <v-col cols="2">하자!!</v-col>
              <v-col cols="2">
                <v-btn
                  color="primary white--text text-h6"
                  elevation="2"
                  @click="updateVisible(index)"
                  >삭제하기</v-btn
                >
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-card>
    </v-container>
  </div>
</template>

<script>
import http from "@/util/http-common.js";
export default {
  name: "TeamGoalUpdate",
  data() {
    return {
      goals: [],
      goal: {
        goalId: "",
        teamId: "",
        sportsId: "",
        goalTime: "",
        goalDistance: "",
      },
      newGoal: {
        // goalId: "",
        teamId: "",
        sportsId: "",
        goalTime: "",
        goalDistance: "",
      },
      rules: {
        notEmpty: (value) => !!value || "필수 항목입니다.",
      },
    };
  },
  created() {
    this.goal.teamId = this.$route.params.teamId;
    this.searchGoal();
  },
  methods: {
    createGoal() {
      console.log(this.newGoal);
      if (!this.newGoal.goalTime) {
        this.$refs.goalTime.focus();
        return;
      }
      if (!this.newGoal.goalDistance) {
        this.$refs.goalDistance.focus();
      }
      if (!this.newGoal.sportsId) {
        alert("종목을 선택해주세요");
        return;}

      if(this.newGoal.goalTime==0 && this.newGoal.goalDistance==0){
        alert("목표 수치를 1개 이상 입력해주세요");
        return;
      }

      let teamId = this.$route.params.teamId;
      console.log(teamId);
      let sportsId = this.newGoal.sportsId;
      let goalTime = this.newGoal.goalTime;
      let goalDistance = this.newGoal.goalDistance;

      for (let index in this.goals) {
        if (sportsId == this.goals[index].sportsId) {
          alert("동일한 스포츠 목표가 존재합니다. 다른 종목을 선택해주세요");
          return;
        }
      }

      http({
        url: "/goal/create/",
        method: "POST",
        data: {
          teamId: teamId,
          sportsId: sportsId,
          goalTime: goalTime,
          goalDistance: goalDistance,
        },
      })
        .then((res) => {
          console.log(res);
          this.searchGoal();
        })
        .catch((err) => {
          console.log(err);
          // console.log(newGoal);
        });
    },
    searchGoal() {
      http({
        url: `/goal/search/${this.$route.params.teamId}`,
        method: "GET",
      })
        .then((res) => {
          console.log(res);
          console.log(res.data);
          this.goals = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateVisible(index) {
      let goalId = this.goals[index].goalId;
      console.log(index);
      console.log(this.goals[index]);
      console.log(goalId);
      http({
        url: `/goal/invisible/${goalId}`,
        method: "PUT",
      })
        .then((res) => {
          console.log(res);
          this.searchGoal();
        })
        .catch((err) => {
          console.log(err);
        });
    },
    overOneTime() {
      if (this.newGoal.goalTime < 0) this.newGoal.goalTime = 0;
    },
    overOneDist() {
      if (this.newGoal.goalDistance < 0) this.newGoal.goalDistance = 0;
    },
  },
};
</script>

<style scoped>
/* .goal-add {
  margin-bottom: 3rem;
} */

/* .inputtd input {
  border: 1px solid black;
  width: 7rem;
} */
</style>
