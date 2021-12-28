import Vue from 'vue'
import Vuex from 'vuex'
import {AXIOS} from "@/vuex/axios-export"

Vue.use(Vuex);

let store = new Vuex.Store({
    state: {
        cities: [],
        places: [],
        error_list_loading_message: 'ниудачко'
    },
    getters: {
        CITIES: state => state.cities,
        PLACES: state => state.places,
        ERROR_LIST_LOAIDNG_MESSAGE: state => state.error_list_loading_message,
    },
    actions: {
        GET_ALL_CITIES: async ({commit}) => {
            await AXIOS.get('/city')
                .then(responce => {
                    commit('GET_CITIES', responce.data);
                })
                .catch(error => {
                        commit('SET_ERROR_LIST_LOADING_MESSAGE', error.message)
                    }
                )
        },
        CREATE_CITY: ({dispatch}, city) => {
            AXIOS.post(
                '/city',
                city
            ).then(() => {
                dispatch('GET_ALL_CITIES');
            })
        },
        UPDATE_CITY: ({dispatch}, city) => {
            AXIOS.put(
                '/city/' + city.id,
                city
            ).then(() => {
                dispatch('GET_ALL_CITIES');
            })
        },
        DELETE_CITY: ({dispatch}, city) => {
            AXIOS.delete('/city/' + city.id
            ).then(() => {
                dispatch('GET_ALL_CITIES');
            })
        },
        GET_ALL_PLACES: async ({commit}) => {
            await AXIOS.get('/place')
                .then(responce => {
                    commit('GET_PLACES', responce.data);
                })
                .catch(error => {
                        commit('SET_ERROR_LIST_LOADING_MESSAGE', error.message)
                    }
                )
        },
        CREATE_PLACE: ({dispatch}, place) => {
            AXIOS.post(
                '/place',
                place
            ).then(() => {
                dispatch('GET_ALL_CITIES');
            })
        },
        UPDATE_PLACE: ({dispatch}, place) => {
            AXIOS.put(
                '/place/' + place.id,
                place
            ).then(() => {
                dispatch('GET_ALL_CITIES');
            })
        },
        DELETE_PLACE: ({dispatch}, place) => {
            AXIOS.delete('/place/' + place.id
            ).then(() => {
                dispatch('GET_ALL_CITIES');
            })
        },
    },
    mutations: {
        GET_CITIES: (state, cities) => {
            state.cities = cities;
            state.error_list_loading_message = '';
        },
        SET_ERROR_LIST_LOADING_MESSAGE: (state, msg) => {
            state.error_list_loading_message = msg;
        }
    }
});

export default store;