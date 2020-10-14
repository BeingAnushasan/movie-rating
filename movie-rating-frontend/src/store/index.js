import Vue from "vue";
import Vuex from "vuex";
// import API from "../resources/API";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    //Global states
    isLoggedIn: false,

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
    },
  },
  actions: {},
  modules: {},
});