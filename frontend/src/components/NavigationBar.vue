<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="secondary">
            <b-navbar-brand>
                <i class="material-icons">deck</i>
            </b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item href="#">
                        <router-link to="/tms/index">
                            <span class="text-white-50">Стартовая</span>
                        </router-link>
                    </b-nav-item>
                    <b-nav-item href="#">
                        <router-link to="/tms/cities">
                            <span class="text-white-50">Города</span>
                        </router-link>
                    </b-nav-item>
                </b-navbar-nav>

                <b-dropdown text="Меню" right variant="outline-light" class="ml-auto col-xl-1">
                    <b-dropdown-item>
                        <router-link to="/tms/index">
                            Стартовая
                        </router-link>
                    </b-dropdown-item>
                    <b-dropdown-divider></b-dropdown-divider>
                    <b-dropdown-item>
                        <router-link to="/tms/about">
                            About
                        </router-link>
                    </b-dropdown-item>
                </b-dropdown>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>

    export default {
        name: "NavigationBar"
    }
</script>

<style scoped>

</style>