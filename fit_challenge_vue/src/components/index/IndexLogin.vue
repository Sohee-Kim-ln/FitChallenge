<template>
  <div class="container">
    <!-- <v-container class="grey lighten-5"> -->
    <v-container mt-16>
      <h1>로그인</h1>
      <v-row no-gutters >
        <v-spacer/>
        <v-col cols="12" sm="7" md="5" lg="4" class="d-flex flex-column">
          <label for="idInput" class="text-start">아이디</label>
          <v-text-field
            v-model.trim="user.id"
            type="text"
            name="idInput"
            placeholder="아이디를 입력해주세요"
            clearable
            ref="idInput"
          />
          <label for="pwInput" class="text-start">비밀번호</label>
          <v-text-field
            v-model.trim="user.password"
            :append-icon="pwShow ? 'mdi-eye' : 'mdi-eye-off'"
            :type="pwShow ? 'text' : 'password'"
            name="pwInput"
            placeholder="비밀번호를 입력해주세요"
            clearable
            @click:append="pwShow = !pwShow"
            ref="pwInput"
            @keyup.enter="login"
          />
          <v-btn color="primary" elevation="2" @click="login">로그인</v-btn>
        </v-col>
        <v-spacer/>
      </v-row>
      
    </v-container>
  </div>
</template>

<script>
export default {
  name: "IndexLogin",
  data() {
    return {
      user: {
        id: "",
        password: "",
      },
      pwShow: false,
    };
  },
  methods: {
    login() {
      if (!this.user.id) {
        alert("아이디를 입력해주세요");
        this.$refs.idInput.focus();
        return;
      }
      if (!this.user.password) {
        alert("비밀번호를 입력해주세요");
        this.$refs.pwInput.focus();
        return;
      }
      this.$store.dispatch("userLogin", this.user);
    },
  },
};
</script>

<style scoped>
  /* .container{
    width: 400px;
  } */
</style>
