<template>
  <div>
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
    <div id="searchItems">
      <b-form
        inline
        label="Genre:"
        label-for="input-1"
        class="mb-2 mr-sm-2 mb-sm-0"
      >
        <input type="text" placeholder="Search By Name" v-model="searchName" />

        <b-form-select
          id="input-2"
          v-model="searchGenreName"
          :options="genres"
        ></b-form-select>
        <b-button size="sm" @click="searchByGenre">Search</b-button>
      </b-form>
    </div>
    <ul>
      <li v-for="movie in movies" :key="movie.id">{{ movie.movieName }}</li>
    </ul>
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
      searchName: null,
      searchGenreName: "",
    };
  },

  mounted() {
    this.$axios
      .get("http://192.168.1.12:8085/movie")
      //  .then(response => console.log(response))
      .then((response) => (this.movies = response.data));
  },

  methods: {
    searchByName() {
      this.$axios
        .get("http://192.168.1.12:8085/search?name=" + this.searchName)
        //  .then(response => console.log(response))
        .then((response) => (this.movies = response.data))
        .then(console.log(this.movies));
    },

    searchByGenre() {
      this.$axios
        .get(
          "http://192.168.1.12:8085/search?genre=" +
            this.searchGenreName +
            "&name=" +
            this.searchName
        )
        .then((response) => (this.movies = response.data));
    },
  },
};
</script>

<style scoped>
#searchItems {
  align-content: center;
}
</style>
