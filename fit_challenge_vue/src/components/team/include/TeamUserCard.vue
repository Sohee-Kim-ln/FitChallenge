<template>
  <div>
    <v-card
      class="mx-10 my-12"
      width="350"
      min-height=""
      @click="moveToUserInfo"
    >
      <v-row class="ma-2">
        <v-card-title class="text-h5">{{ nickname }}</v-card-title>
        <v-spacer></v-spacer>
        <div class="d-flex justify-center align-center">
          <v-chip color="green" text-color="white">
            {{ archieve | archieveFilter }}
          </v-chip>
        </div>
      </v-row>
      <v-img
        width="auto"
        height="170"
        src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
      />
      
      <v-card-title>이번 주 운동</v-card-title>
      <v-divider class="mx-4"></v-divider>
      <v-card-text>
        <div v-if="weeklys.length === 0">이번주 운동 기록이 없습니다</div>
        <div v-for="(weekly, index) in weeklys" :key="index">
          <!-- {{ weekly }} -->

          <v-row class="ma-2">
            <v-col cols="3" class="font-weight-bold">
              {{ weekly.sportsId | sportsFilter }}
            </v-col>
            <v-col cols="3"> {{ weekly.timeSum | timeFilter }}</v-col>
            <v-col cols="3">
              <span v-show="weekly.sportsId < 5">
                {{ weekly.distanceSum | distFilter }}
              </span>
            </v-col>
            <v-col cols="3">
              <v-chip color="green" text-color="white">
                {{ weekly.weeklyAchieve | archieveFilter }}
              </v-chip></v-col
            >
          </v-row>
        </div>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "TeamUserCard",
  props: {
    img: String,
    nickname: String,
    archieve: Number,
    weeklys: Array,
    userId: String,
  },
  computed: {
    ...mapState(["loginUser"]),
  },
  data() {
    return {};
  },
  methods: {
    moveToUserInfo() {
      if (!this.loginUser) {
        alert("로그인 후 열람이 가능합니다.");
        return;
      }
      console.log(this.userId);
      let url = "/user/" + this.userId + "/info";
      this.$router.push(url);
    },
  },
};
</script>

<style></style>
