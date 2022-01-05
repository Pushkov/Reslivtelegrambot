<template>
    <div>
        <NavigationBar/>
        <HelloWorld msg="Добро пожаловать!"/>
    </div>
</template>

<script>
    import HelloWorld from '@/components/HelloWorld.vue'
    import NavigationBar from "@/components/NavigationBar";

    export default {
        name: "Index",
        components: {
            NavigationBar,
            HelloWorld
        }
    }
</script>

<style scoped>

</style>