<template>
  <div>
    <!-- 로그인 상태 따라 달라짐 -->
    <!-- 로그인  상태일 때 -->
    <div>
        <home-group-info/>
        <home-fit-list/>
    </div>
    <!-- 비로그인 상태일 때 -->
    <div>
        <search-list/>
    </div>
  </div>
</template>

<script>
import HomeGroupInfo from './include/HomeGroupInfo.vue';
import HomeFitList from './HomeFitList.vue';

import SearchList from '../search/SearchList.vue';
export default {
    components:{
        HomeGroupInfo,
        HomeFitList,

        SearchList,
    },
}
</script>

<style>

</style>