<template>
  <header class="deep-orange lighten-1">
    <nav class="header-nav">
      <div class="header-logo">
        <router-link
          :to="{ name: 'homeOrigin' }"
          class="logo text-decoration-underline font-italic"
          >Fit Challenge</router-link
        >
      </div>
      <div class="navigation d-flex justify-center align-center">
        <span v-if="loginUser" class="text-h5 white--text mx-10"
          >{{ loginUser.nickname }}님 환영합니다!</span
        >

        <!-- 로그인 했으면 -->
        <v-icon class="mx-3" large color="white darken-2" @click="search">
          mdi-magnify
        </v-icon>
        <v-icon
          class="mx-3"
          large
          color="white darken-2"
          v-if="loginUser"
          @click="team"
        >
          mdi-account-group
        </v-icon>
        <v-icon
          class="mx-3"
          large
          color="white darken-2"
          v-if="loginUser"
          @click="mypage"
        >
          mdi-account-box
        </v-icon>

        <!-- 로그아웃 했으면 -->
        <router-link
          :to="{ name: 'indexSignUp' }"
          v-if="!loginUser"
          class="text-h5 font-weight-black"
          >회원가입</router-link
        >

        <v-icon large color="white darken-2" v-if="loginUser" @click="logout">
          mdi-logout
        </v-icon>
        <router-link
          :to="{ name: 'indexLogin' }"
          v-if="!loginUser"
          class="text-h5 font-weight-black"
          >로그인</router-link
        >
      </div>
    </nav>
  </header>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "HeaderNavLogin",
  data() {
    return {};
  },
  computed: {
    ...mapState(["loginUser"]),
  },
  created() {},
  methods: {
    logout() {
      this.$store.dispatch("userLogout");
      alert("로그아웃 되었습니다.");
      if (this.$route.path !== "/home/main") {
        this.$router.push("/home/main");
      }
    },
    search() {
      if (this.$route.path !== "/search") {
        this.$router.push("/search");
      }
    },
    team() {
      let loginUser = this.$store.state.loginUser;
      if (!loginUser.teamId) {
        alert("가입된 팀이 없습니다.");
        return;
      }
      let url = "/team/" + this.loginUser.teamId;

      // if (this.$route.path !== url) {
      //   this.$router.replace(url);
      // }

      this.$router.push(url);
      this.$nextTick(() => {
        window.location.reload();
      });
    },
    mypage() {
      let loginUser = this.$store.state.loginUser;
      if (!loginUser) {
        alert("로그인이 필요합니다.");
        return;
      }

      let url = "/user/" + loginUser.userId;

      if (this.$route.path !== url) {
        this.$router.push(url);
      }
    },
  },
};
</script>

<style scoped>
/* header 태그 안에 CSS 속성 */
header {
  height: 70px;
  background-color: skyblue;
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  text-decoration: none;
  color: white;

  display: block;
  float: left;

  padding: 0 1rem;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
}
</style>
