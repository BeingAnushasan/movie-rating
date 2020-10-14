<template>
  <div class="home" v-if="$store.state.isLoggedIn">
    <AddMovie  class="container"/>
  </div>
</template>

<script>
// @ is an alias to /src
 import AddMovie from '@/components/AddMovie.vue'

export default {
  name: 'Home',
  components: {
    AddMovie,
  }
}
</script>
