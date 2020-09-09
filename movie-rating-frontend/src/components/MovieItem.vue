<template>
    <div>
       <ul>
           <li>{{name}}</li>
        </ul> 
    </div>
</template>

<script>
    export default {
        name: "MovieItem",

        data: function(){
            return{
                list: null,
                name: "IDK"
            }
        },

    }
</script>