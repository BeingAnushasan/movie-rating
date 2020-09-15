<template>
  <div>
    <h1>Movie Library</h1>
    <input type="text" placeholder="Search" v-model="searchName" />
    <b-button size="sm" @click="searchByName">Search</b-button>
    <ul>
      <li>{{ movieName }}</li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "MovieItem",

  data: function() {
    return {
      list: null,
      movieName: null,
      searchName: null,
    };
  },

  methods: {
    searchByName: function() {
      axios
        .get("http://www.omdbapi.com/?t=" + this.searchName + "&apikey=113170")
        //  .then(response => console.log(response))
        .then((response) => (this.movieName = response.data));
    },
  },
};
</script>
