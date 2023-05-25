<template>
  <div class="container">
    <div class="text-h4 text-start"><strong>팀 정보</strong></div>
    <div class="text-h6">
      <v-container>
        <v-row>
          <v-col cols="2" class="text-start"> 생성일</v-col>
          <v-col  class="text-start"> {{ team.createTime }}</v-col>
          
        </v-row>
        <v-row>
          <v-col cols="2" class="text-start"> 현재 인원</v-col>
          <v-col  class="text-start"> {{ team.curCapacity }}/{{ team.curCapacity }}</v-col>
          
        </v-row>
        <v-row>
          <v-col cols="2" class="text-start"> 팀 설명</v-col>
          <v-col  class="text-start"> {{ team.info }}</v-col>
          
        </v-row>
        <v-row>
          <v-col cols="2" class="text-start"> 팀 공지사항</v-col>
          <v-col  class="text-start"> {{ team.announce }}</v-col>
          
        </v-row>
      </v-container>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "TeamInfoBox",
  computed: {
    ...mapState(["team"]),
  },
};
</script>

<style></style>
