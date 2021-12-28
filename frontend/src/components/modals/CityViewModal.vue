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
            <div class="col-4 mr-2 ">Название:</div>
            <b-input
                    class="col-sm text-secondary  border rounded-lg"
                    :readonly="!isEdit"
                    :value="itemUser.name"
                    v-model="itemUser.name"/>
        </div>
    </div>
</template>

<script>
    export default {
        name: "CityViewModal",
        data() {
            return {
                itemUser: {...this.item}
            }
        },
        props: {
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