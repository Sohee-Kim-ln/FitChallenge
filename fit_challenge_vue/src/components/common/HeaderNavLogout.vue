<template>
  <header>
    <nav class="header-nav">
      <div>
        <router-link :to="{ name: 'home' }" class="logo">FitChallenge</router-link>
      </div>
      <div>
        <router-link :to="{ name: 'search' }">팀 검색</router-link>
        <router-link :to="{ name: 'indexSignUp' }">회원가입</router-link>
        <router-link :to="{ name: 'indexLogin' }">로그인</router-link>
      </div>
    </nav>
  </header>
</template>

<script>
export default {
  name: "HeaderNavLogout",
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
