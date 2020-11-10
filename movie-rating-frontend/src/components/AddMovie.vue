<template>
  <div class="container">
    <div class="card bg-light">
      <h1 id="textTop">Add To Library</h1>
      <!-- <button @click="increment">Increment {{ $store.state.count }}</button> -->
      <div>
        <input
          type="text"
          placeholder="Search"
          v-model="searchName"
          @input="searchByName"
          required
        />
        <b-button type="submit" @click="searchByName">Search</b-button>

        <div
          class="floatingRectangle"
          v-if="showSearchResult && theMovieDBResponse.length"
        >
          <ul>
            <li
              @click="fillTheForm(movie, $event)"
              v-for="movie in theMovieDBResponse.slice(0, 5)"
              :key="movie.id"
            >
              {{ movie.title }} : {{ movie.release_date }}
            </li>
          </ul>
        </div>
      </div>
      <hr />

      <b-form class="my-form" @submit="onSubmit" @reset="onReset" v-if="show">
        <b-container>
          <b-row>
            <b-col>
              <b-form-group
                id="input-group-1"
                label-for="input-1"
                description=""
              >
                <b-form-input
                  id="input-1"
                  v-model="form.movieName"
                  type="text"
                  required
                  placeholder="Movie Name"
                ></b-form-input>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group id="input-group-3" label="" label-for="input-3">
                <b-form-input
                  id="input-3"
                  v-model="form.rating"
                  type="number"
                  min="1"
                  max="10.1"
                  step="0.5"
                  required
                  placeholder="Movie Rating"
                ></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
        </b-container>

        <b-form-group
          id="input-group-2"
          label-align="left"
          label=""
          label-for="input-2"
        >
          <b-form-textarea
            id="input-2"
            v-model="form.description"
            required
            placeholder="Description"
          ></b-form-textarea>
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
            <b-form-checkbox value="Thriller">Thriller</b-form-checkbox>
            <b-form-checkbox value="Si-fi">Si-fi</b-form-checkbox>
          </b-form-checkbox-group>
        </b-form-group>

        <b-button type="submit" variant="primary">Add To Libary</b-button>
        <b-button type="reset" variant="danger">Reset</b-button>
      </b-form>
    </div>
    <div class="mt-3">
      <b-button size="sm" variant="primary" @click="showJSON"
        >Show JSON</b-button
      >
      <b-card
        header="Form Data Result"
        v-if="showJSONBool"
        bg-variant="dark"
        text-variant="white"
        class="text-center "
      >
        <pre class="m-0" style="color: white;">{{ form }}</pre>
      </b-card>
    </div>
  </div>
</template>

<script>
// import axios from "axios";
import API from "../resources/API";
export default {
  name: "AddMovie",
  data() {
    return {
      form: {
        movieName: "",
        description: "",
        rating: null,
        posterLink: null,
        genre: [],
        mu_fk: "1",
      },
      theMovieDBResponse: [],
      searchName: null,

      show: true,
      showJSONBool: false,
      showSearchResult: false,
    };
  },
  methods: {
    increment() {
      this.$store.commit("increment");
    },
    searchByName() {
      if (this.searchName != null) {
        API.searchByNameTheMovieDB(this.searchName).then(
          (response) => (this.theMovieDBResponse = response.data.results)
        );
        this.showSearchResult = true;
      } else alert("Enter Search Name");
    },

    onSubmit(evt) {
      evt.preventDefault();
      API.saveMovieInMyDB(this.form);
      // Reset our form values
      this.resetForm();
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.resetForm();
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
    fillTheForm(movie, evt) {
      evt.preventDefault();
      this.showSearchResult = false;
      this.form.movieName = movie.title;
      this.form.description = movie.overview; //.substring(0, 255);
      this.form.posterLink = movie.poster_path;
    },

    resetForm() {
      this.form.movieName = "";
      this.form.description = "";
      this.form.rating = null;
      (this.form.posterLink = ""), (this.form.genre = []);

      this.theMovieDBResponse = [];
      this.searchName = "";
    },
    showJSON(evt) {
      evt.preventDefault();
      this.showJSONBool = !this.showJSONBool;
    },
  },
};
</script>

<style scoped>
#addmovie {
  text-align: center;
}

.my-form {
  width: 100%;
  margin: auto;
}
.rating {
  width: 100%;
  /* margin-right: 0em; */
}
.floatingRectangle {
  z-index: 1;
  position: absolute;
  left: 0;
  right: 0;
  /* bottom: 20px; */

  /* height: 100px; */

  background-color: cadetblue;
  color: white;
  align-self: center;

  /* padding: 0; */
}
</style>
