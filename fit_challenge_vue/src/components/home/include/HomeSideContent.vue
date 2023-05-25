<template>
  <v-card width="80%">
    <v-responsive
      :aspect-ratio="9 / 8"
      class="d-flex align-start justify-center align-center" 
    >
      <v-row class="d-flex flex-column justify-space-around" height="80%">
        <a @click="search" class="text-h5 font-weight-black my-4 deep-orange--text">팀 검색</a>

        <a @click="moveToTeam" class="text-h5 font-weight-black my-4 deep-orange--text">마이 팀</a>

        <a @click="mypage" class="text-h5 font-weight-black my-4 deep-orange--text">마이 페이지</a>
        <a @click="regist" class="text-h5 font-weight-black my-4 deep-orange--text"
          >오늘의 운동 기록</a
        >

        <a @click="logout" v-if="loginUser" class="text-h5 font-weight-black my-4  deep-orange--text">로그아웃</a>
      </v-row>
    </v-responsive>
  </v-card>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState(["loginUser"]),
  },
  methods: {
    search() {
      if (this.$route.path !== "/search") {
        this.$router.push("/search");
      }
    },
    logout() {
      this.$store.dispatch("userLogout");
      alert("로그아웃 되었습니다.");
      if (this.$route.path !== "/home/main") {
        this.$router.push("/home/main");
      }
    },
    moveToTeam() {
      let loginUser = this.$store.state.loginUser;
      if(!loginUser){
        alert("로그인이 필요합니다.");
        return;
      }
      if (!loginUser.teamId) {
        alert("가입된 팀이 없습니다.");
        return;
      }
      let url = "/team/" + this.loginUser.teamId;
      this.$router.push(url);
    },
    mypage() {
      let loginUser = this.$store.state.loginUser;
      if (!loginUser) {
        alert("로그인이 필요합니다.");
        return;
      }
      let url = "/user/" + loginUser.userId;
      this.$router.push(url);
    },
    regist() {
      let loginUser = this.$store.state.loginUser;
      if (!loginUser) {
        alert("로그인이 필요합니다.");
        return;
      }

      let url = "/user/" + loginUser.userId + "/daily";
      this.$router.push(url);
    },
  },
};
</script>

<style scoped>
a {
  color: #ff5722;
}
</style>
