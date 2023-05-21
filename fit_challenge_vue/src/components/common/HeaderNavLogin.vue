<template>
  <header>
    <nav class="header-nav">
      <div>
        <router-link :to="{ name: 'home' }" class="logo">FitChallenge</router-link>
      </div>
      <div>
        <router-link :to="{ name: 'search' }">팀 검색</router-link>
        <router-link :to="{ name: 'userMain' }">마이페이지</router-link>
        <router-link :to="{ name: 'IndexLogout' }">로그아웃</router-link>
      </div>
    </nav>
  </header>
</template>

<script>
export default {
  name: "HeaderNavLogin",
};
</script>

<style>
/* header 태그 안에 CSS 속성 */
header {
  height: 70px;
  background-color: skyblue;
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  text-decoration: none;
  color: white;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
}
</style>
