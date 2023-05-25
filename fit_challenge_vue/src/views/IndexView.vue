<template>
  <div>
    <HeaderNavIndex />
    <router-view />
  </div>
</template>

<script>
import HeaderNavIndex from "@/components/common/HeaderNavIndex.vue";
export default {
  name: "Index",
  components: {
    HeaderNavIndex,
  },
};
</script>

<style scoped></style>
