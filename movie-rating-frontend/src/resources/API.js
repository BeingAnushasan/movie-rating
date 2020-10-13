import axios from "axios";

export default {
    localLink: "http://192.168.1.13:8086",

    theMovieDBLink: "https://api.themoviedb.org/3/search/movie?api_key=f69685ff175d2d4f542c2d6001185d43&page=1&query=",
    jwt: null,
    auth:  null,


  authenticate(AuthReq) {
    this.auth = AuthReq;
    console.log(this.auth);
    axios.post(this.localLink+"/authenticate", AuthReq, {
      headers: {
        "Content-Type": "application/json",
      },
    })
    .then(result => this.jwt=result.data.jwt)
    .then(console.log(this.jwt))
    .then( localStorage.setItem('user', JSON.stringify(this.jwt)))
    // .finally(this.sayHello(this.jwt))
    
  },

  sayHello() {
    axios.get(this.localLink+"/hello",{
      headers: { 
        'Authorization': 'Bearer '+this.jwt
      },
    } )
  },


  searchByNameTheMovieDB(name) {
    return axios.get(
      this.theMovieDBLink+`${name}`
    );
    //   .then((response) => response.data.results);
  },

  getAllMoviesFromMyDB() {
    return axios.get(this.localLink+"/movie");
  },

  getMoviesFromMyDB(name, genre) {
    return axios
    .get(
        this.localLink+"/search?genre=" +
        genre +
        "&name=" +
        name
    )
  },

  saveMovieInMyDB(movie) {
    axios.post(this.localLink+"/movie", movie, {
      headers: {
        "Content-Type": "application/json",
      },
    });
  },
};
