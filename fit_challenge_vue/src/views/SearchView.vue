<template>
  <div>
    <header-nav-login/>
    <header-nav-logout/>
    <h1>검색 뷰</h1>
    <search-list/>

  </div>
</template>

<script>
import HeaderNavLogin from "@/components/common/HeaderNavLogin.vue";
import HeaderNavLogout from "@/components/common/HeaderNavLogout.vue";

import SearchList from "@/components/search/SearchList.vue";

export default {
components:{
    HeaderNavLogin,
    HeaderNavLogout,
    SearchList,
}
}
</script>

<style>

</style>