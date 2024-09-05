import { createRouter, createWebHashHistory } from 'vue-router'

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login/LoginPage.vue')
    },
    {
      path: '/',
      component: () => import('@/views/layout/LayoutContainer.vue'),
      redirect: '/home',
      children: [
        {
          path: '/home',
          name: 'Home',
          component: () => import('@/views/home/HomePage.vue')
        },
        {
          path: '/department',
          name: 'Department',
          component: () => import('@/views/department/DepartmentManage.vue')
        },
        {
          path: '/employee',
          name: 'Employee',
          component: () => import('@/views/employee/EmployeeManage.vue')
        }
      ]
    },
    {
      path: '/:pathMatch(.*)*',
      name: 'NotFound',
      component: () => import('@/views/layout/NotFoundPage.vue')
    }
  ]
})

export default router
