<template>
  <v-card class="my-12 mx-10" max-width="300" @click="moveToTeam">
    <v-responsive :aspect-ratio="16 / 9">
      <v-img
        width="auto"
        height="200"
        src="@/assets/sports/weight.png"
        alt="팀 이미지"
        class="team-image"
      ></v-img>
      <v-row class="mx-2">
        <v-card-title>{{ team.teamName }}</v-card-title>
        <v-spacer />
        <v-col cols="3" class="text-end align-end">
          {{ team.curCapacity }} / {{ team.maxCapacity }}</v-col
        >
      </v-row>

      <v-divider class="mx-4"></v-divider>
      <v-card-text class="mx-2 text-start"> {{ team.info }} </v-card-text>
      <v-row class="my-2">
        <v-spacer />
        <v-col>
          <v-btn elevation="2" small rounded depressed> 팀 정보 보기</v-btn>
        </v-col>
      </v-row>
    </v-responsive>
  </v-card>

  <!-- <div class="team-card">
    <img src="@/assets/sports/weight.png" alt="팀 이미지" class="team-image" />
    <h3 class=" team-name">{{ team.teamName }}</h3>
    <p class="team-description">{{ team.info }}</p>
    <p class="team-capacity">
      <span class="cur-capacity">{{ team.curCapacity }}</span> /
      <span class="max-capacity">{{ team.maxCapacity }}</span>
    </p>
    <button type="button" @click="joinTeam" class="join-button">가입</button>
  </div> -->
</template>

<script>
export default {
  name: "SearchCard",
  props: {
    team: Object,
  },
  data() {
    return {
      thisTeam: this.team,
    };
  },
  methods: {
    moveToTeam() {
      this.$router.push(`/team/${this.thisTeam.teamId}`);
    },
  },
};
</script>

<style>
.team-card {
  margin: 0.5rem;
  border: 0.1rem solid black;
  padding: 0.8rem;
  display: inline-block;
}

.team-image {
  width: 5rem;
  height: 5rem;
}
</style>
