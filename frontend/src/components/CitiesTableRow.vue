<template>
    <tr>
        <td @click="getCityModal">
            <h3>{{city.name}}</h3>
        </td>
        <td>
            <div v-if="city.goodPlaces !== undefined && city.goodPlaces.length > 0">
                <ul v-for="place of city.goodPlaces"
                    :key="place.id"
                >
                    <PlaceTableRow
                            :place="place"
                            @getPlaceInModal="getPlaceModal(city.id,place)"
                    />

                </ul>
            </div>
            <div v-else>
                <h5>-</h5>
            </div>
        </td>
        <td>
            <div v-if="city.badPlaces !== undefined && city.badPlaces.length > 0">
                <ul v-for="place of city.badPlaces"
                    :key="place.id"
                >
                    <PlaceTableRow
                            :place="place"
                            @getPlaceInModal="getPlaceModal(city.id,place)"
                    />

                </ul>
            </div>
            <div v-else>
                <h5>-</h5>
            </div>
        </td>
    </tr>

</template>

<script>
    import PlaceTableRow from "./PlaceTableRow";

    export default {
        name: "CityTableRow",
        props: {
            city: {
                type: Object,
                default: () => {
                    return {}
                }
            }
        },
        components: {
            PlaceTableRow
        },
        computed: {},
        methods: {
            getCityModal() {
                this.$emit('getCityModal', this.city);
            },
            getPlaceModal(id, place) {
                this.$emit('getPlaceModal', place);
            }
        },
    }
</script>

<style scoped>

</style>