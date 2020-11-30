/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import InfoItemVisitDataStatUpdateComponent from '@/entities/info-item-visit-data-stat/info-item-visit-data-stat-update.vue';
import InfoItemVisitDataStatClass from '@/entities/info-item-visit-data-stat/info-item-visit-data-stat-update.component';
import InfoItemVisitDataStatService from '@/entities/info-item-visit-data-stat/info-item-visit-data-stat.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('InfoItemVisitDataStat Management Update Component', () => {
    let wrapper: Wrapper<InfoItemVisitDataStatClass>;
    let comp: InfoItemVisitDataStatClass;
    let infoItemVisitDataStatServiceStub: SinonStubbedInstance<InfoItemVisitDataStatService>;

    beforeEach(() => {
      infoItemVisitDataStatServiceStub = sinon.createStubInstance<InfoItemVisitDataStatService>(InfoItemVisitDataStatService);

      wrapper = shallowMount<InfoItemVisitDataStatClass>(InfoItemVisitDataStatUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          infoItemVisitDataStatService: () => infoItemVisitDataStatServiceStub
        }
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.infoItemVisitDataStat = entity;
        infoItemVisitDataStatServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(infoItemVisitDataStatServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.infoItemVisitDataStat = entity;
        infoItemVisitDataStatServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(infoItemVisitDataStatServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
