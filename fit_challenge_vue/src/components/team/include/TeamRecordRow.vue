<template>
  <v-card class="mx-auto my-3 py-4  " outlined>
    <v-row>

      <v-col cols="2"  sm="12" md="3" lg="2"  min-width="140">{{ nickname }}</v-col>
      <v-col cols="2"  sm="4" md="2" lg="2"  min-width="140">{{ date }}</v-col>
      <v-col cols="1"  sm="3" md="3" lg="1"  min-width="100">{{ sportsId | sportsFilter }}</v-col>
      <v-col cols="1" sm="2" md="2" lg="1" >{{ dailyTime | timeFilter }}</v-col>

      <v-col cols="1"  sm="2" md="2" lg="1" >{{ dailyDistance | distFilter }}</v-col>
      <!-- <v-divider vertical class="mx-4"></v-divider> -->

      <v-col cols="1" sm="12" md="12" lg="5 ">
        <v-list-item-subtitle>{{ comment |commentFilter}}</v-list-item-subtitle>
      </v-col>
    </v-row>
  </v-card>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: "TeamRecordRow",
  props: {
    nickname: String,
    date: String,
    sportsId: Number,
    dailyTime: Number,
    dailyDistance: Number,
    comment: String,
  },
  computed:{
    ...mapState(["loginUser"])
  },
};
</script>

<style></style>
