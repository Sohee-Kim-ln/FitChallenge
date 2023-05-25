import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import myfilters from './util/filter';
import vuetify from './plugins/vuetify'

Vue.filter('sportsFilter',myfilters.sportsFilter);
Vue.filter('genderFilter',myfilters.genderFilter);
Vue.filter('archieveFilter',myfilters.archieveFilter);
Vue.filter('timeFilter',myfilters.timeFilter);
Vue.filter('distFilter',myfilters.distFilter);
Vue.filter('commentFilter',myfilters.commentFilter);
Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
