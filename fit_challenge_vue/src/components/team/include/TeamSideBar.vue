<template>
  <div>
    <h1>팀 사이드바</h1>
    <router-link :to="{ name: 'teamMain' }">팀 메인 페이지</router-link>
    <router-link :to="{ name: 'teamInfo' }">팀 상세 정보</router-link>
    <router-link :to="{ name: 'teamRecord' }">팀 운동 일지</router-link>
  </div>
</template>

<script>
export default {
  name:"TeamSideBar",
}
</script>

<style>

</style>