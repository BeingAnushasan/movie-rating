<template>
  <div class="container">
    <h1>
      <strong style="text-decoration-color: blue">{{
        this.movieInsideDetails.movieName
      }}</strong>
      <strong
        ><b-form-rating
          style="width: 18em; margin: auto; "
          v-model="movieInsideDetails.rating"
          variant="warning"
          stars="10"
          class="mb-2"
          readonly
          no-border
          size="sm"
          show-value
          show-value-max
        ></b-form-rating
      ></strong>
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
    <b-button class="btn" @click="deleteMovie">Delete</b-button>
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
        id: null,
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
    deleteMovie() {
      this.$emit("deleteEvt", this.movieInsideDetails.id);
    },
  },
};
</script>
