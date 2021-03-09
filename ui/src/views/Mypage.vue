<template>
    <div>{{userInfo.username}}님 환영합니다.</div>
</template>

<script>
import { mapState } from 'vuex'

export default {
    computed: {
        ...mapState(['userInfo'])
    }
}
</script>