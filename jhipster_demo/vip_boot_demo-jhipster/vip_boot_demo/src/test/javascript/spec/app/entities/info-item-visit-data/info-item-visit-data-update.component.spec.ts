/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import InfoItemVisitDataUpdateComponent from '@/entities/info-item-visit-data/info-item-visit-data-update.vue';
import InfoItemVisitDataClass from '@/entities/info-item-visit-data/info-item-visit-data-update.component';
import InfoItemVisitDataService from '@/entities/info-item-visit-data/info-item-visit-data.service';

import InfoStreamItemService from '@/entities/info-stream-item/info-stream-item.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('InfoItemVisitData Management Update Component', () => {
    let wrapper: Wrapper<InfoItemVisitDataClass>;
    let comp: InfoItemVisitDataClass;
    let infoItemVisitDataServiceStub: SinonStubbedInstance<InfoItemVisitDataService>;

    beforeEach(() => {
      infoItemVisitDataServiceStub = sinon.createStubInstance<InfoItemVisitDataService>(InfoItemVisitDataService);

      wrapper = shallowMount<InfoItemVisitDataClass>(InfoItemVisitDataUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          infoItemVisitDataService: () => infoItemVisitDataServiceStub,

          infoStreamItemService: () => new InfoStreamItemService()
        }
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.infoItemVisitData = entity;
        infoItemVisitDataServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(infoItemVisitDataServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.infoItemVisitData = entity;
        infoItemVisitDataServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(infoItemVisitDataServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
