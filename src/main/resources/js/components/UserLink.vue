<template>
    <router-link
            :to="`/user/${user.id}`"
            class="pr-3 without-line"
    >
        <v-avatar
                v-if="user && user.userpic"
                :size="`${size || 36}px`"
        >
            <img
                    :src="user.userpic"
                    :alt="user.name"
            >
        </v-avatar>

        <v-avatar
                v-else
                :size="`${size || 36}px`"
                color="indigo"
                class="avatar"
        >
            <v-icon dark>account_circle</v-icon>
        </v-avatar>
        <span class="user-name">{{ userName }}</span>
    </router-link>
</template>

<script>
    export default {
        name: 'UserLink',
        props: ['user', 'size'],
        computed: {
            userName() {
                return this.user ? this.user.name : 'unknown'
            },
        },
    }
</script>

<style scoped>
    .without-line {
        text-decoration: none;
    }
</style>