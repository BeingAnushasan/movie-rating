import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // for AddMovie component
      TheMovieDBResult: [],
      

    // for MovieItem component
    
    // for MovieDetails component

    count: 0,
  },
  mutations: {
    increment (state) {
      state.count++
      }
  },
  actions: {
  },
  modules: {
  }
})
