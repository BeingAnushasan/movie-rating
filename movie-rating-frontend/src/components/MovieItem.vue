<template>
  <div>
    <h1>Movie Library</h1>
    <input type="text" placeholder="Search" v-model="searchName" />
    <b-button size="sm" @click="searchByName">Search</b-button>
    <ul>
      <li v-for="movie in movies" :key="movie.id">{{ movie.movieName }}</li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "MovieItem",

  data: function() {
    return {
      
      movies: null,
      // movieName: null,
      searchName: null,
    };
  },

  methods: {
    searchByName: function() {
      axios
        .get("http://localhost:8085/movie")
        //  .then(response => console.log(response))
        .then((response) => (this.movies = response.data))
        .then(console.log(this.movies));
        
    },
  },
};
</script>
