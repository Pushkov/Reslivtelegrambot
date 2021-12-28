<template class=" mt-xl-5">
    <div class="w-75 m-auto">

        <CityModal
                v-if="isCityModal"
                :popup-title="getCityModalTitle"
                :is-edit="isModalEdit"
                @closeUserModal="closeCityModal"
        >
            <CityViewModal
                    ref="cityView"
                    :item="currentCity"
                    :is-edit="isModalEdit"
                    @returnUser='returnCity'
            />
            <CityFooterModel
                    slot="footer"
                    @modalClose="closeCityModal"
                    @saveItem='saveCity'
                    @deleteItem="deleteCity"
                    @editItem="editCity"
                    :is-edit="isModalEdit"
                    :is-create="isModalCreate"
            />
        </CityModal>

        <CityModal
                v-if="isPlaceModal"
                :popup-title="getPlaceModalTitle"
                :is-edit="isModalEdit"
                @closeUserModal="closePlaceModal"
        >
            <PlaceViewModal
                    ref="placeView"
                    :cities="CITIES"
                    :item="currentPlace"
                    :is-edit="isModalEdit"
                    @returnUser='returnPlace'
            />
            <CityFooterModel
                    slot="footer"
                    @modalClose="closePlaceModal"
                    @saveItem='savePlace'
                    @deleteItem="deletePlace"
                    @editItem="editPlace"
                    :is-edit="isModalEdit"
                    :is-create="isModalCreate"
            />
        </CityModal>

        <div v-if="3 > 0">
            <div class="text-left my-3">
                <b-button @click="createCity" class="mr-1"><h5 class="m-auto">Добавить город</h5></b-button>
                <b-button @click="createPlace" class="mr-1"><h5 class="m-auto">Добавить место</h5></b-button>
            </div>

            <table class="table table-hover table-bordered table-striped">
                <thead class="thead-light">
                <tr>
                    <th>Название</th>
                    <th>Рекомендовано</th>
                    <th>Не заслуживает внимания</th>
                </tr>
                </thead>
                <tbody>
                <CitiesTableRow
                        v-for="city of CITIES"
                        :city="city"
                        :key="city.id"
                        @getCityModal="showCityModal(city)"
                        @getPlaceModal="showPlaceModal"
                />
                </tbody>
            </table>
        </div>
        <div v-else>
            <h3>ERROR_LIST_LOAIDNG_MESSAGE</h3>
        </div>
    </div>
</template>


<script>
    import {mapActions, mapGetters} from 'vuex'
    import CitiesTableRow from "./CitiesTableRow";
    import CityModal from "./modals/CityModal";
    import CityViewModal from "./modals/CityViewModal";
    import CityFooterModel from "./modals/CityFooterModal";
    import PlaceViewModal from "./modals/PlaceViewModal";

    export default {
        name: "CityList",
        data() {
            return {
                currentCity: {},
                currentPlace: {},
                isCityModal: false,
                isPlaceModal: false,
                isModalEdit: false,
                isModalCreate: false
            }
        },
        components: {
            PlaceViewModal,
            CityFooterModel,
            CityViewModal,
            CityModal,
            CitiesTableRow
        },
        computed: {
            ...mapGetters([
                'CITIES',
                'ERROR_LIST_LOAIDNG_MESSAGE'
            ]),
            getCityModalTitle() {
                return this.isModalCreate
                    ? 'Создать запись о новом городе'
                    : 'Информация о городе';
            },
            getPlaceModalTitle() {
                return this.isModalCreate
                    ? 'Создать запись о новом месте в городе'
                    : 'Информация о месте в городе';
            },
        },
        methods: {
            ...mapActions([
                'GET_ALL_CITIES',
                'CREATE_CITY',
                'UPDATE_CITY',
                'DELETE_CITY',
                'GET_ALL_PLACES',
                'CREATE_PLACE',
                'UPDATE_PLACE',
                'DELETE_PLACE'
            ]),
            showCityModal(city) {
                this.isModalCreate = false;
                this.isCityModal = true;
                this.isModalEdit = false;
                this.currentCity = city;
            },
            closeCityModal() {
                this.isCityModal = false;
                this.isModalEdit = false;
                this.isModalCreate = false;
            },
            returnCity(city) {
                this.currentCity = city;
            },
            createCity() {
                this.isModalCreate = true;
                this.isCityModal = true;
                this.isModalEdit = true;
                this.currentCity = {};
            },
            saveCity() {
                this.$refs.cityView.returnUser();
                if (this.currentCity.id === undefined) {
                    this.CREATE_CITY(this.currentCity);
                } else
                    this.UPDATE_CITY(this.currentCity);
                this.closeCityModal();
            },
            deleteCity() {
                this.$refs.cityView.returnUser();
                this.DELETE_CITY(this.currentCity);
                this.closeCityModal();
            },
            editCity(isEdit) {
                console.log(isEdit)
                this.isModalEdit = isEdit;
            },
            showPlaceModal(place) {
                this.isModalCreate = false;
                this.isPlaceModal = true;
                this.isModalEdit = false;
                this.currentPlace = place;
            },
            closePlaceModal() {
                this.isPlaceModal = false;
                this.isModalEdit = false;
                this.isModalCreate = false;
            },
            returnPlace(place) {
                this.currentPlace = place;
            },
            createPlace() {
                this.isModalCreate = true;
                this.isPlaceModal = true;
                this.isModalEdit = true;
                this.currentPlace = {};
            },
            savePlace() {
                this.$refs.placeView.returnUser();
                if (this.currentPlace.id === undefined) {
                    this.CREATE_PLACE(this.currentPlace);
                } else
                    this.UPDATE_PLACE(this.currentPlace);
                this.closePlaceModal();
            },
            deletePlace() {
                this.$refs.placeView.returnUser();
                this.DELETE_PLACE(this.currentPlace);
                this.closePlaceModal();
            },
            editPlace(isEdit) {
                console.log(isEdit)
                this.isModalEdit = isEdit;
            }
        },
        mounted() {
            this.GET_ALL_CITIES();
        }
    }
</script>

<style scoped>

</style>