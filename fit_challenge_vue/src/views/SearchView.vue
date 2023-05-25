<template>
  <div>
    <!-- 로그인 상태 따라서 달라짐 -->
    <header-nav-login />
    <v-container>
      <!-- <v-row no-gutters>
        <v-col>
          <div>
            <input type="checkbox" value="" />헬스
            <input type="checkbox" value="" />러닝
            <input type="checkbox" value="" />수영
            <input type="checkbox" value="" />등산
            <input type="checkbox" value="" />사이클
          </div> 
        </v-col>
      </v-row> -->
      <v-row >
        <v-col class="d-flex align-center">
          <v-text-field
            v-model.trim="word"
            type="text"
            id="team-name"
            name="team-name"
            placeholder="팀 이름 검색"
            clearable
            outlined
            ref="idInput"
            @keyup.enter="searchTeams"
            height="60"
          />
        </v-col>
        <v-col cols="3">
          <v-select
            :items="orderOptions"
            v-model="orderBy"
            label="정렬 순서"
            item-text="orderText"
            item-value="orderValue"
            name="sort-by"
            solo
            height="60"
          />
        </v-col>
        <v-btn color="primary" elevation="2" @click="searchTeams" class="ma-5" height="60">검색</v-btn>
        <v-btn color="primary" elevation="2" @click="createTeam" class="ma-5" height="60">팀 생성</v-btn>
      </v-row>
    </v-container>
    <search-list/>
  </div>
</template>

<script>
import { mapState } from "vuex";
import HeaderNavLogin from "@/components/common/HeaderNavLogin.vue";
import SearchList from "@/components/search/SearchList.vue";

export default {
  components: {
    HeaderNavLogin,
    SearchList,
  },
  data() {
    return {
      word: "",
      orderBy: "curCapacity DESC",
      orderOptions: [
        {
          orderText: "인원많은순",
          orderValue: "curCapacity DESC",
        },
        {
          orderText: "인원적은순",
          orderValue: "curCapacity ASC",
        },
        {
          orderText: "오래된순",
          orderValue: "createTime ASC",
        },
        {
          orderText: "최신순",
          orderValue: "createTime DESC",
        },
      ],
    };
  },
  computed: {
    ...mapState(["teams"]),
    ...mapState(["loginUser"]),
  },
  created() {
    this.$store.dispatch("searchAllTeams");
  },
  methods: {
    searchTeams() {
      if (this.word === "")
      this.$store.dispatch("searchAllTeams");
      else
        this.$store.dispatch("searchTeams", {
          word: this.word,
          orderBy: this.orderBy,
        });
    },
    // 팀 생성
    createTeam() {
      if(!this.loginUser){
        alert("로그인이 필요합니다");
        return;
      }
      if(this.loginUser.teamId){
        alert("이미 가입된 팀이 있습니다");
        return;
      }
      this.$router.push("/write/teamRegist")
    },
  },
};
</script>

<style></style>
