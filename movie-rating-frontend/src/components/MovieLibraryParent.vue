<template>
  <div class="container">
    <MovieDetails 
    v-if="showMovieDetails" 
    v-bind:movie="movieInsideDetails" 
    @deleteEvt="deleteMovieByID"
    @showMovieLibrary="showMovieDetailsFunction"/>
    <MyMovieList
      v-if="showMovieLibrary"
      @showMovieDetail="showMovieDetailsFunction"
    />
  </div>
</template>

<script>
import MyMovieList from "./MyMovieList";
import MovieDetails from "./MovieDetails";

export default {
  name: "MovieItem",
  components: {
    MyMovieList,
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
    deleteMovieByID(id) {
      
      console.log("In movieItem ID is "+id);
      this.$axios.delete(this.$store.state.backend_URL+"/movie/"+id,
      {
        headers: {
          Authorization: "Bearer " + JSON.parse(localStorage.getItem(`token`)),
        },
      })
      this.showMovieDetails = !this.showMovieDetails;
      this.showMovieLibrary = !this.showMovieLibrary;
    }
  },
};
</script>

<style scoped></style>
