<template>
    <h4>
        <li @click="getPlaceInModal">
            {{place.name}}
        </li>
    </h4>
</template>

<script>
    export default {
        name: "PlaceTableRow",
        props: {
            place: {
                type: Object,
                default: () => {
                    return {}
                }
            }
        },
        methods: {
            getPlaceInModal() {
                // console.log("PlaceTableRow - getPlaceModal " + this.place.name)
                this.$emit('getPlaceInModal', this.place);
            }
        },
    }
</script>

<style scoped>

</style>