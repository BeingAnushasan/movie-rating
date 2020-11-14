import Vue from "vue";
import Vuex from "vuex";
import router from "../router";
import AUTH from "../resources/Auth";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    //Global  control states
    isLoggedIn: false,
    token: "",

    

    // User Data

    username: "username",

    // for AddMovie component
    TheMovieDBResult: [],

    // for MovieItem component

    // for MovieDetails component

    count: 0,
  },
  mutations: {
    increment(state) {
      state.count++;
    },

    loggedIn(state) {
      state.isLoggedIn = true;
      router.push("/home");
      
    },
    updateUserInfo(state){
      state.token = localStorage.getItem("token") || "";
      state.username = (AUTH.getUserInfo()).sub;
    },
    signOut(state) {
      state.isLoggedIn = false;
      localStorage.removeItem("token");
      router.push("/login");
      state.username = "";
    },
  },
  actions: {},
  modules: {},
});
