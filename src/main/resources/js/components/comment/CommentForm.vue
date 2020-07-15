<template>
    <v-layout row class="pt-6 px-7">
        <v-text-field
                label="Add comment"
                placeholder="Write something"
                v-model="text"
                counter
                maxlength="76"
                @keyup.enter="save"
        />
        <v-btn @click="save" class="mt-3 ml-2">
            Add
        </v-btn>
    </v-layout>
</template>

<script>
    import { mapActions } from 'vuex'

    export default {
        name: 'CommentForm',
        props: ['messageId', 'commentAttr'],
        data() {
            return {
                text: '',
                id: null
            }
        },
        watch: {
            commentAttr(newVal, oldVal) {
                this.text = newVal.text
                this.id = newVal.id
            }
        },
        methods: {
            ...mapActions(['addCommentAction', 'updateCommentAction']),
            save() {
                const comment = {
                    id: this.id,
                    text: this.text
                }

                if (this.id) {
                    this.updateCommentAction(comment)
                } else {
                    this.addCommentAction({
                        text: this.text,
                        message: {
                            id: this.messageId
                        }
                    })
                }
                this.text = ''
            }
        }
    }
</script>

<style scoped>

</style>