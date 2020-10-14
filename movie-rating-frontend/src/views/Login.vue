<template>
  <div class="login-card">
    <b-card
      bg-variant="dark"
      header="LOGIN"
      text-variant="white"
      class="text-center "
    >
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group id="input-group-1" label-for="input-1">
          <b-form-input
            id="input-1"
            v-model="form.username"
            type="text"
            required
            placeholder="Enter username"
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label-for="input-2">
          <b-form-input
            id="input-2"
            type="password"
            v-model="form.password"
            required
            placeholder="Password"
          ></b-form-input>
        </b-form-group>

        <b-button type="submit" variant="primary">Login</b-button>

        <b-button type="reset" variant="danger">SignUp</b-button>
      </b-form>
    </b-card>
    <b-button @click="sayHello">say hello</b-button>
  </div>
</template>

<script>
import API from "../resources/API";

export default {
  data() {
    return {
      form: {
        username: "",
        password: "",
      },
      show: true,
    };
  },

  methods: {
    sayHello() {
      API.sayHello();
    },
    onSubmit(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
      API.authenticate(this.form)
        .then((response) =>
          localStorage.setItem("token", JSON.stringify(response.data.jwt))
        )
        .then(this.$store.commit("loggedIn"))
        .then(alert("Logged In Successful"));
        
    },
    onReset(evt) {
      evt.preventDefault();
    },
  },
};
</script>

<style scoped>
.login-card {
  z-index: 2;
  width: 80%;
  margin: auto;
}
</style>
