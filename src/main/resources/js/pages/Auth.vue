<template>
    <v-container class="form">
        Необходимо авторизоваться через
        <a href="/login">Google</a>
    </v-container>
</template>

<script>
    export default {
        name: 'Auth'
    }
</script>

<style scoped>
    .form {
        max-width: 900px !important;
    }
</style>