3<template>
  <div class="container" style="text-align: center">
    <h1 >Movie Library</h1>
    <!-- <div>
      <input type="text" placeholder="Search By Name" v-model="searchName" />
      <b-button size="sm" @click="searchByName">Search By Name</b-button>
    </div> -->
    

    <div class="library-search ">
      <b-form inline label="Genre:" label-for="input-1">
        <input
          type="text"
          placeholder="Search By Name"
          v-model="searchName"
          @input="searchByName"
        />

        <b-form-select
          v-model="searchGenreName"
          :options="genres"
          calss="mb-3"
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
</template>

<script>
export default {
  name: "MovieLibrary",

  mounted() {
    this.$axios
      .get("http://192.168.1.13:8085/movie")
      //  .then(response => console.log(response))
      .then((response) => (this.movies = response.data));
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
      this.searchName = "";
      this.searchGenreName = "";
    },

    showMovieDetailsFunction(movie) {
      this.$emit("showMovieDetail", movie);
    },
  },
};
</script>

<style >
.library-search {
  
  margin-left: 20em;
}
</style>
