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

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import xiangmu from '@/views/modules/xiangmu/list'
    import xiangmuCollection from '@/views/modules/xiangmuCollection/list'
    import xiangmuCommentback from '@/views/modules/xiangmuCommentback/list'
    import xiangmuOrder from '@/views/modules/xiangmuOrder/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yuangong from '@/views/modules/yuangong/list'
    import config from '@/views/modules/config/list'
    import dictionaryCheliang from '@/views/modules/dictionaryCheliang/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryXiangmu from '@/views/modules/dictionaryXiangmu/list'
    import dictionaryXiangmuCollection from '@/views/modules/dictionaryXiangmuCollection/list'
    import dictionaryXiangmuOrder from '@/views/modules/dictionaryXiangmuOrder/list'
    import dictionaryXiangmuOrderPayment from '@/views/modules/dictionaryXiangmuOrderPayment/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
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
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryCheliang',
        name: '车辆类型',
        component: dictionaryCheliang
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryXiangmu',
        name: '项目类型',
        component: dictionaryXiangmu
    }
    ,{
        path: '/dictionaryXiangmuCollection',
        name: '收藏表类型',
        component: dictionaryXiangmuCollection
    }
    ,{
        path: '/dictionaryXiangmuOrder',
        name: '订单类型',
        component: dictionaryXiangmuOrder
    }
    ,{
        path: '/dictionaryXiangmuOrderPayment',
        name: '订单支付类型',
        component: dictionaryXiangmuOrderPayment
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/xiangmu',
        name: '项目',
        component: xiangmu
      }
    ,{
        path: '/xiangmuCollection',
        name: '项目收藏',
        component: xiangmuCollection
      }
    ,{
        path: '/xiangmuCommentback',
        name: '项目评价',
        component: xiangmuCommentback
      }
    ,{
        path: '/xiangmuOrder',
        name: '项目预约订单',
        component: xiangmuOrder
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
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
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
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

export default router;
