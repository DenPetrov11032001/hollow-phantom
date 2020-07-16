<template>
    <v-app>
        <v-app-bar app class="header">
            <v-toolbar-title class="header-title header-title__phantom" @click="showMessages">Phantom</v-toolbar-title>
            <v-btn text
                   v-if="profile"
                   @click="showMessages">
                <div v-if="$route.path !== '/'" class="header-title">
                    Messages
                </div>
                <div v-else class="header-title__disabled">
                    Messages
                </div>
            </v-btn>
            <v-spacer></v-spacer>
            <v-btn text
                   v-if="profile"
                   @click="showProfile">
                <div v-if="$route.path !== '/user'" class="header-title">
                    {{ profile.name }}
                </div>
                <div v-else class="header-title__disabled">
                    {{ profile.name }}
                </div>
            </v-btn>
            <v-btn v-if="profile" icon href="/logout">
                <v-icon class="header-title">exit_to_app</v-icon>
            </v-btn>
        </v-app-bar>
        <v-main>
            <router-view></router-view>
        </v-main>
    </v-app>
</template>

<script>
    import { mapState, mapMutations } from 'vuex'
    import { addHandler } from 'util/ws'

    export default {
        computed: mapState(['profile']),
        methods: {
            ...mapMutations([
                'addMessageMutation',
                'updateMessageMutation',
                'removeMessageMutation',
                'addCommentMutation',
                'updateCommentMutation',
                'removeCommentMutation'
            ]),
            showMessages() {
                this.$router.push('/')
            },
            showProfile() {
                this.$router.push('/user')
            }
        },
        created() {
            addHandler(data => {
                if (data.objectType === 'MESSAGE') {
                    switch (data.eventType) {
                        case 'CREATE':
                            this.addMessageMutation(data.body)
                            break
                        case 'UPDATE':
                            this.updateMessageMutation(data.body)
                            break
                        case 'REMOVE':
                            this.removeMessageMutation(data.body)
                            break
                        default:
                            console.error(`Looks like the event type if unknown "${data.eventType}"`)
                    }
                } else if (data.objectType === 'COMMENT') {
                    switch (data.eventType) {
                        case 'CREATE':
                            this.addCommentMutation(data.body)
                            break
                        case 'UPDATE':
                            this.updateCommentMutation(data.body)
                            break
                        case 'REMOVE':
                            this.removeCommentMutation(data.body)
                            break
                        default:
                            console.error(`Looks like the event type if unknown "${data.eventType}"`)
                    }
                } else {
                    console.error(`Looks like the object type if unknown "${data.objectType}"`)
                }
            })
        },
        beforeMount() {
            if (!this.profile) {
                this.$router.replace('/auth')
            }
        }
    }
</script>

<style>
    .header {
        background-color: rgba(33, 33, 33, 0.98) !important;
    }
    .header-title {
        color: azure !important;
    }
    .header-title__phantom {
        margin-bottom: 3px;
    }
    .header-title__disabled {
        color: #656565 !important;
    }
</style>