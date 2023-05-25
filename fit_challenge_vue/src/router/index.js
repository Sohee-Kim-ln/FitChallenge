import Vue from "vue";
import VueRouter from "vue-router";

import IndexView from "@/views/IndexView.vue";
import HomeView from "@/views/HomeView.vue";
import UserView from "@/views/UserView.vue";
import TeamView from "@/views/TeamView.vue";
import SearchView from "@/views/SearchView.vue";
import WriteView from "@/views/WriteView.vue";

import IndexInfo from "@/components/index/IndexInfo.vue";
import IndexLogin from "@/components/index/IndexLogin.vue";
import IndexSignUp from "@/components/index/IndexSignUp.vue";

import HomeOrigin from "@/components/home/HomeOrigin.vue";
import HomeLogined from "@/components/home/HomeLogined.vue";

import UserChart from "@/components/user/UserChart.vue";
import UserDaily from "@/components/user/UserDaily.vue";
import UserInfo from "@/components/user/UserInfo.vue";
import UserRecord from "@/components/user/UserRecord.vue";

import TeamMain from "@/components/team/TeamMain.vue";
import TeamInfo from "@/components/team/TeamInfo.vue";
import TeamGoalUpdate from "@/components/team/TeamGoalUpdate.vue";
import TeamRecord from "@/components/team/TeamRecord.vue";

import WriteTeamInfoUpdate from "@/components/write/WriteTeamInfoUpdate.vue";
import WriteTeamRegist from "@/components/write/WriteTeamRegist.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "index",
    component: IndexView,
    children: [
      {
        path: "",
        name: "indexInfo",
        component: IndexInfo,
      },
      {
        path: "login",
        name: "indexLogin",
        component: IndexLogin,
      },
      {
        path: "signup",
        name: "indexSignUp",
        component: IndexSignUp,
      },
    ],
  },
  {
    path: "/home",
    name: "home",
    component: HomeView,
    children: [
      {
        path: "main",
        name: "homeOrigin",
        component: HomeOrigin,
      },
      // {
      //   path: "main",
      //   name: "homeLogined",
      //   component: HomeLogined,
      // },
    ],
  },
  {
    path:"/user",
    name:"goHome",
    component:HomeView,
  },
  {
    path: "/user/:userId",
    name: "user",
    component: UserView,
    children: [
      {
        path: "",
        name: "goUserMain",
        component: UserChart,
      },
      {
        path: "main",
        name: "userMain",
        component: UserChart,
      },
      {
        path: "info",
        name: "userInfo",
        component: UserInfo,
      },
      {
        path: "record",
        name: "userRecord",
        component: UserRecord,
      },
      {
        path: "daily",
        name: "userDaily",
        component: UserDaily,
      },
    ],
  },
  {
    path: "/team",
    name: "goSearch",
    component: SearchView,
  },
  {
    path: "/team/:teamId",
    name: "team",
    component: TeamView,
    children: [
      {
        path: "",
        name: "goTeamMain",
        component: TeamMain,
      },
      {
        path: "main",
        name: "teamMain",
        component: TeamMain,
      },
      {
        path: "info",
        name: "teamInfo",
        component: TeamInfo,
      },
      {
        path: "record",
        name: "teamRecord",
        component: TeamRecord,
      },
      {
        path: "goalUpdate",
        name: "teamGoalUpdate",
        component: TeamGoalUpdate,
      },
    ],
  },
  {
    path: "/search",
    name: "search",
    component: SearchView,
  },
  {
    path: "/write",
    name: "write",
    component: WriteView,
    children: [
      {
        path: "",
        name: "goWriteTeamRegist",
        component: WriteTeamRegist,
      },
      {
        path: "teamRegist",
        name: "writeTeamRegist",
        component: WriteTeamRegist,
      },
      {
        path: "teamInfoUpdate",
        name: "writeTeamInfoUpdate",
        component: WriteTeamInfoUpdate,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
