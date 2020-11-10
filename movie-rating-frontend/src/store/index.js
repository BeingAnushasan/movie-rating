import Vue from "vue";
import Vuex from "vuex";
import router from "../router";

// import API from "../resources/API";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    //Global states
    isLoggedIn: false,
    token: localStorage.getItem("token") || "",

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
    signOut(state) {
      state.isLoggedIn = false;
      localStorage.removeItem("token");
      router.push("/login");
    },
  },
  actions: {},
  modules: {},
});
