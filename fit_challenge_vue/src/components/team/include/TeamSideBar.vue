<template>
  <div class>
    <v-container class="d-flex flex-column justify-center align-center">
      <v-img
        width="auto"
        height="auto"
        max-width="200"
        max-height="200"
        src="@/assets/sports/weight.png"
        alt="팀 이미지"
        class="team-image py-8"
      ></v-img>

      <h1 class="my-10" v-if="loginUser.teamId !== team.teamId">
        {{ team.teamName }}
      </h1>
      <h1 class="my-10" v-if="loginUser.teamId === team.teamId">
        <v-badge bordered color="deep-orange lighten-1">
          {{ team.teamName }}
        </v-badge>
      </h1>

      <v-item-group>
        <v-item v-slot="{ active }" class="my-6">
          <v-card
            :color="active ? 'deep-orange lighten-3 ' : ''"
            class="d-flex align-center"
            width="130"
            height="40"
            @click="moveToGoal"
          >
            <div class="flex-grow-1 text-center" :color="active ? 'white' : ''">
              <strong>팀 주간 목표</strong>
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
            <div class="flex-grow-1 text-center">
              <strong>팀 상세 정보</strong>
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
              <strong>팀 운동 일지</strong>
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
    </v-container>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "TeamSideBar",
  computed: {
    ...mapState(["team"]),
    ...mapState(["loginUser"]),
  },
  methods: {
    moveToGoal() {
      const targetPath = `/team/${this.team.teamId}`;
      if (this.$route.path !== targetPath) {
        this.$router.push(targetPath);
      }
    },
    moveToInfo() {
      const targetPath = `/team/${this.team.teamId}/info`;
      if (this.$route.path !== targetPath) {
        this.$router.push(targetPath);
      }
    },
    moveToRecord() {
      const targetPath = `/team/${this.team.teamId}/record`;
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

<style scoped></style>
