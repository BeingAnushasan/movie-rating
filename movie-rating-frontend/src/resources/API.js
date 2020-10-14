import axios from "axios";
// import store from "../store/index";

export default {
  localLink: "http://192.168.1.13:8085",

  theMovieDBLink:
    "https://api.themoviedb.org/3/search/movie?api_key=f69685ff175d2d4f542c2d6001185d43&page=1&query=",

  authenticate(AuthReq) {
    this.auth = AuthReq;

    return axios
      .post(this.localLink + "/authenticate", AuthReq, {
        headers: {
          "Content-Type": "application/json",
        },
      });
      
   
  },

  sayHello() {
    axios.get(this.localLink + "/hello", {
      headers: {
        Authorization: "Bearer "+JSON.parse(localStorage.getItem(`token`)),
      },
    });
  },

  searchByNameTheMovieDB(name) {
    return axios.get(this.theMovieDBLink + `${name}`);
    //   .then((response) => response.data.results);
  },

  getAllMoviesFromMyDB() {
    return axios.get(this.localLink + "/movie");
  },

  getMoviesFromMyDB(name, genre) {
    return axios.get(
      this.localLink + "/search?genre=" + genre + "&name=" + name
    );
  },

  saveMovieInMyDB(movie) {
    axios.post(this.localLink + "/movie", movie, {
      headers: {
        "Content-Type": "application/json",
      },
    });
  },
};