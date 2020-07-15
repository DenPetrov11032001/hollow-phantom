<template>
    <v-layout row class="pl-3">
        <v-text-field
                label="New message"
                placeholder="Write something"
                v-model="text"
                counter
                maxlength="255"
                @keyup.enter="save"
        />
        <v-btn @click="save" class="mx-2" fab dark color="grey" >
            <v-icon dark>send</v-icon>
        </v-btn>
    </v-layout>
</template>

<script>
    import { mapActions } from 'vuex'

    export default {
        props: ['messageAttr'],
        data() {
            return {
                text: '',
                id: null
            }
        },
        watch: {
            messageAttr(newVal, oldVal) {
                this.text = newVal.text
                this.id = newVal.id
            }
        },
        methods: {
            ...mapActions(['addMessageAction', 'updateMessageAction']),
            save() {
                const message = {
                    id: this.id,
                    text: this.text
                }
                if (this.id) {
                    this.updateMessageAction(message)
                } else {
                    this.addMessageAction(message)
                }
                this.text = ''
                this.id = null
            }
        }
    }
</script>

<style>
</style>