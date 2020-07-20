<template>
    <v-card class="my-2" id="message">
        <v-card-text primary-title>
            <user-link
                    :user="message.author"
                    size="48"
            ></user-link>
            <v-card-actions class="btn__float" v-if="isAuthor">
                <v-btn value="Edit" @click="edit" small text rounded id="editMessage">Edit</v-btn>
                <v-btn icon @click="del" small id="deleteMessage">
                    <v-icon class="btn__clear">clear</v-icon>
                </v-btn>
            </v-card-actions>
            <div class="pt-3 text">
                {{ message.text }}
            </div>
        </v-card-text>
        <media v-if="message.link" :message="message"></media>
        <comment-list
                :comments="message.comments"
                :message-id="message.id"
        ></comment-list>
    </v-card>
</template>

<script>
    import { mapActions } from 'vuex'
    import Media from 'components/media/Media.vue'
    import CommentList from '../comment/CommentList.vue'
    import UserLink from 'components/UserLink.vue'

    export default {
        props: ['message', 'editMessage'],
        components: { UserLink, CommentList, Media },
        methods: {
            ...mapActions(['removeMessageAction']),
            edit() {
                this.editMessage(this.message)
            },
            del() {
                this.removeMessageAction(this.message)
            }
        },
        computed: {
            isAuthor() {
                return this.message.author.id === profile.id
            }
        }
    }
</script>

<style>
    .text {
        color: black;
        font-weight: 400;
        Size: 3rem;
    }
    .btn__float {
        float: right;
    }
    .btn__clear {
        color: black !important;
    }
</style>