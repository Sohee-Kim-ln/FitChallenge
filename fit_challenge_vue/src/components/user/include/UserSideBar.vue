<template>
  <div>
    <h1>유저 사이드바</h1>
    <div>유저 이미지</div>
    <div>닉네임</div>    
    <router-link :to="{ name: 'userMain' }">운동 통계</router-link>
    <div></div>
    <router-link :to="{ name: 'userInfo' }">개인 상세정보</router-link>
    <div></div>
    <router-link :to="{ name: 'userRecord' }">운동 일지</router-link>
    <div></div>
    <router-link :to="{ name: 'userDaily' }">오늘의 운동 기록</router-link>
  </div>
</template>

<script>
export default {
    name: "UserSideBar",
}
</script>

<style>

</style>