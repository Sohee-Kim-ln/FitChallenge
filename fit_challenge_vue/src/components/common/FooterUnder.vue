<template>
  <footer>
    <nav class="header-nav">
      <div>
        <router-link :to="{ name: 'homeOrigin' }" class="logo"
          >FitChallenge</router-link
        >
      </div>
      <div>
        <router-link :to="{ name: 'homeOrigin' }">홈으로</router-link>
      </div>
    </nav>
  </footer>
</template>

<script>
export default {
  name: "Footer",
};
</script>

<style>
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
  display: in;
  font-size: 2rem;
  font-weight: bold;
  color: white;
}
</style>
