<template>
  <div class="mx-8">
    <h1 class="text-start">나의 운동 일지</h1>
    <v-row>
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
        ><v-btn color="primary" elevation="2" @click="searchDailys"
          >검색</v-btn
        ></v-col
      >
    </v-row>
    <v-container v-if="records.length" class="px-16">
      <user-record-row
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
  </div>

  <!-- <div>
    <h1>유저 운동 일지</h1>
    <input type="month" v-model="month">
    <button @click="searchDailys">검색</button>
    <span v-if="records.length">
      <table id="daily-list">

        <thead>
          <tr>
            <th>날짜</th>
            <th>종목</th>
            <th>운동 시간</th>
            <th>운동 거리</th>
            <th>오늘의 코멘트</th>
          </tr>
        </thead>
        <tbody>
          <user-record-row v-for="(record, index) in records" :key="index" :nickname="record.nickname" :date="record.date"
            :sportsId="record.sportsId" :dailyTime="record.dailyTime" :dailyDistance="record.dailyDistance"
            :comment="record.comment" />
        </tbody>
      </table>
    </span>
  </div> -->
</template>

<script>
import { mapState } from "vuex";
import UserRecordRow from "./include/UserRecordRow.vue";
import http from "@/util/http-common";

export default {
  name: "UserRecord",
  computed: {
    ...mapState(["loginUser"]),
  },
  data() {
    return {
      month: "",
      records: [],
    };
  },
  components: {
    UserRecordRow,
  },
  methods: {
    searchDailys() {
      if (this.month === "") {
        alert("날짜를 선택해주세요");
        return;
      }
      let words = this.month.split("-");
      let year = words[0];
      let month = words[1];
      let uId = this.$store.state.loginUser.userId;
      http({
        url: `/daily/user/${uId}/${year}/${month}`,
        method: "GET",
      }).then((res) => {
        console.log(res);
        this.records = res.data;
      });
    },
  },
};
</script>

<style></style>
