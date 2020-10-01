<template>
  <div id="main">
    <div v-if="showMovieDetails">
      <h1>Details:</h1>
      <b-button @click="showMovieDetailsFunction">Go back</b-button>
      <div class="movieInfo">
        <img v-bind:src="imageLink" />
        <h3>
          <u>{{ this.movieInsideDetails.movieName }}</u>
        </h3>
        <h4 style="display:inline">Description:</h4>
        <p>{{ this.movieInsideDetails.description }}</p>
        <h4>My Rating:</h4>
        <p>{{ this.movieInsideDetails.rating }}</p>
        <h4>Genre:</h4>
        <li v-for="genre in movieInsideDetails.genre" :key="genre">
          {{ genre }}
        </li>
      </div>
    </div>

    <div v-if="showMovieLibrary">
      <h1>Movie Library</h1>
      <!-- <div>
      <input type="text" placeholder="Search By Name" v-model="searchName" />
      <b-button size="sm" @click="searchByName">Search By Name</b-button>
    </div> -->
      <div>
        <!-- <input
        type="text"
        placeholder="Search By Genre"
        v-model="searchGenreName"
      /> -->
        <!-- <b-button size="sm" @click="searchByGenre">Search By Genre</b-button> -->
      </div>
      <div>
        <b-form
          inline
          label="Genre:"
          label-for="input-1"
          class="mb-2 mr-sm-2 mb-sm-0"
        >
          <input
            type="text"
            placeholder="Search By Name"
            v-model="searchName"
          />

          <b-form-select
            v-model="searchGenreName"
            :options="genres"
          ></b-form-select>
          <b-button size="sm" @click="searchByGenre">Search</b-button>
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
  </div>
</template>

<script>
export default {
  name: "MovieItem",

  data: function() {
    return {
      movies: null,
      genres: [
        { text: "Genre", value: null },
        "Action",
        "Drama",
        "Romance",
        "Comedy",
        "Horror",
        "Si-fi",
      ],
      movieInsideDetails: {
        movieName: "",
        description: "",
        rating: null,
        posterLink: "",
        genre: [],
      },
      searchName: null,
      searchGenreName: "",
      showMovieDetails: 0,
      showMovieLibrary: 1,
      imageLink: "",
    };
  },

  mounted() {
    this.$axios
      .get("http://192.168.1.13:8085/movie")
      //  .then(response => console.log(response))
      .then((response) => (this.movies = response.data));
  },

  methods: {
    searchByName() {
      this.$axios
        .get("http://192.168.1.13:8085/search?name=" + this.searchName)
        //  .then(response => console.log(response))
        .then((response) => (this.movies = response.data))
        .then(console.log(this.movies));
    },

    searchByGenre() {
      this.$axios
        .get(
          "http://192.168.1.13:8085/search?genre=" +
            this.searchGenreName +
            "&name=" +
            this.searchName
        )
        .then((response) => (this.movies = response.data));
    },

    showMovieDetailsFunction(movie) {
      this.movieInsideDetails = movie;
      this.imageLink =
        "http://image.tmdb.org/t/p/w185" + this.movieInsideDetails.posterLink;
      this.showMovieDetails = !this.showMovieDetails;
      this.showMovieLibrary = !this.showMovieLibrary;
    },
  },
};
</script>

<style scoped>
#searchItems {
  align-content: center;
}
</style>
