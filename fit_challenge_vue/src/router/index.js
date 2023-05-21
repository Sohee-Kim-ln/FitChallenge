import Vue from 'vue'
import VueRouter from 'vue-router'

import IndexView from '@/views/IndexView.vue'
import HomeView from '../views/HomeView.vue'
import UserView from '../views/UserView.vue'
import TeamView from '../views/TeamView.vue'
import SearchView from "@/views/SearchView.vue"

import IndexInfo from "@/components/index/IndexInfo.vue"
import IndexLogin from "@/components/index/IndexLogin.vue"
import IndexSignUp from "@/components/index/IndexSignUp.vue"

import UserChart from "@/components/user/UserChart.vue"
import UserDaily from "@/components/user/UserDaily.vue"
import UserInfo from "@/components/user/UserInfo.vue"
import UserRecord from "@/components/user/UserRecord.vue"

import TeamMain from "@/components/team/TeamMain.vue"
import TeamInfo from "@/components/team/TeamInfo.vue"
import TeamGoalUpdate from "@/components/team/TeamGoalUpdate.vue"
import TeamRecord from "@/components/team/TeamRecord.vue"

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'index',
    component: IndexView,
    children: [
      {
        path: "",
        name: "indexInfo",
        component: IndexInfo,
      },
      {
        path: "login",
        name:"indexLogin",
        component: IndexLogin,
      },
      {
        path:"signup",
        name:"indexSignUp",
        component: IndexSignUp,
      },
    ],
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView,
    children:[
      // {
      //   path:""
      // },
    ],
  },
  {
    path: '/user',
    name: 'user',
    component: UserView,
    children: [
      {
        path: '',
        name: 'userMain',
        component: UserChart,
        // component: () => import('@/')
      },
      {
        path:"info",
        name:"userInfo",
        component: UserInfo,
      },
      {
        path:"record",
        name:"userRecord",
        component: UserRecord,
      },
      {
        path:"daily",
        name:"userDaily",
        component: UserDaily,
      }
    ],
  },
  {
    path: '/team',
    name: 'team',
    component: TeamView,
    children: [
      {
        path: '',
        name: 'teamMain',
        component:TeamMain,
      },
      {
        path:"info",
        name:"teamInfo",
        component:TeamInfo,
      },
      {
        path:"record",
        name:"teamRecord",
        component:TeamRecord,
      },
      {
        path:"goalUpdate",
        name:"teamGoalUpdate",
        component: TeamGoalUpdate,
      }

    ],
  },
  {
    path:"/search",
    name: "search",
    component:SearchView,
  },
  
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
