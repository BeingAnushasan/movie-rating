<template>
  <div class="container">
    <br />

    <div class="card bg-light">
      <article class="card-body mx-auto" style="max-width: 400px;">
        <h4 class="card-title mt-3 text-center">Create Account</h4>

        <form>
          <!-- full name -->
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-user"></i>
              </span>
            </div>
            <input
              name=""
              class="form-control"
              placeholder="Full name"
              type="text"
              v-model="form.fullName"
            />
          </div>
          <!-- form-group// -->
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-envelope"></i>
              </span>
            </div>
            <input
              name=""
              class="form-control"
              placeholder="Email address"
              type="email"
              v-model="form.email"
            />
          </div>
          <!-- form-group// -->
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-phone"></i>
              </span>
            </div>
            <select class="custom-select" style="max-width: 120px;">
              <option selected="">+977</option>
              <!-- <option value="1">+972</option>
              <option value="2">+198</option>
              <option value="3">+701</option> -->
            </select>
            <input
              name=""
              class="form-control"
              placeholder="Phone number"
              type="text"
              v-model="form.phoneNumber"
            />
          </div>
          <!-- form-group// -->
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-user"></i>
              </span>
            </div>
            <input
              name=""
              class="form-control"
              placeholder="Username"
              type="text"
              v-model="form.username"
            />
          </div>
          <!-- form-group end.// -->
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-lock"></i>
              </span>
            </div>
            <input
              class="form-control"
              placeholder="Create password"
              type="password"
              v-model="form.password"
            />
          </div>
          <!-- form-group// -->
          <div class="form-group input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-lock"></i>
              </span>
            </div>
            <input
              class="form-control"
              placeholder="Repeat password"
              type="password"
              v-model="repeatPassword"
            />
          </div>
          <!-- form-group// -->
          <div class="form-group">
            <button
              type="submit"
              class="btn btn-primary btn-block"
              @click="signUp($event)"
            >
              Create Account
            </button>
          </div>
          <!-- form-group// -->

          <p class="divider-text">
            <span class="bg-light">OR</span>
          </p>
          <p class="text-center">
            Have an account? <a href="/login">Log In</a>
          </p>
        </form>
      </article>
    </div>
    <!-- card.// -->
  </div>
  <!--container end.//-->
</template>

<script>
import API from "../resources/API";
export default {
  data() {
    return {
      form: {
        fullName: null,
        email: null,
        phoneNumber: null,
        username: null,
        password: null,
        enabled: null,
        accountNonExpired: null,
        credentialsNonExpired: null,
        accountNonLocked: null,
        movies: [],
        roles: [],
      },

      repeatPassword: null,
    };
  },
  methods: {
    signUp(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
      if (this.form.password === this.repeatPassword) {
        API.signUp(this.form)
            .then((res) => this.toLogin(res) )
            .catch(function(error) {
              console.log("Show error notification!: " + error);
              return Promise.reject(error);
            });
      } else {
        alert("Password didnot match!");
      }
    },

    toLogin(res) {
              if(res.status == 201){
                  this.$router.push('Login')
                }
                else{
                  alert("Could not signup. Please try again!")
                }
    },
  },

};
</script>

<style>
.divider-text {
  position: relative;
  text-align: center;
  margin-top: 15px;
  margin-bottom: 15px;
}
.divider-text span {
  padding: 7px;
  font-size: 12px;
  position: relative;
  z-index: 2;
}
.divider-text:after {
  content: "";
  position: absolute;
  width: 100%;
  border-bottom: 1px solid #ddd;
  top: 55%;
  left: 0;
  z-index: 1;
}

.btn-facebook {
  background-color: #405d9d;
  color: #fff;
}
.btn-twitter {
  background-color: #42aeec;
  color: #fff;
}
</style>
