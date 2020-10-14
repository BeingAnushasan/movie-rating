<template>
    <div>
        <MovieIteam v-if="$store.state.isLoggedIn"/>
    </div>
</template>

<script>
    import MovieIteam from "../components/MovieItem"
    export default {
        name: "Library",
        components: {
            MovieIteam,
        }
    }
</script>