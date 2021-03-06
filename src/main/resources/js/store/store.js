import Vue from 'vue'
import Vuex from 'vuex'
import messagesApi from 'api/messages'
import commentApi from 'api/comment'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        messages,
        profile,
        ...frontendData
    },
    getters: {
        sortedMessages: state => (state.messages || []).sort((a, b) => -(a.id - b.id))
    },
    mutations: {
        addMessageMutation(state, message) {
            state.messages = [
                ...state.messages,
                message
            ]
        },
        updateMessageMutation(state, message) {
            const updateIndex = state.messages.findIndex(item => item.id === message.id)

            state.messages = [
                ...state.messages.slice(0, updateIndex),
                message,
                ...state.messages.slice(updateIndex + 1)
            ]
        },
        removeMessageMutation(state, message) {
            const deletionIndex = state.messages.findIndex(item => item.id === message.id)

            if (deletionIndex > -1) {
                state.messages = [
                    ...state.messages.slice(0, deletionIndex),
                    ...state.messages.slice(deletionIndex + 1)
                ]
            }
        },
        addCommentMutation(state, comment) {
            const updateIndex = state.messages.findIndex(item => item.id === comment.message.id)
            const message = state.messages[updateIndex]

            if (message.comments === null) {
                state.messages = [
                    ...state.messages.slice(0, updateIndex),
                    {
                        ...message,
                        comments: [
                            comment
                        ]
                    },
                    ...state.messages.slice(updateIndex + 1)
                ]
            } else if (!message.comments.find(it => it.id === comment.id)) {
                state.messages = [
                    ...state.messages.slice(0, updateIndex),
                    {
                        ...message,
                        comments: [
                            ...message.comments,
                            comment
                        ]
                    },
                    ...state.messages.slice(updateIndex + 1)
                ]
            }
        },
        updateCommentMutation(state, comment) {
            const updateIndexMessage = state.messages.findIndex(item => item.id === comment.message.id)
            const message = state.messages[updateIndexMessage]
            const updateIndexComment = message.comments.findIndex(it => it.id === comment.id)

            state.messages = [
                ...state.messages.slice(0, updateIndexMessage),
                {
                    ...message,
                    comments: [
                        ...message.comments.slice(0, updateIndexComment),
                        comment,
                        ...message.comments.slice(updateIndexComment + 1)
                    ]
                },
                ...state.messages.slice(updateIndexMessage + 1)
            ]
        },
        removeCommentMutation(state, comment) {
            const updateIndexMessage = state.messages.findIndex(item => item.id === comment.message.id)
            const message = state.messages[updateIndexMessage]
            const deleteIndexComment = message.comments.findIndex(it => it.id === comment.id)

            if (deleteIndexComment > -1) {
                state.messages = [
                    ...state.messages.slice(0, updateIndexMessage),
                    {
                        ...message,
                        comments: [
                            ...message.comments.slice(0, deleteIndexComment),
                            ...message.comments.slice(deleteIndexComment + 1)
                        ]
                    },
                    ...state.messages.slice(updateIndexMessage + 1)
                ]
            }
        },
        addMessagePageMutation(state, messages) {
            const targetMessages = state.messages
                .concat(messages)
                .reduce((res, val) => {
                    res[val.id] = val
                    return res
                }, {})

            state.messages = Object.values(targetMessages)
        },
        updateTotalPagesMutation(state, totalPages) {
            state.totalPages = totalPages
        },
        updateCurrentPageMutation(state, currentPage) {
            state.currentPage = currentPage
        }
    },
    actions: {
        async addMessageAction({commit, state}, message) {
            if (message.text !== '') {
                const result = await messagesApi.add(message)
                const data = await result.json()
                const index = state.messages.findIndex(item => item.id === data.id)

                if (index > -1) {
                    commit('updateMessageMutation', data)
                } else {
                    commit('addMessageMutation', data)
                }
            }
        },
        async updateMessageAction({commit}, message) {
            if (message.text !== '') {
                const result = await messagesApi.update(message)
                const data = await result.json()
                commit('updateMessageMutation', data)
            }
        },
        async removeMessageAction({commit}, message) {
            const result = await messagesApi.remove(message.id)

            if (result.ok) {
                commit('removeMessageMutation', message)
            }
        },
        async addCommentAction({commit, state}, comment) {
            if (comment.text !== '') {
                const response = await commentApi.add(comment)
                const data = await response.json()
                const index = state.messages.find(item => item.id === data.id)

                if (index > -1) {
                    commit('updateCommentMutation', data)
                } else {
                    commit('addCommentMutation', data)
               }
            }
        },
        async updateCommentAction({commit}, comment) {
            if (comment.text !== '') {
                const result = await commentApi.update(comment)
                const data = await result.json()
                commit('updateCommentMutation', data)
            }
        },
        async removeCommentAction({commit}, comment) {
            const result = await commentApi.remove(comment.id)

            if (result.ok) {
                commit('removeCommentMutation', comment)
            }
        },
        async loadPageAction({commit, state}) {
            const response = await messagesApi.page(state.currentPage + 1)
            const data = await response.json()

            commit('addMessagePageMutation', data.messages)
            commit('updateTotalPagesMutation', data.totalPages)
            commit('updateCurrentPageMutation', Math.min(data.currentPage, data.totalPages - 1))
        }
    }
})