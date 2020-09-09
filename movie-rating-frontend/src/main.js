import Vue from 'vue'
import App from './App.vue'
import router from './router'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import axios from 'axios'


Vue.config.productionTip = false
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)

new Vue({
  router,

  mounted () {
    axios.get("http://localhost:8085/movies")
                .then(response => console.log(response))
  },

  render: h => h(App)
}).$mount('#app')
