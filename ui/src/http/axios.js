import axios from 'axios'
import store from '../store'

const instance = axios.create({
    baseURL: 'http://localhost:8080'
})

instance.interceptors.request.use(
    config => {
        console.log(store)
        if(store.state['Authorization']) {
            config.headers['Authorization'] = store.state['Authorization'];
        }
        
        return config;
    },
    error => {
        return Promise.reject(error);
    }
)

// instance.interceptors.response.use(
//     response => {
//         if(!response.data.errorCode) {
//             return Promise.reject(error);
//         }
//         return response;
//     },
//     error => {
//         return Promise.reject(error);
//     }
// )

export default instance