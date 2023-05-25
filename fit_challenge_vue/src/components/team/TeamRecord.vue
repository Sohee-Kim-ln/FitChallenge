<template>
  <div class="mx-8">
    <h1 class="text-start">팀 운동 기록</h1>
    <v-row class="d-flex justify-center align-center">
      <v-col cols="2">
        <v-menu
          v-model="calendarShow"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="month"
              label="연/월 선택"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            />
          </template>
          <v-date-picker
            type="month"
            locale="kr"
            v-model="month"
            @input="calendarShow = false"
          />
        </v-menu>
      </v-col>
      <v-col cols="1"
        ><v-btn color="primary white--text text-h6" elevation="2" @click="searchWeekly"
          >검색</v-btn
        ></v-col
      >
    </v-row>
    <v-container v-if="records.length" class="px-16">
      <!-- <colgroup>
          <col style="width: 5%" />
          <col style="width: 20%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup> -->
      <team-record-row
        v-for="(record, index) in records"
        :key="index"
        :nickname="record.nickname"
        :date="record.date"
        :sportsId="record.sportsId"
        :dailyTime="record.dailyTime"
        :dailyDistance="record.dailyDistance"
        :comment="record.comment"
      />
    </v-container>
    <div class="mt-10">{{msg}}</div>
  </div>
</template>

<script>
import TeamRecordRow from "@/components/team/include/TeamRecordRow.vue";

import { mapState } from "vuex";
import http from "@/util/http-common";

export default {
  name: "TeamRecord",
  components: {
    TeamRecordRow,
  },
  computed: {
    ...mapState(["team"]),
  },
  data() {
    return {
      month: "",
      records: [],
      calendarShow:false,
      msg:"기간 선택 후 검색 버튼을 눌러주세요"
    };
  },
  methods: {
    searchWeekly() {
      if (this.month === "") {
        alert("날짜를 선택해주세요");
        return;
      }

      let words = this.month.split("-");
      let year = words[0];
      let month = words[1];
      console.log(`/daily/team/${this.team.teamId}/${year}/${month}`);
      http({
        url: `/daily/team/${this.team.teamId}/${year}/${month}`,
        method: "GET",
      }).then((res) => {
        console.log(res);
        this.records = res.data;
        if(this.records.length===0)
        this.msg="해당 기간의 운동 기록이 없습니다.";
        else
        this.msg="";
      });
    },
  },
};
</script>

<style></style>
