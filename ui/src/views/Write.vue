<template>
    <v-container fill-height style="max-width:800px;">
        <v-layout align-center row wrap>
            <v-flex xs12>
                <v-alert
                    :value="isWriteError"
                    type="error"
                >
                    {{errorMessage}}
                </v-alert>
                <v-card>
                    <v-toolbar flat>
                        <v-toolbar-title>Write</v-toolbar-title> 
                    </v-toolbar>
                    <div class="pa-3">
                    <v-text-field
                        v-model="title"
                        label="Title"
                    >
                    </v-text-field>
                    <v-textarea
                        row-height="30"
                        outlined
                        label="Content"
                        v-model="content"
                    ></v-textarea> 
                    <v-btn 
                        large
                        block 
                        depressed 
                        color="primary"
                        @click="write()"
                        >Write</v-btn>
                    </div>
                </v-card>
            </v-flex>
        </v-layout> 
    </v-container>
</template>

<script>
import router from '../router'

export default {
    data() {
        return {
            title: null,
            content: null,
            isWriteError: false,
            errorMessage: null,
        }
    },
    methods: {
        write() {
            if(!this.isValidForm()) {
                return false;
            }

            this.$http.post('/api/v1/post', {
                title: this.title,
                content: this.content
            }).then(response => {
                console.log(response)
                if(response.data.errorMessage) {
                    this.errorMessage = '게시글 등록에 실패 했습니다.'
                    return
                }
                router.push({name: "home"})
            }).catch(error => {

            })
        },
        isValidForm() {
            if(!this.title) {
                this.errorMessage = '제목을 확인해 주세요.'
                this.isWriteError = true
                return false
            }

            if(!this.content) {
                this.errorMessage = '내용을 확인해 주세요.'
                this.isWriteError = true
                return false
            }

            this.errorMessage = ''
            this.isWriteError = false

            return true
        }
    }

}
</script>

<style>

</style>