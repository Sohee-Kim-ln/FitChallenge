<template>
  <div>
    <v-container mt-16 >
      <v-row d>
        <search-card v-for="(team, index) in teams" :key="index" :team="team" />
      </v-row>
    </v-container>
  </div>
</template>

<script>
import { mapState } from "vuex";
import SearchCard from "./include/SearchCard.vue";

export default {
  components: {
    SearchCard,
  },
  name: "SearchList",
  computed: {
    ...mapState(["teams"]),
  },
};
</script>

<style></style>
