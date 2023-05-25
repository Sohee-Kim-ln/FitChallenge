<template>
  <div>
    <v-container mt-16>
      <h1>팀 생성</h1>
      <v-row no-gutters>
        <v-spacer />
        <v-col cols="12" sm="7" md="5" lg="4" class="d-flex flex-column">
          <label for="idInput" class="text-start">팀 명</label>
          <v-text-field
            v-model.trim="team.name"
            type="text"
            name="nameInput"
            clearable
            ref="nameInput"
            @keyup.enter="login"
            :rules="[rules.notEmpty]"
          />
          <v-text-field
            v-model.trim="team.max"
            type="number"
            min="2"
            max="100"
            suffix="명"
            name="maxInput"
            placeholder="최대 인원"
            ref="maxInput"
            oninput="javascript: this.value = this.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' );"
            @keyup.enter="createTeam"
            @blur="[underHundred(), overTwo()]"
            :rules="[rules.notEmpty]"
          />
          <label for="infoInput" class="text-start">팀 설명</label>
          <v-textarea
            v-model.trim="team.info"
            outlined
            name="infoInput"
            ref="infoInput"
            :rules="[rules.notEmpty]"
          />

          <v-btn color="primary" elevation="2" @click="createTeam"
            >팀 생성하기</v-btn
          >
        </v-col>
        <v-spacer />
      </v-row>
    </v-container>
  </div>
</template>

<script>
import http from "@/util/http-common";
import { mapState } from "vuex";
export default {
  name: "WriteTeamRegist",
  data() {
    return {
      team: {
        name: "",
        max: "",
        info: "",
        // announce: "",
        teamImgOrg: "",
      },
      rules: {
        notEmpty: (value) => !!value || "필수 항목입니다.",
      },
    };
  },
  computed: {
    ...mapState(["loginUser"]),
  },
  methods: {
    underHundred() {
      if (this.team.max > 100) this.team.max = 100;
    },
    overTwo() {
      if (this.team.max < 2) this.team.max = 2;
    },
    createTeam() {
      if (!this.team.name) {
        this.$refs.nameInput.focus();
        return;
      }
      if (!this.team.max) {
        this.$refs.maxInput.focus();
        return;
      }
      if (!this.team.info) {
        this.$refs.infoInput.focus();
        return;
      }

      let uId = this.loginUser.userId;

      let teamName = this.team.name;
      let maxCapacity = this.team.max;
      let info = this.team.info;
      http({
        url: "/team/create",
        method: "POST",
        data: {
          teamName: teamName,
          maxCapacity: maxCapacity,
          info: info,
          userId:uId,
        },
      }).then((res) => {
        this.$store.dispatch("updateTeamId", res.data);
        this.$store.dispatch("updateOwner");
        alert("팀 생성이 완료되었습니다.");
        this.$router.push(`/team/${res.data}`);
      }).catch((err)=>{
        console.log(err);
      });
    },
  },
};
</script>

<style></style>
