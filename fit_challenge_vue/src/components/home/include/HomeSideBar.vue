<template>
  <div class="deep-orange lighten-3 h100 d-flex flex-column align-center">
    <!-- 로그인 상태 따라서 이미지, 내용 달라짐 -->

    <v-img
      width="auto"
      max-width="200"
      max-height="200"
      src="@/assets/sports/running.png"
      alt="팀 이미지"
      class="team-image py-8 my-6"
      v-if="!loginUser"
    ></v-img>


    <v-img
      width="auto"
      max-width="200"
      max-height="200"
      src="@/assets/sports/swimming.png"
      alt="팀 이미지"
      class="team-image py-8 my-6"
      v-if="loginUser"
    ></v-img>
    <span v-if="loginUser" class="text-h4">{{ loginUser.nickname }}</span>

    <home-side-content class="my-4"/>
    <ramdom-phrase class="my-4"/>

  </div>
</template>

<script>
import { mapState } from "vuex";
import HomeSideContent from "@/components/home/include/HomeSideContent.vue";
import RamdomPhrase from "../../common/RamdomPhrase.vue";
export default {
  name: "HomeSideBar",
  components: {
    HomeSideContent,
    RamdomPhrase,
  },
  computed: {
    ...mapState(["loginUser"]),
  },
};
</script>

<style scoped>
.contaioner {
  width: 25%;
}

.sports-logo {
  width: 5rem;
  height: 5rem;
}

.h100 {
  height: 100%;
}
</style>
