<template>
  <div>
    <team-goal/>
    <div>
        <team-user-list></team-user-list>
    </div>
  </div>
</template>

<script>
import TeamGoal from './include/TeamGoal.vue';
import TeamUserCard from './include/TeamUserCard.vue';

import { mapState } from 'vuex';
import TeamUserList from './include/TeamUserList.vue';

export default {
    name: "TeamMain",
    components:{
        TeamGoal,
        TeamUserCard,
        TeamUserList,
    },
    data(){
      return{

      };
    },
    computed:{
      ...mapState(["team"]),
      ...mapState(["userCards"]),
      ...mapState(["goals"]),
    },
    created(){
      
      //this.$route.params.teamId
    },
    methods:{

    },
}
</script>

<style>

</style>