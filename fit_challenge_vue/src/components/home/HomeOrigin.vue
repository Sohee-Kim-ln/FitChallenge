<template>
  <div class="mt-16">
    <div class="text-h4 "><strong>팀 목록</strong></div>
    <search-list />
  </div>
</template>

<script>
import SearchList from "@/components/search/SearchList.vue";
export default {
  components: {
    SearchList,
  },
  created() {
    this.$store.dispatch("searchAllTeams");
  },
};
</script>

<style></style>
