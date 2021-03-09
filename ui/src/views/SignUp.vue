<template>
    <v-container fill-height style="max-width:450px;">
        <v-layout align-center row wrap>
            <v-flex xs12>
                <v-alert
                    :value="isSignUpError"
                    type="error"
                >
                    {{errorMessage}}
                </v-alert>
                <v-card>
                    <v-toolbar flat>
                        <v-toolbar-title>Sign Up</v-toolbar-title> 
                    </v-toolbar>
                    <div class="pa-3">
                    <v-text-field
                        v-model="email"
                        label="Email"
                    >
                    </v-text-field>
                    <v-text-field
                        v-model="password"
                        label="Password"
                        type="password"
                    >
                    </v-text-field>
                    <v-text-field
                        v-model="passwordConfirm"
                        label="Password Confirm"
                        type="password"
                    >
                    </v-text-field>
                    <v-text-field
                        v-model="name"
                        label="Name"
                        type="text"
                    >
                    </v-text-field>    
                    <v-btn 
                        large
                        block 
                        depressed 
                        color="primary"
                        @click="signUp({
                            email: email,
                            password: password,
                            passwordConfirm: passwordConfirm,
                            name: name
                        })"
                        >Sign Up</v-btn>
                    </div>
                </v-card>
            </v-flex>
        </v-layout> 
    </v-container>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
    data() {
        return {
            email: null,
            password: null,
            passwordConfirm: null,
            name: null,
            errorMessage: null,
            isSignUpError : false
        }
    },
    computed: {
        ...mapState(['isSignIn', 'isSignInError'])
    },
    methods: {
        ...mapActions(['signIn']),

        signUp(payload) {
            if(!this.isValidForm()) {
                return false;
            }

            this.$http.post('/api/v1/signUp', {
                email: payload.email,
                password: payload.password,
                username: payload.name,
            }).then((response) => {
                if(response.data.errorCode) {
                    this.errorMessage = '가입에 실패 했습니다.'
                    this.isSignUpError = true;
                    return false;
                }

                this.signIn({
                    email: payload.email,
                    password: payload.password
                });
            }).catch((error) => {
                console.log(error)
            })
        },

        isValidForm() {
            if(!this.email) {
                this.errorMessage = '이메일을 확인해 주세요.'
                this.isSignUpError = true;
                return false;
            }

            if(!this.password || !this.passwordConfirm || this.password !== this.passwordConfirm) {
                this.errorMessage = '패스워드를 확인해 주세요.'
                this.isSignUpError = true;
                return false;
            } 

            if(!this.name) {
                this.errorMessage = '이름을 확인해주세요'
                this.isSignUpError = true;
                return false;
            }

            return true;
            
        }
    }
}
</script>