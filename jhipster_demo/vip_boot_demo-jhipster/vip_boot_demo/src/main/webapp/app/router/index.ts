import Vue from 'vue';
import Component from 'vue-class-component';
Component.registerHooks([
  'beforeRouteEnter',
  'beforeRouteLeave',
  'beforeRouteUpdate' // for vue-router 2.2+
]);
import Router from 'vue-router';
import { Authority } from '@/shared/security/authority';
const Home = () => import('../core/home/home.vue');
const Error = () => import('../core/error/error.vue');
const Register = () => import('../account/register/register.vue');
const Activate = () => import('../account/activate/activate.vue');
const ResetPasswordInit = () => import('../account/reset-password/init/reset-password-init.vue');
const ResetPasswordFinish = () => import('../account/reset-password/finish/reset-password-finish.vue');
const ChangePassword = () => import('../account/change-password/change-password.vue');
const Settings = () => import('../account/settings/settings.vue');
const JhiUserManagementComponent = () => import('../admin/user-management/user-management.vue');
const JhiUserManagementViewComponent = () => import('../admin/user-management/user-management-view.vue');
const JhiUserManagementEditComponent = () => import('../admin/user-management/user-management-edit.vue');
const Sessions = () => import('../account/sessions/sessions.vue');
const JhiConfigurationComponent = () => import('../admin/configuration/configuration.vue');
const JhiDocsComponent = () => import('../admin/docs/docs.vue');
const JhiHealthComponent = () => import('../admin/health/health.vue');
const JhiLogsComponent = () => import('../admin/logs/logs.vue');
const JhiAuditsComponent = () => import('../admin/audits/audits.vue');
const JhiMetricsComponent = () => import('../admin/metrics/metrics.vue');
/* tslint:disable */
// prettier-ignore
const InfoStreamItem = () => import('../entities/info-stream-item/info-stream-item.vue');
// prettier-ignore
const InfoStreamItemUpdate = () => import('../entities/info-stream-item/info-stream-item-update.vue');
// prettier-ignore
const InfoStreamItemDetails = () => import('../entities/info-stream-item/info-stream-item-details.vue');
// prettier-ignore
const RelativeGoodsItem = () => import('../entities/relative-goods-item/relative-goods-item.vue');
// prettier-ignore
const RelativeGoodsItemUpdate = () => import('../entities/relative-goods-item/relative-goods-item-update.vue');
// prettier-ignore
const RelativeGoodsItemDetails = () => import('../entities/relative-goods-item/relative-goods-item-details.vue');
// prettier-ignore
const Reply = () => import('../entities/reply/reply.vue');
// prettier-ignore
const ReplyUpdate = () => import('../entities/reply/reply-update.vue');
// prettier-ignore
const ReplyDetails = () => import('../entities/reply/reply-details.vue');
// prettier-ignore
const Author = () => import('../entities/author/author.vue');
// prettier-ignore
const AuthorUpdate = () => import('../entities/author/author-update.vue');
// prettier-ignore
const AuthorDetails = () => import('../entities/author/author-details.vue');
// prettier-ignore
const ResourceItem = () => import('../entities/resource-item/resource-item.vue');
// prettier-ignore
const ResourceItemUpdate = () => import('../entities/resource-item/resource-item-update.vue');
// prettier-ignore
const ResourceItemDetails = () => import('../entities/resource-item/resource-item-details.vue');
// prettier-ignore
const InfoItemVisitData = () => import('../entities/info-item-visit-data/info-item-visit-data.vue');
// prettier-ignore
const InfoItemVisitDataUpdate = () => import('../entities/info-item-visit-data/info-item-visit-data-update.vue');
// prettier-ignore
const InfoItemVisitDataDetails = () => import('../entities/info-item-visit-data/info-item-visit-data-details.vue');
// prettier-ignore
const InfoItemVisitDataStat = () => import('../entities/info-item-visit-data-stat/info-item-visit-data-stat.vue');
// prettier-ignore
const InfoItemVisitDataStatUpdate = () => import('../entities/info-item-visit-data-stat/info-item-visit-data-stat-update.vue');
// prettier-ignore
const InfoItemVisitDataStatDetails = () => import('../entities/info-item-visit-data-stat/info-item-visit-data-stat-details.vue');
// prettier-ignore
const ReplyVisitDataStat = () => import('../entities/reply-visit-data-stat/reply-visit-data-stat.vue');
// prettier-ignore
const ReplyVisitDataStatUpdate = () => import('../entities/reply-visit-data-stat/reply-visit-data-stat-update.vue');
// prettier-ignore
const ReplyVisitDataStatDetails = () => import('../entities/reply-visit-data-stat/reply-visit-data-stat-details.vue');
// prettier-ignore
const AuthorFavourData = () => import('../entities/author-favour-data/author-favour-data.vue');
// prettier-ignore
const AuthorFavourDataUpdate = () => import('../entities/author-favour-data/author-favour-data-update.vue');
// prettier-ignore
const AuthorFavourDataDetails = () => import('../entities/author-favour-data/author-favour-data-details.vue');
// prettier-ignore
const StreamItemStarData = () => import('../entities/stream-item-star-data/stream-item-star-data.vue');
// prettier-ignore
const StreamItemStarDataUpdate = () => import('../entities/stream-item-star-data/stream-item-star-data-update.vue');
// prettier-ignore
const StreamItemStarDataDetails = () => import('../entities/stream-item-star-data/stream-item-star-data-details.vue');
// prettier-ignore
const UserContentCollection = () => import('../entities/user-content-collection/user-content-collection.vue');
// prettier-ignore
const UserContentCollectionUpdate = () => import('../entities/user-content-collection/user-content-collection-update.vue');
// prettier-ignore
const UserContentCollectionDetails = () => import('../entities/user-content-collection/user-content-collection-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

Vue.use(Router);

// prettier-ignore
export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/forbidden',
      name: 'Forbidden',
      component: Error,
      meta: { error403: true }
    },
    {
      path: '/not-found',
      name: 'NotFound',
      component: Error,
      meta: { error404: true }
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/account/activate',
      name: 'Activate',
      component: Activate
    },
    {
      path: '/account/reset/request',
      name: 'ResetPasswordInit',
      component: ResetPasswordInit
    },
    {
      path: '/account/reset/finish',
      name: 'ResetPasswordFinish',
      component: ResetPasswordFinish
    },
    {
      path: '/account/password',
      name: 'ChangePassword',
      component: ChangePassword,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/account/sessions',
      name: 'Sessions',
      component: Sessions,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/account/settings',
      name: 'Settings',
      component: Settings,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/admin/user-management',
      name: 'JhiUser',
      component: JhiUserManagementComponent,
      meta: { authorities: [Authority.ADMIN] }
    },
    {
      path: '/admin/user-management/new',
      name: 'JhiUserCreate',
      component: JhiUserManagementEditComponent,
      meta: { authorities: [Authority.ADMIN] }
    },
    {
      path: '/admin/user-management/:userId/edit',
      name: 'JhiUserEdit',
      component: JhiUserManagementEditComponent,
      meta: { authorities: [Authority.ADMIN] }
    },
    {
      path: '/admin/user-management/:userId/view',
      name: 'JhiUserView',
      component: JhiUserManagementViewComponent,
      meta: { authorities: [Authority.ADMIN] }
    },
    {
      path: '/admin/docs',
      name: 'JhiDocsComponent',
      component: JhiDocsComponent,
      meta: { authorities: [Authority.ADMIN] }
    },
    {
      path: '/admin/audits',
      name: 'JhiAuditsComponent',
      component: JhiAuditsComponent,
      meta: { authorities: [Authority.ADMIN] }
    },
    {
      path: '/admin/jhi-health',
      name: 'JhiHealthComponent',
      component: JhiHealthComponent,
      meta: { authorities: [Authority.ADMIN] }
    },
    {
      path: '/admin/logs',
      name: 'JhiLogsComponent',
      component: JhiLogsComponent,
      meta: { authorities: [Authority.ADMIN] }
    },
    {
      path: '/admin/jhi-metrics',
      name: 'JhiMetricsComponent',
      component: JhiMetricsComponent,
      meta: { authorities: [Authority.ADMIN] }
    },
    {
      path: '/admin/jhi-configuration',
      name: 'JhiConfigurationComponent',
      component: JhiConfigurationComponent,
      meta: { authorities: [Authority.ADMIN] }
    }
    ,
    {
      path: '/info-stream-item',
      name: 'InfoStreamItem',
      component: InfoStreamItem,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/info-stream-item/new',
      name: 'InfoStreamItemCreate',
      component: InfoStreamItemUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/info-stream-item/:infoStreamItemId/edit',
      name: 'InfoStreamItemEdit',
      component: InfoStreamItemUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/info-stream-item/:infoStreamItemId/view',
      name: 'InfoStreamItemView',
      component: InfoStreamItemDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/relative-goods-item',
      name: 'RelativeGoodsItem',
      component: RelativeGoodsItem,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/relative-goods-item/new',
      name: 'RelativeGoodsItemCreate',
      component: RelativeGoodsItemUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/relative-goods-item/:relativeGoodsItemId/edit',
      name: 'RelativeGoodsItemEdit',
      component: RelativeGoodsItemUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/relative-goods-item/:relativeGoodsItemId/view',
      name: 'RelativeGoodsItemView',
      component: RelativeGoodsItemDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/reply',
      name: 'Reply',
      component: Reply,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/reply/new',
      name: 'ReplyCreate',
      component: ReplyUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/reply/:replyId/edit',
      name: 'ReplyEdit',
      component: ReplyUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/reply/:replyId/view',
      name: 'ReplyView',
      component: ReplyDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/author',
      name: 'Author',
      component: Author,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/author/new',
      name: 'AuthorCreate',
      component: AuthorUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/author/:authorId/edit',
      name: 'AuthorEdit',
      component: AuthorUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/author/:authorId/view',
      name: 'AuthorView',
      component: AuthorDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/resource-item',
      name: 'ResourceItem',
      component: ResourceItem,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/resource-item/new',
      name: 'ResourceItemCreate',
      component: ResourceItemUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/resource-item/:resourceItemId/edit',
      name: 'ResourceItemEdit',
      component: ResourceItemUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/resource-item/:resourceItemId/view',
      name: 'ResourceItemView',
      component: ResourceItemDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/info-item-visit-data',
      name: 'InfoItemVisitData',
      component: InfoItemVisitData,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/info-item-visit-data/new',
      name: 'InfoItemVisitDataCreate',
      component: InfoItemVisitDataUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/info-item-visit-data/:infoItemVisitDataId/edit',
      name: 'InfoItemVisitDataEdit',
      component: InfoItemVisitDataUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/info-item-visit-data/:infoItemVisitDataId/view',
      name: 'InfoItemVisitDataView',
      component: InfoItemVisitDataDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/info-item-visit-data-stat',
      name: 'InfoItemVisitDataStat',
      component: InfoItemVisitDataStat,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/info-item-visit-data-stat/new',
      name: 'InfoItemVisitDataStatCreate',
      component: InfoItemVisitDataStatUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/info-item-visit-data-stat/:infoItemVisitDataStatId/edit',
      name: 'InfoItemVisitDataStatEdit',
      component: InfoItemVisitDataStatUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/info-item-visit-data-stat/:infoItemVisitDataStatId/view',
      name: 'InfoItemVisitDataStatView',
      component: InfoItemVisitDataStatDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/reply-visit-data-stat',
      name: 'ReplyVisitDataStat',
      component: ReplyVisitDataStat,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/reply-visit-data-stat/new',
      name: 'ReplyVisitDataStatCreate',
      component: ReplyVisitDataStatUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/reply-visit-data-stat/:replyVisitDataStatId/edit',
      name: 'ReplyVisitDataStatEdit',
      component: ReplyVisitDataStatUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/reply-visit-data-stat/:replyVisitDataStatId/view',
      name: 'ReplyVisitDataStatView',
      component: ReplyVisitDataStatDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/author-favour-data',
      name: 'AuthorFavourData',
      component: AuthorFavourData,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/author-favour-data/new',
      name: 'AuthorFavourDataCreate',
      component: AuthorFavourDataUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/author-favour-data/:authorFavourDataId/edit',
      name: 'AuthorFavourDataEdit',
      component: AuthorFavourDataUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/author-favour-data/:authorFavourDataId/view',
      name: 'AuthorFavourDataView',
      component: AuthorFavourDataDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/stream-item-star-data',
      name: 'StreamItemStarData',
      component: StreamItemStarData,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/stream-item-star-data/new',
      name: 'StreamItemStarDataCreate',
      component: StreamItemStarDataUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/stream-item-star-data/:streamItemStarDataId/edit',
      name: 'StreamItemStarDataEdit',
      component: StreamItemStarDataUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/stream-item-star-data/:streamItemStarDataId/view',
      name: 'StreamItemStarDataView',
      component: StreamItemStarDataDetails,
      meta: { authorities: [Authority.USER] }
    }
    ,
    {
      path: '/user-content-collection',
      name: 'UserContentCollection',
      component: UserContentCollection,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/user-content-collection/new',
      name: 'UserContentCollectionCreate',
      component: UserContentCollectionUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/user-content-collection/:userContentCollectionId/edit',
      name: 'UserContentCollectionEdit',
      component: UserContentCollectionUpdate,
      meta: { authorities: [Authority.USER] }
    },
    {
      path: '/user-content-collection/:userContentCollectionId/view',
      name: 'UserContentCollectionView',
      component: UserContentCollectionDetails,
      meta: { authorities: [Authority.USER] }
    }
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ]
});
