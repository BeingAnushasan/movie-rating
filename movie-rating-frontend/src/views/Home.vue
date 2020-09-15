<template>
  <div class="home">
    <h1>Add Movie</h1>
    <AddMovie/>
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
