<template>
  <v-card width="80%">
    <v-responsive
      :aspect-ratio="16 / 9"
      class="d-flex justify-center align-center"
    >
      <v-img class="white--text text--darken-1 align-center" src="@/assets/phraseBack/4.jpg">
        <div class="phrase ">
          {{ phrase }}
        </div>
      </v-img>

      

    </v-responsive>
  </v-card>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "RandomPhrase",
  data() {
    return {
      phrase: "",
      imgCnt: 3,
    };
  },
  created() {
    http({
      url: "/phrase",
      methods: "GET",
    })
      .then((res) => {
        this.phrase = res.data.content;
      })
      .catch((err) => {
        console.log(err);
      });
  },
  methods: {},
};
</script>

<style scoped>
.phrase {
  font-size: 1.3rem;
  font-weight: bold;
}
</style>
