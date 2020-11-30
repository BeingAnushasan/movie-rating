import axios from "axios";
import store from "../store/index";

export default {
  localLink: store.state.backend_URL,
  // localLink: "http://localhost:8085",


  theMovieDBLink:
    "https://api.themoviedb.org/3/search/movie?api_key=f69685ff175d2d4f542c2d6001185d43&page=1&query=",

  authenticate(AuthReq) {
    // this.auth = AuthReq;

    return axios.post(this.localLink + "/security/login", AuthReq, {
      headers: {
        "Content-Type": "application/json",
      },
    });
  },

  signUp(userAuthReq) {
    return axios.post(this.localLink + "/security/signup", userAuthReq, {
      headers: {
        "Content-Type": "application/json",
      },
    });
  },

  // signUp(userDetails) {
  //     axios.post(this.localLink+"/authenticate/signup", userDetails, {
  //       headers: {
  //         "Content-Type": "application/json",
  //       },
  //     }).then((response) => (console.log("signup api called: ")+response))
  //     .catch(
  //       function (error) {
  //         console.log('Show error notification!: '+error)
  //         return Promise.reject(error)
  //       }
  //     );
  // },

  sayHello() {
    axios.get(this.localLink + "/hello", {
      headers: {
        Authorization: "Bearer " + JSON.parse(localStorage.getItem(`token`)),
      },
    });
  },

  searchByNameTheMovieDB(name) {
    return axios.get(this.theMovieDBLink + `${name}`, {
      headers: {
        Authorization: "Bearer " + JSON.parse(localStorage.getItem(`token`)),
      },
    });
    //   .then((response) => response.data.results);
  },

  getAllMoviesFromMyDB() {
    return axios.get(this.localLink + "/movie", {
      headers: {
        Authorization: "Bearer " + JSON.parse(localStorage.getItem(`token`)),
      },
    });
  },

  getMoviesFromMyDB(name, genre) {
    return axios.get(
      this.localLink + "/search?genre=" + genre + "&name=" + name,
      {
        headers: {
          Authorization: "Bearer " + JSON.parse(localStorage.getItem(`token`)),
        },
      }
    );
  },

  saveMovieInMyDB(movie) {
    axios.post(this.localLink + "/movie", movie, {
      headers: {
        "Content-Type": "application/json",
        Authorization: "Bearer " + JSON.parse(localStorage.getItem(`token`)),
      },
    });
  },
};
