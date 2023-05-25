<template>
  <header class="deep-orange lighten-1">
    <nav class="header-nav">
      <div class="header-logo">
        <router-link :to="{ name: 'homeOrigin' }" class="logo text-decoration-underline font-italic white--text"
          >Fit Challenge</router-link
        >
        
      </div>
      <div>
        <v-icon large color="white darken-2" @click="moveToOrigin"> mdi-home </v-icon>
      </div>
    </nav>
  </header>
</template>

<script>
export default {
  name: "HeaderNavIndex",
  methods:{
    moveToOrigin(){
      this.$router.replace("/home/main");
    }
  }
};
</script>

<style>
/* header 태그 안에 CSS 속성 */
header {
  height: 70px;;
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
