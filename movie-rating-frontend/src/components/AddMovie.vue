<template>
  <div id="addmovie">
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
      <b-button  size="sm" variant="primary" @click="showJSON">Show JSON</b-button>
      <b-card  header="Form Data Result" v-if="showJSONBool">
        <pre class="m-0">{{ form }}</pre>
      </b-card>
    </div>
  </div>
</template>

<script>
import axios from "axios";

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
      ratings: [{ text: "Your Rating", value: null }, "1", "2", "3", "4", "5"],
      show: true,
      showJSONBool: false,
    };
  },
  methods: {
    showJSON(evt) {
      evt.preventDefault();
      this.showJSONBool = !this.showJSONBool;
    },

    onSubmit(evt) {
      evt.preventDefault();
      axios.post("http://localhost:8085/test", this.form, {
        headers: {
          "Content-Type": "application/json",
        },
      });
      //   alert(JSON.stringify(this.form));
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
