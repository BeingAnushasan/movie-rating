<template>
  <div class="container">
    <MovieDetails v-if="showMovieDetails" v-bind:movie="movieInsideDetails" @showMovieLibrary="showMovieDetailsFunction"/>
    <MovieLibrary
      v-if="showMovieLibrary"
      @showMovieDetail="showMovieDetailsFunction"
    />
  </div>
</template>

<script>
import MovieLibrary from "./MovieLibrary";
import MovieDetails from "./MovieDetails";

export default {
  name: "MovieItem",
  components: {
    MovieLibrary,
    MovieDetails,
  },

  data() {
    return {
      movieInsideDetails: null,
      showMovieDetails: 0,
      showMovieLibrary: 1,
    };
  },

  methods: {
    showMovieDetailsFunction(movie) {
      this.movieInsideDetails = movie;
      this.showMovieDetails = !this.showMovieDetails;
      this.showMovieLibrary = !this.showMovieLibrary;
    },
  },
};
</script>

<style scoped></style>
