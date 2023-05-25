import Vue from "vue";
import Vuex from "vuex";
import router from "@/router";

import http from "@/util/http-common";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    teams: [],
    team: {},
    loginUser: null,

    //팀 뷰에서 사용
    userCards: [],
    goals: [],
  },
  getters: {
    getTeams(state) {
      return state.teams;
    },
    getTeam(state) {
      return state.team;
    },
    getLoginUser(state) {
      return state.loginUser;
    },

    getUserCards(state) {
      return state.userCards;
    },
    getGoals(state) {
      return state.goals;
    },
  },
  mutations: {
    USER_LOGIN(state, payload) {
      state.loginUser = payload;
    },
    USER_LOGOUT(state) {
      state.loginUser = null;
    },
    SAVE_LOGINUSER_TO_SESSION(state) {
      sessionStorage.setItem("loginUser", JSON.stringify(state.loginUser));
    },
    READ_LOGINUSER_FROM_SESSION(state) {
      if (sessionStorage.getItem("loginUser"))
        state.loginUser = JSON.parse(sessionStorage.getItem("loginUser"));
    },

    GET_TEAMS(state, payload) {
      state.teams = payload;
    },
    GET_TEAM(state, payload) {
      state.team = payload;
    },

    //팀메인 사용
    GET_USERCARDS(state, payload) {
      state.userCards = payload;
    },
    GET_GOALS(state, payload) {
      state.goals = payload;
    },

    //팀생성 후 팀아이디 업데이트
    SAVE_TEAMID(state, payload) {
      state.loginUser.teamId = payload;
    },
    //팀 생성 후 팀장 여부 true로 표시
    TRUE_ISOWNER(state) {
      state.loginUser.isOwner = true;
    },
  },
  actions: {
    //로그인된 유저 세션에서 읽어오기
    doReadLoginUser(context) {
      context.commit("READ_LOGINUSER_FROM_SESSION");
    },
    // 유저 로그인
    userLogin(context, user) {
      http({
        url: "/user/login",
        method: "POST",
        data: {
          userId: user.id,
          password: user.password,
        },
      })
        .then((res) => {
          // console.log(res);

          sessionStorage.setItem("access-token", res.data["access-token"]);

          let loginUser = {
            userId: res.data.userId,
            nickname: res.data.nickname,
            teamId: res.data.teamId,
            isOwner: res.data.isOwner,
          };

          context.commit("USER_LOGIN", loginUser);
          context.commit("SAVE_LOGINUSER_TO_SESSION", loginUser);
          router.push("/home/main");
        })
        .catch((err) => {
          console.log(err);
          // 400 Bad Request 에러인 경우
          if (err.response.status === 400) {
            let errMsg = err.response.data.message;
            console.log(errMsg);
            if(errMsg==="wrong password" || "not user")
              alert("아이디 혹은 비밀번호를 확인해주세요");

          }
        });
    },
    //유저 로그아웃
    userLogout(context) {
      sessionStorage.removeItem("access-token");
      sessionStorage.removeItem("loginUser");
      context.commit("USER_LOGOUT");
    },
    //유저 id에 맞는 유저 정보 가져오기
    getUser(context, userId) {
      http({
        url: `/user/detail/${userId}`,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      }).then((res) => {
        context.commit("GET_USER", res.date);
      });
    },

    //팀 메인에 표시할 정보 가져오기
    getTeamMain(context, teamId) {
      http({
        url: `/team/main/${teamId}`,
        method: "GET",
      })
        .then((res) => {
          console.log(res);
          context.commit("GET_TEAM", res.data["team"]);
          context.commit("GET_USERCARDS", res.data["clist"]);
          context.commit("GET_GOALS", res.data["glist"]);
        })
        .catch((err) => {
          // console.log(res);
          console.log(err);
        });
    },

    // 팀 검색
    searchTeams(context, payload) {
      console.log(payload);
      http({
        url: `/team/search/${payload.word}/${payload.orderBy}`,
        method: "GET",
      })
        .then((res) => {
          console.log(res);
          context.commit("GET_TEAMS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    //팀 아이디에 해당하는 정보 받아오기
    getTeam(context, payload) {
      http({
        url: `/team/${payload}`,
        method: "GET",
      }).then((res) => {
        console.log(res);
        context.commit("GET_TEAM", res.data);
      });
    },
    //팀 생성 후 loginUser에 teamId 업뎃하기
    updateTeamId(context, payload) {
      context.commit("SAVE_TEAMID", payload);
    },
    //팀 생성 후 팀장 여부 업뎃하기
    updateOwner(context) {
      context.commit("TRUE_OWNER");
    },

    //전체 팀 정보 가져오기
    searchAllTeams(context) {
      http({
        url: `/team`,
        method: "GET",
      }).then((res) => {
        console.log(res);
        context.commit("GET_TEAMS", res.data);
      });
    },
  },
  modules: {},
});
