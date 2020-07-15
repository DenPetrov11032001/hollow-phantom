<template>
    <v-list-item class="mb-1" id="comment">
        <user-link
                :user="comment.author"
        ></user-link>
        <v-list-item-content class="pb-4">
            <v-list-item-title>{{ comment.text }}</v-list-item-title>
        </v-list-item-content>
        <v-card-actions class="btn-float" v-if="isAuthor">
            <v-btn value="Edit" @click="edit" small text rounded>Edit</v-btn>
            <v-btn icon @click="del" small>
                <v-icon class="btn__clear">clear</v-icon>
            </v-btn>
        </v-card-actions>
    </v-list-item>
</template>

<script>
    import UserLink from 'components/UserLink.vue'
    import { mapActions } from "vuex";

    export default {
        name: 'CommentItem',
        components: { UserLink },
        props: ['comment', 'editComment'],
        methods: {
            ...mapActions(['removeCommentAction']),
            edit() {
                this.editComment(this.comment)
            },
            del() {
                this.removeCommentAction(this.comment)
            }
        },
        computed: {
            isAuthor() {
                return this.comment.author.id === profile.id
            }
        }
    }
</script>

<style scoped>
    .btn__clear {
        color: black;
    }
</style>