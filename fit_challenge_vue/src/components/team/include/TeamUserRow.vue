<template>
  <div>
    <div class="text-h6">
      <v-row>
        <v-col>
          <strong> {{ nickname }}</strong>
        </v-col>
        <v-col> 가입일 : {{ regDate }} </v-col>
        <v-col> 성취도 : {{ totalArchieve | archieveFilter }} </v-col>
        
      </v-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "TeamUserRow",
  props: {
    nickname: String,
    regDate: String,
    totalArchieve: Number,
  },
};
</script>

<style></style>
