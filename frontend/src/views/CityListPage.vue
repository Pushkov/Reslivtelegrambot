<template>
    <div>
        <NavigationBar/>
        <CityList/>
        <!--        <h4>CityList Page</h4>-->
    </div>
</template>

<script>
    import NavigationBar from "@/components/NavigationBar";
    import {mapActions} from 'vuex'
    import CityList from "../components/CityList";

    export default {
        name: "Index",
        data() {
            return {}
        },
        components: {
            CityList,
            NavigationBar,
        },
        methods: {
            ...mapActions([
                'GET'
            ])
        }
    }
</script>

<style scoped>

</style>