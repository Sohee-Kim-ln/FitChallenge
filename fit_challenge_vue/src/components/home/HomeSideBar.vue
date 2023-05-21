<template>
  <div>
    <!-- 로그인 상태 따라서 이미지, 내용 달라짐 -->
    <div>이미지</div>
    <home-side-content/>
    <ramdom-phrase />
  </div>
</template>

<script>
import HomeSideContent from "./HomeSideContent.vue";
import RamdomPhrase from "../common/RamdomPhrase.vue";
export default {
  name: "HomeSideBar",
  components: {
    HomeSideContent,
    RamdomPhrase,
  },
};
</script>

<style></style>
