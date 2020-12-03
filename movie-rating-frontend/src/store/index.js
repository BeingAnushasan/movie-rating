import Vue from "vue";
import Vuex from "vuex";
import router from "../router";
// import AUTH from "../resources/Auth";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    //Global  control states
    backend_URL: "http://192.168.1.19:8085",
    isLoggedIn: false,
   

    // User Data
    token: "",
    username: "user-name",

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
    updateUserInfo(state, info){
      state.token = info.token || "";
      state.username = info.username;
    },
    signOut(state) {
      state.isLoggedIn = false;
      localStorage.removeItem("token");
      router.push("/login");
      state.username = "";
    },
  },
  actions: {
    loggingIn (context, info){
        context.commit("loggedIn");
        context.commit("updateUserInfo", info);
    }
  },
  modules: {},
});
