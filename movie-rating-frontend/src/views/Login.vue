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
            v-model="form.email"
            type="email"
            required
            placeholder="Enter email"
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
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        email: "",
        password: "",
      },
      show: true,
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
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
  margin-top: 100em;
  width: 30em;
  margin: auto;
}
</style>
