/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import ReplyVisitDataStatUpdateComponent from '@/entities/reply-visit-data-stat/reply-visit-data-stat-update.vue';
import ReplyVisitDataStatClass from '@/entities/reply-visit-data-stat/reply-visit-data-stat-update.component';
import ReplyVisitDataStatService from '@/entities/reply-visit-data-stat/reply-visit-data-stat.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('ReplyVisitDataStat Management Update Component', () => {
    let wrapper: Wrapper<ReplyVisitDataStatClass>;
    let comp: ReplyVisitDataStatClass;
    let replyVisitDataStatServiceStub: SinonStubbedInstance<ReplyVisitDataStatService>;

    beforeEach(() => {
      replyVisitDataStatServiceStub = sinon.createStubInstance<ReplyVisitDataStatService>(ReplyVisitDataStatService);

      wrapper = shallowMount<ReplyVisitDataStatClass>(ReplyVisitDataStatUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          replyVisitDataStatService: () => replyVisitDataStatServiceStub
        }
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.replyVisitDataStat = entity;
        replyVisitDataStatServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(replyVisitDataStatServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.replyVisitDataStat = entity;
        replyVisitDataStatServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(replyVisitDataStatServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
