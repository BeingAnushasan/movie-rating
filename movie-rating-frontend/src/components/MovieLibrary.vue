3<template>
  <div class="container" style="text-align: center">
    <h1>Movie Library</h1>
    <div class="library-search ">
      <b-form inline label="Genre:" label-for="input-1">
        <input
          type="text"
          placeholder="Search By Name"
          v-model="searchName"
          @input="searchInMyDB"
        />

        <b-form-select
          v-model="searchGenreName"
          :options="genres"
          calss="mb-3"
        ></b-form-select>
        <b-button size="sm" @click="searchInMyDB">Search</b-button>
      </b-form>
    </div>

    <ul>
      <li
        v-for="movie in movies"
        :key="movie.id"
        @click="showMovieDetailsFunction(movie)"
      >
        {{ movie.movieName }}
      </li>
    </ul>
  </div>
</template>

<script>
import API from "../resources/API";

export default {
  name: "MovieLibrary",

  mounted() {
    API.getAllMoviesFromMyDB().then(
      (response) => (this.movies = response.data)
    );
  },

  data: function() {
    return {
      movies: null,
      genres: [
        { text: "Genre", value: null },
        { text: "Action", value: "Action" },
        { text: "Drama", value: "Drama" },
        { text: "Romance", value: "Romance" },
        { text: "Comedy", value: "Comedy" },
        { text: "Horror", value: "Horror" },
        { text: "Si-fi", value: "Si-fi" },
      ],

      searchName: null,
      searchGenreName: "",

      imageLink: "",
    };
  },

  methods: {
    searchInMyDB() {
      API.getMoviesFromMyDB(this.searchName, this.searchGenreName)
         .then((response) => (this.movies = response.data));
      // this.searchName = "";
      console.log(this.searchName)
      // this.searchGenreName = "";
    },

    showMovieDetailsFunction(movie) {
      this.$emit("showMovieDetail", movie);
    },
  },
};
</script>

<style>
.library-search {
  margin-left: 20em;
}
</style>
