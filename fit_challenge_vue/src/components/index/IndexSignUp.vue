<template>
  <div class="container">
    <v-container mt-3>
      <h1>회원가입</h1>
      <v-row no-gutters>
        <v-spacer />
        <v-col cols="12" sm="7" md="5" lg="4" class="d-flex flex-column">
          <label for="idInput" class="text-start">아이디</label>
          <v-text-field
            v-model.trim="user.id"
            type="text"
            name="idInput"
            clearable
            ref="idInput"
          />
          <label for="pwInput" class="text-start">비밀번호</label>
          <v-text-field
            v-model.trim="user.password"
            :append-icon="pwShow ? 'mdi-eye' : 'mdi-eye-off'"
            :type="pwShow ? 'text' : 'password'"
            name="pwInput"
            clearable
            @click:append="pwShow = !pwShow"
            ref="pwInput"
          />
          <label for="pwcInput" class="text-start">비밀번호 재확인</label>
          <v-text-field
            v-model.trim="passwordConfirm"
            :append-icon="pwcShow ? 'mdi-eye' : 'mdi-eye-off'"
            :type="pwcShow ? 'text' : 'password'"
            name="pwcInput"
            clearable
            @click:append="pwcShow = !pwcShow"
            ref="pwcInput"
          />
          <label for="nameInput" class="text-start">이름</label>
          <v-text-field
            v-model.trim="user.name"
            name="nameInput"
            clearable
            ref="nameInput"
          />
          <label for="nickInput" class="text-start">닉네임</label>
          <v-text-field
            v-model.trim="user.nickname"
            name="nickInput"
            clearable
            ref="nickInput"
          />
          <v-row>
            <v-col cols="6">
              <v-menu
                v-model="calendarShow"
                :close-on-content-click="false"
                :nudge-right="40"
                transition="scale-transition"
                offset-y
                min-width="auto"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-text-field
                    v-model="user.birthDate"
                    label="생년월일"
                    prepend-icon="mdi-calendar"
                    readonly
                    v-bind="attrs"
                    v-on="on"
                  />
                </template>
                <v-date-picker
                  v-model="user.birthDate"
                  @input="calendarShow = false"
                />
              </v-menu>
            </v-col>
            <v-col>
              <v-select
                :items="genderItems"
                v-model="user.gender"
                label="성별"
                name="genderInput"
                solo
              />
            </v-col>
          </v-row>

          <v-btn color="primary" elevation="2" @click="signup">가입하기</v-btn>
        </v-col>
        <v-spacer />
      </v-row>
    </v-container>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "IndexSignUp",
  data() {
    return {
      user: {
        id: "",
        password: "",
        name: "",
        nickname: "",
        birthDate: "",
        gender: "",
        //img:null,//후순위 구현
      },
      passwordConfirm: "",
      pwShow: false,
      pwcShow: false,
      genderItems: ["선택안함", "남성", "여성"],
      calendarShow: false,
    };
  },
  methods: {
    signup() {
      let genderCode = "";
      if (this.user.gender === "남성") genderCode = 0;
      else if (this.user.gender === "여성") genderCode = 1;
      else if (this.user.gender === "선택안함")genderCode=2;
      
      if (
        !this.user.id |
        !this.user.password |
        !this.passwordConfirm |
        !this.user.name |
        !this.user.nickname |
        !this.user.birthDate |
        !this.user.gender
      ) {
        alert("입력되지 않은 필수 정보가 있습니다.");
        console.log(this.user);
        return;
      }

      if (this.user.password !== this.passwordConfirm) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
      }


      http({
        url: "/user/create",
        method: "POST",
        data: {
          userId: this.user.id,
          password: this.user.password,
          userName: this.user.name,
          nickname: this.user.nickname,
          birthDate: this.user.birthDate,
          gender: genderCode,
        },
      }).then((res) => {
        console.log(res.data);
        let msg = "회원 가입을 하지 못했습니다.";
        if (res.data === "success") {
          msg = "회원 가입이 완료되었습니다.";
        } else if (res.data === "same id") {
          msg = "동일한 아이디가 이미 존재합니다.";
        }

        alert(msg);

        if (res.data === "success") {
          this.$router.push("/home");
        }
      });
    },
  },
};
</script>

<style></style>
