<template>
  <div class="container">
    <div class="card bg-light">
      <h1>Movie Library</h1>
      <b-container>
        <b-row class="justify-content-md-center">
          <b-col cols="12" md="auto">
            <input
              type="text"
              placeholder="Search By Name"
              v-model="searchName"
              @input="searchInMyDB($event)"
            />
          </b-col>
          <b-col>
            <b-form-select
              v-model="searchGenreName"
              :options="genres"
              calss="mb-3"
            ></b-form-select>
          </b-col>
          <b-col>
            <b-button size="sm" @click="searchInMyDB($event)">Search</b-button>
          </b-col>
        </b-row>
      </b-container>

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
        { text: "Genre", value: null, disabled: true },
        { text: "Action", value: "Action" },
        { text: "Drama", value: "Drama" },
        { text: "Romance", value: "Romance" },
        { text: "Comedy", value: "Comedy" },
        { text: "Horror", value: "Horror" },
        { text: "Si-fi", value: "Si-fi" },
      ],

      searchName: null,
      searchGenreName: null,
      event: "",
      imageLink: "",
      
    };
  },

  methods: {
    searchInMyDB(evt) {
      API.getMoviesFromMyDB(this.searchName, this.searchGenreName).then(
        (response) => (this.movies = response.data)
      );

      if (evt.type === "click") {
        this.searchName = "";
        this.searchGenreName = "";
      }
    },

    showMovieDetailsFunction(movie) {
      this.$emit("showMovieDetail", movie);
    },
  },
};
</script>
