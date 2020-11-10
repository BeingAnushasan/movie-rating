<template>
    <div>
        <MovieLibraryParent v-if="$store.state.isLoggedIn"/>
    </div>
</template>

<script>
    import MovieLibraryParent from "../components/MovieLibraryParent"
    export default {
        name: "Library",
        components: {
            MovieLibraryParent,
        }
    }
</script>