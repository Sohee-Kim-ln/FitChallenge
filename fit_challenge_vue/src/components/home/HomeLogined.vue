<template>
  <div>
    <h2>로그인된 홈</h2>
    <!-- 로그인  상태일 때 -->
    <home-group-info />
    <home-fit-list />
  </div>
</template>

<script>
import HomeGroupInfo from "@/components/home/include/HomeGroupInfo.vue";
import HomeFitList from "@/components/home/include/HomeFitList.vue";

export default {
  components: {
    HomeGroupInfo,
    HomeFitList,
  },
};
</script>

<style></style>
