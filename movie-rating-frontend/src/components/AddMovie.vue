<template>
  <div id="addmovie">
    <input type="text" placeholder="Search" v-model="searchName" />
    <b-button size="sm" @click="searchByName">Search</b-button>
    <ul>
      <li @click="fillTheForm(movie, $event)" v-for="movie in searchResponseMovie" :key="movie.id">{{ movie.title }} : {{movie.release_date}}</li>
    </ul>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="Movie Name:"
        label-for="input-1"
        description=""
      >
        <b-form-input
          id="input-1"
          class="mb-2 mr-sm-2 mb-sm-0"
          v-model="form.movieName"
          type="text"
          required
          placeholder="Movie Name"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Description:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.description"
          required
          placeholder="Description"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Ratings:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="form.rating"
          :options="ratings"
          required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-4" label="Genre:">
        <b-form-checkbox-group v-model="form.genre" id="checkboxes-4">
          <!-- <b-form-checkbox
            v-for="genre in genres"
            value="genre.value"
            :key="genre.id"
            >{{ genre.value }}</b-form-checkbox> -->
          <b-form-checkbox value="Action">Action</b-form-checkbox>
          <b-form-checkbox value="Drama">Drama</b-form-checkbox>
          <b-form-checkbox value="Romance">Romance</b-form-checkbox>
          <b-form-checkbox value="Comedy">Comedy</b-form-checkbox>
          <b-form-checkbox value="Horror">Horror</b-form-checkbox>
          <b-form-checkbox value="Si-fi">Si-fi</b-form-checkbox>
        </b-form-checkbox-group>
      </b-form-group>

      <b-button type="submit" variant="primary">Add To Libary</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
    <div class="mt-3">
      <b-button size="sm" variant="primary" @click="showJSON"
        >Show JSON</b-button
      >
      <b-card header="Form Data Result" v-if="showJSONBool">
        <pre class="m-0">{{ form }}</pre>
      </b-card>
    </div>
  </div>
</template>

<script>
// import axios from "axios";

export default {
  name: "AddMovie",
  data() {
    return {
      form: {
        movieName: "",
        description: "",
        rating: null,
        genre: [],
      },
      // genres: [{id:1, value: "Action"} , "Drama", "Romance", "Comedy", "Horror", "Si-fi"],
      // genres: [{id:1, value: "Action"} , {id:2, value: "Drama"} , {id:3, value: "Romance"} , {id:4, value: "Comedy"} , {id:6, value: "Horror"} , {id:6, value: "Si-fi"} ],
      ratings: [{ text: "Your Rating", value: null }, "1", "2", "3", "4", "5"],
      show: true,
      showJSONBool: false,
      searchName: null,
      searchResponseMovie: [],
    };
  },
  methods: {
    showJSON(evt) {
      evt.preventDefault();
      this.showJSONBool = !this.showJSONBool;
    },
    fillTheForm(movie, evt) {
      evt.preventDefault();
      this.form.movieName = movie.title;
      this.form.description = movie.overview;

    },
    searchByName() {
        this.$axios.get("https://api.themoviedb.org/3/search/movie?api_key=f69685ff175d2d4f542c2d6001185d43&query="+this.searchName)
              .then((response) => (this.searchResponseMovie = response.data.results))
              // .then(this.form.movieName = this.searchResponseMovie.Title);
    },
    

    onSubmit(evt) {
      evt.preventDefault();
      this.$axios.post("http://localhost:8085/test", this.form, {
        headers: {
          "Content-Type": "application/json",
        },
      });
      alert(this.form);
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.form.movieName = "";
      this.form.description = "";
      this.form.rating = null;
      this.form.genre = [];
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>
