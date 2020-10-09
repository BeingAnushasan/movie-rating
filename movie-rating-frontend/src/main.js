import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import Axios from "axios";
// import Vuex from "vuex";

Vue.config.productionTip = false;
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
// Vue.use(Vuex);

Vue.prototype.$axios = Axios;

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
