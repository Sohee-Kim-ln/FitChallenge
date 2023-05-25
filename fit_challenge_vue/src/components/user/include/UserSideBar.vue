<template>
  <div class>
    <v-container class="d-flex flex-column justify-center align-center">
      <v-img
        width="auto"
        height="auto"
        max-width="200"
        max-height="200"
        src="@/assets/sports/weight.png"
        alt="유저 이미지"
        class="team-image py-8"
      ></v-img>
      <h1 class="my-10">{{ loginUser.nickname }}</h1>

      <v-item-group>
        <v-item v-slot="{ active }" class="my-6">
          <v-card
            :color="active ? 'deep-orange lighten-3 ' : ''"
            class="d-flex align-center"
            width="130"
            height="40"
            @click="moveToMain"
          >
            <div class="flex-grow-1 text-center" :color="active ? 'white' : ''">
              <strong>운동 통계</strong>
            </div>
          </v-card>
        </v-item>
        <v-item v-slot="{ active }" class="my-6">
          <v-card
            :color="active ? 'deep-orange lighten-3 ' : ''"
            class="d-flex align-center"
            width="130"
            height="40"
            @click="moveToInfo"
          >
            <div class="flex-grow-1 text-center" :color="active ? 'white' : ''">
              <strong>개인 상세 정보</strong>
            </div>
          </v-card>
        </v-item>
        <v-item v-slot="{ active }" class="my-6">
          <v-card
            :color="active ? 'deep-orange lighten-3 ' : ''"
            class="d-flex align-center"
            width="130"
            height="40"
            @click="moveToRecord"
          >
            <div class="flex-grow-1 text-center">
              <strong>운동 일지</strong>
            </div>
          </v-card>
        </v-item>
        <v-item v-slot="{ active }" class="my-6">
          <v-card
            :color="active ? 'deep-orange lighten-3 ' : ''"
            class="d-flex align-center"
            width="130"
            height="40"
            @click="moveToDaily"
          >
            <div class="flex-grow-1 text-center">
              <strong>운동 기록하기</strong>
            </div>
          </v-card>
        </v-item>
      </v-item-group>

      <!-- <v-container>
        <v-btn-toggle
          v-model="toggle_exclusive"
          class="d-flex flex-column justify-center align-center"
          color="deep-orange lighten-3"
        >
          <v-btn max-width="200" @click="moveToGoal"> 팀 주간 목표 </v-btn>
          <v-btn max-width="200" @click="moveToInfo"> 팀 상세 정보</v-btn>
          <v-btn max-width="200" @click="moveToRecord"> 팀 운동 일지 </v-btn>
        </v-btn-toggle>
      </v-container> -->
    </v-container>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: "UserSideBar",
  computed:{
    ...mapState(["loginUser"]),
  },
  methods: {
    moveToMain() {
      const targetPath = `/user/${this.$store.state.loginUser.userId}/main`;
      if (this.$route.path !== targetPath) {
        this.$router.push(targetPath);
      }
    },
    moveToInfo() {
      const targetPath = `/user/${this.$store.state.loginUser.userId}/info`;
      if (this.$route.path !== targetPath) {
        this.$router.push(targetPath);
      }
    },
    moveToRecord() {
      const targetPath = `/user/${this.$store.state.loginUser.userId}/record`;
      if (this.$route.path !== targetPath) {
        this.$router.push(targetPath);
      }
    },
    moveToDaily() {
      const targetPath = `/user/${this.$store.state.loginUser.userId}/daily`;
      if (this.$route.path !== targetPath) {
        this.$router.push(targetPath);
      }
    },
  },
};
</script>

<style scoped>
.user-logo {
  width: 10rem;
  height: 10rem;
}
</style>
