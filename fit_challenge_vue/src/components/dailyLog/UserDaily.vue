<template>
  <div class="container">
    <h1>자동차 상세 정보</h1>
    <fieldset class="detail-content">
      <label for="vin">자동차등록번호</label>
      <div class="view">{{ car.vin }}</div>
      <label for="modelName">모델 명</label>
      <div class="view">{{ car.modelName }}</div>
      <label for="color">색상</label>
      <div class="view">{{ car.color }}</div>
      <label for="mileage">주행 거리</label>
      <div class="view">{{ car.mileage }}km</div>
    </fieldset>
    <router-link to="/car" class="btn">목록</router-link>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  computed:{
    ...mapState(["car"])
  },
  created(){
    this.$store.dispatch("getCar", this.$route.params.vin)
  },
  methods:{
    
  }
};
</script>

<style>
/* content CSS */

.container {
  margin: 0px 30px;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 130px;
}

.detail-content {
  padding: 10px 30px;
}
</style>
