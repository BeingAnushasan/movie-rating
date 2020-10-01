<template>
  <div>
    <h1>
      <strong>{{ this.movieInsideDetails.movieName }}</strong
      >/ <strong>{{ this.movieInsideDetails.rating }}</strong>
    </h1>

    <div class="movieInfo">
      <img v-bind:src="imageLink" />
      <h4>
        <span v-for="genre in this.movieInsideDetails.genre" :key="genre">
          {{ genre }}</span
        >
      </h4>
      <h5>{{ this.movieInsideDetails.description }}</h5>
    </div>
    <b-button class="btn" @click="showMovieDetailsFunction">Back</b-button>
  </div>
</template>

<script>
export default {
  name: "MovieDetails",
  props: ["movie"],

  mounted() {
    this.movieInsideDetails = this.movie;
    this.imageLink =
      "http://image.tmdb.org/t/p/w185" + this.movieInsideDetails.posterLink;
  },
  data() {
    return {
      movieInsideDetails: {
        movieName: "",
        description: "",
        rating: null,
        posterLink: "",
        genre: [],
      },
      imageLink: "",
    };
  },

  methods: {
      showMovieDetailsFunction() {
      this.$emit("showMovieLibrary");
    },
  }
};
</script>
