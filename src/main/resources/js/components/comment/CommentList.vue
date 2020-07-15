<template>
    <v-list two-line>
        <v-divider
        ></v-divider>

        <v-subheader>
            Comments
        </v-subheader>

        <template
                v-for="(item, index) in comments"
        >
            <v-divider
                    v-if="index > 0"
                    :key="index"
            ></v-divider>

            <comment-item
                    :comment="item"
                    :key="'item' + index"
                    :editComment="editComment"
            ></comment-item>
        </template>

        <comment-form
                :message-id="messageId"
                :commentAttr="comment"
        ></comment-form>
    </v-list>
</template>

<script>
    import CommentForm from './CommentForm.vue'
    import CommentItem from './CommentItem.vue'

    export default {
        name: 'CommentList',
        components: { CommentForm, CommentItem },
        data() {
            return {
                comment: null
            }
        },
        props: ['comments', 'messageId'],
        methods: {
            editComment(comment) {
                this.comment = comment
            }
        }
    }
</script>

<style scoped>

</style>