import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import siji from '@/views/modules/siji/list'
    import paisongyuan from '@/views/modules/paisongyuan/list'
    import kuaidipeisong from '@/views/modules/kuaidipeisong/list'
    import jijianxinxi from '@/views/modules/jijianxinxi/list'
    import kuaidifenjian from '@/views/modules/kuaidifenjian/list'
    import yonghu from '@/views/modules/yonghu/list'
    import kuaidiyunshu from '@/views/modules/kuaidiyunshu/list'
    import kuaidiluru from '@/views/modules/kuaidiluru/list'
    import cheliangxinxi from '@/views/modules/cheliangxinxi/list'
    import luxianxinxi from '@/views/modules/luxianxinxi/list'
    import diquxinxi from '@/views/modules/diquxinxi/list'
    import kuaidileibie from '@/views/modules/kuaidileibie/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/siji',
        name: '司机',
        component: siji
      }
      ,{
	path: '/paisongyuan',
        name: '派送员',
        component: paisongyuan
      }
      ,{
	path: '/kuaidipeisong',
        name: '快递配送',
        component: kuaidipeisong
      }
      ,{
	path: '/jijianxinxi',
        name: '寄件信息',
        component: jijianxinxi
      }
      ,{
	path: '/kuaidifenjian',
        name: '快递分拣',
        component: kuaidifenjian
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/kuaidiyunshu',
        name: '快递运输',
        component: kuaidiyunshu
      }
      ,{
	path: '/kuaidiluru',
        name: '快递录入',
        component: kuaidiluru
      }
      ,{
	path: '/cheliangxinxi',
        name: '车辆信息',
        component: cheliangxinxi
      }
      ,{
	path: '/luxianxinxi',
        name: '路线信息',
        component: luxianxinxi
      }
      ,{
	path: '/diquxinxi',
        name: '地区信息',
        component: diquxinxi
      }
      ,{
	path: '/kuaidileibie',
        name: '快递类别',
        component: kuaidileibie
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
