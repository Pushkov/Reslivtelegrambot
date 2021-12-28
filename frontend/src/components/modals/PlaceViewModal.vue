<template>
    <div class="nic-popup-body container-fluid">
        <div class="row my-1 mx-2" v-if="itemUser.id !== undefined">
            <div class="col-4 mr-2 ">Id:</div>
            <b-input
                    class="col-sm text-secondary  border rounded-lg"
                    readonly
                    :value="itemUser.id"
                    v-model="itemUser.id"
            />
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2">Город:</div>
            <select v-if="isEdit"
                    class="col-sm text-secondary bg-light border rounded-lg"
                    v-model="itemUser.city"
            >
                <option
                        v-for="option in cities"
                        :value="option.name"
                        :key="option.name"
                >
                    {{option.name}}
                </option>
            </select>
            <b-input
                    v-else
                    class="col-sm text-secondary  border rounded-lg"
                    readonly
                    :value="itemUser.city"
            />
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2 ">Название:</div>
            <b-input
                    class="col-sm text-secondary  border rounded-lg"
                    :readonly="!isEdit"
                    :value="itemUser.name"
                    v-model="itemUser.name"/>
        </div>
        <div class="row my-1 mx-2">
            <div class="col-4 mr-2">Оценка:</div>
            <select
                    v-if="isEdit"
                    class="col-sm text-secondary bg-light border rounded-lg"
                    :readonly="!isEdit"
                    v-model="itemUser.grade"
            >
                <option
                        v-for="option in grades"
                        :value="option.value"
                        :key="option.value"
                >
                    {{option.text}}
                </option>
            </select>
            <b-input
                    v-else
                    class="col-sm text-secondary  border rounded-lg"
                    readonly
                    :value="itemUser.grade === 'GOOD' ?'Рекомендовано':'Не рекомендовано'"
            />
        </div>
    </div>
</template>

<script>
    export default {
        name: "PlaceViewModal",
        data() {
            return {
                itemUser: {...this.item},
                grades: [
                    {value: 'GOOD', text: 'Рекомендовано'},
                    {value: 'BAD', text: 'Не рекомендовано'}
                ],
            }
        },
        props: {
            cities: [],

            item: {
                type: Object,
                default: () => {
                    return {}
                }
            },
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        computed: {
            itemName() {
                return this.isEdit ? this.itemUser.name : this.item.name;
            }
        },
        methods: {
            returnUser() {
                this.$emit('returnUser', this.itemUser);
            }
        }

    }
</script>

<style scoped>

</style>