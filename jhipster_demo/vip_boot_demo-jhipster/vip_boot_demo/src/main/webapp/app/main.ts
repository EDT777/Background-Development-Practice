// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.common with an alias.
import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import App from './app.vue';
import Vue2Filters from 'vue2-filters';
import router from './router';
import * as config from './shared/config/config';
import * as bootstrapVueConfig from './shared/config/config-bootstrap-vue';
import JhiItemCountComponent from './shared/jhi-item-count.vue';
import JhiSortIndicatorComponent from './shared/sort/jhi-sort-indicator.vue';
import InfiniteLoading from 'vue-infinite-loading';
import AuditsService from './admin/audits/audits.service';

import HealthService from './admin/health/health.service';
import MetricsService from './admin/metrics/metrics.service';
import LogsService from './admin/logs/logs.service';
import ActivateService from './account/activate/activate.service';
import RegisterService from './account/register/register.service';
import UserManagementService from '@/admin/user-management/user-management.service';

import LoginService from './account/login.service';
import AccountService from './account/account.service';

import '../content/scss/vendor.scss';
import AlertService from '@/shared/alert/alert.service';
import TranslationService from '@/locale/translation.service';
import ConfigurationService from '@/admin/configuration/configuration.service';

/* tslint:disable */

import InfoStreamItemService from '@/entities/info-stream-item/info-stream-item.service';
import RelativeGoodsItemService from '@/entities/relative-goods-item/relative-goods-item.service';
import ReplyService from '@/entities/reply/reply.service';
import AuthorService from '@/entities/author/author.service';
import ResourceItemService from '@/entities/resource-item/resource-item.service';
import InfoItemVisitDataService from '@/entities/info-item-visit-data/info-item-visit-data.service';
import InfoItemVisitDataStatService from '@/entities/info-item-visit-data-stat/info-item-visit-data-stat.service';
import ReplyVisitDataStatService from '@/entities/reply-visit-data-stat/reply-visit-data-stat.service';
import AuthorFavourDataService from '@/entities/author-favour-data/author-favour-data.service';
import StreamItemStarDataService from '@/entities/stream-item-star-data/stream-item-star-data.service';
import UserContentCollectionService from '@/entities/user-content-collection/user-content-collection.service';
// jhipster-needle-add-entity-service-to-main-import - JHipster will import entities services here

/* tslint:enable */
Vue.config.productionTip = false;
config.initVueApp(Vue);
config.initFortAwesome(Vue);
bootstrapVueConfig.initBootstrapVue(Vue);
Vue.use(Vue2Filters);
Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.component('jhi-item-count', JhiItemCountComponent);
Vue.component('jhi-sort-indicator', JhiSortIndicatorComponent);
Vue.component('infinite-loading', InfiniteLoading);

const i18n = config.initI18N(Vue);
const store = config.initVueXStore(Vue);

const alertService = new AlertService(store);
const translationService = new TranslationService(store, i18n);
const loginService = new LoginService();
const accountService = new AccountService(store, translationService, (<any>Vue).cookie, router);

router.beforeEach((to, from, next) => {
  if (!to.matched.length) {
    next('/not-found');
  }

  if (to.meta && to.meta.authorities && to.meta.authorities.length > 0) {
    if (!accountService.hasAnyAuthority(to.meta.authorities)) {
      sessionStorage.setItem('requested-url', to.fullPath);
      next('/forbidden');
    } else {
      next();
    }
  } else {
    // no authorities, so just proceed
    next();
  }
});

/* tslint:disable */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>',
  router,
  provide: {
    loginService: () => loginService,
    activateService: () => new ActivateService(),
    registerService: () => new RegisterService(),
    userService: () => new UserManagementService(),

    auditsService: () => new AuditsService(),

    healthService: () => new HealthService(),

    configurationService: () => new ConfigurationService(),
    logsService: () => new LogsService(),
    metricsService: () => new MetricsService(),
    alertService: () => alertService,
    translationService: () => translationService,
    infoStreamItemService: () => new InfoStreamItemService(),
    relativeGoodsItemService: () => new RelativeGoodsItemService(),
    replyService: () => new ReplyService(),
    authorService: () => new AuthorService(),
    resourceItemService: () => new ResourceItemService(),
    infoItemVisitDataService: () => new InfoItemVisitDataService(),
    infoItemVisitDataStatService: () => new InfoItemVisitDataStatService(),
    replyVisitDataStatService: () => new ReplyVisitDataStatService(),
    authorFavourDataService: () => new AuthorFavourDataService(),
    streamItemStarDataService: () => new StreamItemStarDataService(),
    userContentCollectionService: () => new UserContentCollectionService(),
    // jhipster-needle-add-entity-service-to-main - JHipster will import entities services here
    accountService: () => accountService
  },
  i18n,
  store
});
