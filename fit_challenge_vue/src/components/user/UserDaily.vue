<template>
  <div>
    <v-container class="d-flex flex-column">
      <div class="text-h4 text-start"><strong>오늘의 운동 기록</strong></div>
      <v-card outlined class="py-5 my-3">
        <v-row class="d-flex justify-center align-center">
          <v-col cols="2" class="text-h5 font-weight-bold">오늘 나는</v-col>
          <v-col>
            <v-row class="d-flex justify-center align-center">
              <v-col cols="2">
                <v-btn-toggle
                  v-model="sport"
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

              <v-col cols="3">
                <v-text-field
                  v-model.trim="time"
                  type="number"
                  min="1"
                  suffix="시간 동안"
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
                  v-model.trim="dist"
                  type="number"
                  min="1"
                  suffix="m 만큼"
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
                <div>했다!!</div>
              </v-col>
              <v-col cols="3">
                <v-btn
                  color="primary white--text text-h6"
                  elevation="2"
                  @click="addRecord"
                  >목록에 추가하기</v-btn
                >
              </v-col>
            </v-row>
          </v-col>
        </v-row>

        <v-row class="d-flex justify-center align-center">
          <v-col cols="2" class="text-h6 font-weight-bold">나의 코멘트</v-col>
          <v-col cols="7">
            <v-textarea
              v-model.trim="comment"
              outlined
              rows="3"
              name="infoInput"
              ref="infoInput"
            />
          </v-col>
          <v-spacer></v-spacer>
        </v-row>
      </v-card>
    </v-container>
    <v-container>
      <v-card min-height="15rem" class="goal-list">
        <v-row v-for="(rec, index) in records" :key="index" class="text-h6">
          <v-col>오늘 나는</v-col>
          <v-col cols="2">{{ rec.sportsId | sportsFilter }} 을/를 </v-col>
          <v-col cols="3">{{ rec.dailyTime }} 시간 동안 </v-col>
          <v-col cols="3">{{ rec.dailyDistance }} m 만큼 </v-col>
          <v-col cols="2">했다!!</v-col>
          <v-divider vertical class="mx-4"></v-divider>
        </v-row>
      </v-card>
      <br />
      <v-btn
        color="primary white--text text-h6"
        elevation="2"
        @click="resetRecords"
        class="mx-4"
      >
        초기화
      </v-btn>
      <v-btn
        color="primary white--text text-h6"
        elevation="2"
        @click="sendRecords"
      >
        저장하기
      </v-btn>
    </v-container>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "UserDaily",
  data() {
    return {
      sport: "",
      time: "",
      dist: "",
      comment: "",
      records: [],
      rules: {
        notEmpty: (value) => !!value || "필수 항목입니다.",
      },
    };
  },
  methods: {
    overOneTime() {
      if (this.time < 0) this.time = 0;
    },
    overOneDist() {
      if (this.dist < 0) this.dist = 0;
    },
    addRecord() {
      let uId = this.$store.state.loginUser.userId;
      if (!this.sport | !this.time | !this.dist | !this.comment) {
        alert("입력되지 않은 정보를 채워주세요");
        return;
      }
      for (let index in this.records) {
        if (this.sport == this.records[index].sportsId) {
          alert("이미 추가된 운동 입니다");
          return;
        }
      }
      let record = {
        userId: uId,
        sportsId: this.sport,
        dailyTime: this.time,
        dailyDistance: this.dist,
        comment: this.comment,
      };
      console.log(record);
      this.records.push(record);
      this.resetDatas();
    },
    sendRecords() {
      console.log("send");
      let uId = this.$store.state.loginUser.userId;
      let records = this.records;

      if (records.length === 0) {
        alert("저장할 운동 기록이 없습니다.");
        return;
      }

      http({
        url: "/daily/create/dailies",
        method: "POST",
        data: JSON.stringify(records),
      }).then(() => {
        alert("저장 완료");
        this.$router.push(`/user/${uId}`);
      });
    },
    resetDatas() {
      this.sport = "";
      this.time = "";
      this.dist = "";
      this.comment = "";
    },
    resetRecords() {
      this.records = "";
      this.resetDatas();
    },
  },
};
</script>

<style scoped>
input {
  border: 1px solid black;
  width: 7rem;
}
textarea {
  border: 1px solid black;
}
</style>
