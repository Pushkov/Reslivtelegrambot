import axios from "axios";

export const AXIOS = axios.create({
    // baseURL: `http://172.17.13.31/tms/api`
    baseURL: `http://localhost:8080/tms/api`
});