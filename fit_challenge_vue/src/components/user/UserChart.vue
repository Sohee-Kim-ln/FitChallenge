<template>
  <div>
    <h1>유저 차트</h1>

    <Bar :options="chartOptions" :data="chartData"/>

  </div>
</template>

<script>
import { Bar } from 'vue-chartjs';
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)

export default{
  name: "UserChart",
  components: { Bar },
  // 계산 속성 (데이터나 옵션이 변할 때마다 다시 계산)
  // computed: {
  //   chartData() {
  //     return /* mutable chart data */ 
  //   },
  //   chartOptions() {
  //     return /* mutable chart options */ 
  //   }
  // },
  // props 곁들인 
  // props: {
  //   chartData: {
  //       type: Object,
  //       required: true
  //     },
  //   chartOptions: {
  //     type: Object,
  //     default: () => {}
  //   }
  // },
  data() {
    return {
      chartData: {
        labels: [ 'January', 'February', 'March' ],
        datasets: [ { data: [40, 20, 12] } ]
      },
      chartOptions: {
        responsive: true
      }
    }
  }
}

</script>

<style>

</style>
