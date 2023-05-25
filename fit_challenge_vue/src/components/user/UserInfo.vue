<template>
  <div>
    <div class="container">
      <div class="text-h4 text-start">
        <strong v-if="user.userId===loginUser.userId">나의 팀</strong>
        <strong v-if="user.userId!==loginUser.userId">{{user.nickname}}님의 팀</strong>

        <v-chip v-if="user.owner" color="green" text-color="white">
          운영중
        </v-chip>
      </div>
      <div class="text-h6">
        <v-container>
          <v-row>
            <v-img
              width="auto"
              height="auto"
              max-width="80"
              max-height="80"
              src="@/assets/sports/weight.png"
              alt="팀 이미지"
              class="team-image py-8"
            ></v-img>

            <v-col class="text-start d-flex align-center">
              {{ team.teamName }}
            </v-col>
          </v-row>
        </v-container>
      </div>
    </div>

    <div class="container">
      <div class="text-h4 text-start"><strong>{{ user.nickname }}님의 정보</strong></div>
      <div class="text-h6">
        <v-container>
          <v-row>
            <v-col cols="2" class="text-start"> 아이디</v-col>
            <v-col class="text-start"> {{ user.userId }}</v-col>
          </v-row>
          <v-row>
            <v-col cols="2" class="text-start"> 이름</v-col>
            <v-col class="text-start"> {{ user.userName }}</v-col>
          </v-row>
          <v-row>
            <v-col cols="2" class="text-start"> 닉네임</v-col>
            <v-col class="text-start"> {{ user.nickname }}</v-col>
          </v-row>
          <v-row>
            <v-col cols="2" class="text-start"> 생년월일</v-col>
            <v-col class="text-start"> {{ user.birthDate }}</v-col>
          </v-row>
          <v-row>
            <v-col cols="2" class="text-start"> 성별</v-col>
            <v-col class="text-start"> {{ user.gender | genderFilter }}</v-col>
          </v-row>
          <v-row>
            <v-col cols="2" class="text-start"> 최근 접속일</v-col>
            <v-col class="text-start"> {{ user.recentLogin }}</v-col>
          </v-row>
        </v-container>
      </div>
    </div>
    <div>
      <!-- 구현 후순위 -->
      <!-- 
      <button>회원탈퇴</button>
      <button>수정하기</button>
       -->
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import { mapState } from "vuex";

export default {
  name: "UserInfo",
  data() {
    return {
      user: "",
    };
  },
  created() {
    http({
      url: `user/detail/${this.$route.params.userId}`,
      method: "GET",
    })
      .then((res) => {
        console.log("get user");
        console.log(res);
        this.user = res.data;
      })
      .then(() => {
        this.$store.dispatch("getTeam", this.user.teamId);
      });
  },
  computed: {
    ...mapState(["loginUser"]),
    ...mapState(["team"]),
  },
  methods: {
    ownerChip() {
      // if(this.user.owner)
      // return true;
      // else return false;
      // return false;
    },
  },
};
</script>

<style></style>
