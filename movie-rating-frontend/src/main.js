import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import Axios from "axios";
import store from './store'

Vue.config.productionTip = false;
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

Vue.prototype.$axios = Axios;

new Vue({
  router,
  store,
  render: (h) => h(App)
}).$mount("#app");
