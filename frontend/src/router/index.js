import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '@/views/IndexPage.vue'
import Cities from '@/views/CityListPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/index',
    component: Index
  },
  {
    path: '/index',
    meta: {title: 'Start page'},
    component: Index
  },
  {
    path: '/cities',
    meta: {title: 'Cities'},
    component: Cities
  },

  {
    path: '/about',
    meta: {title: 'About'},
    component: () => import('@/views/AboutPage.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

router.beforeEach((to, from, next) => {
  document.title = to.meta.title
  next()
});

export default router
