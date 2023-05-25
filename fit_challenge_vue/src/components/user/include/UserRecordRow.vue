<template>
  <v-card class="mx-auto my-3 py-4" outlined>
    <v-row>
      <v-col cols="2" sm="5" md="3" lg="2" min-width="140">{{ date }}</v-col>
      <v-col cols="6" sm="7" md="" lg="4">
        <v-row>
          <v-spacer></v-spacer>
          <v-col cols="4" sm="4" md="" lg="4">{{
            sportsId | sportsFilter
          }}</v-col>
          <v-col cols="4" sm="4" md="" lg="4">{{
            dailyTime | timeFilter
          }}</v-col>

          <v-col cols="4" sm="4" md="" lg="4">{{
            dailyDistance | distFilter
          }}</v-col>
        </v-row>
      </v-col>
      <!-- <v-divider vertical class="mx-4"></v-divider> -->

      <v-col cols="1" sm="12" md="12" lg="">
        <v-list-item-subtitle>{{
          comment | commentFilter
        }}</v-list-item-subtitle>
      </v-col>
    </v-row>
  </v-card>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "UserRecordRow",
  props: {
    date: String,
    sportsId: Number,
    dailyTime: Number,
    dailyDistance: Number,
    comment: String,
  },
  computed: {
    ...mapState(["loginUser"]),
  },
};
</script>

<style></style>
