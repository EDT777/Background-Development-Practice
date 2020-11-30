/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import InfoItemVisitDataComponent from '@/entities/info-item-visit-data/info-item-visit-data.vue';
import InfoItemVisitDataClass from '@/entities/info-item-visit-data/info-item-visit-data.component';
import InfoItemVisitDataService from '@/entities/info-item-visit-data/info-item-visit-data.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-alert', {});
localVue.component('b-badge', {});
localVue.component('jhi-sort-indicator', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {}
  }
};

describe('Component Tests', () => {
  describe('InfoItemVisitData Management Component', () => {
    let wrapper: Wrapper<InfoItemVisitDataClass>;
    let comp: InfoItemVisitDataClass;
    let infoItemVisitDataServiceStub: SinonStubbedInstance<InfoItemVisitDataService>;

    beforeEach(() => {
      infoItemVisitDataServiceStub = sinon.createStubInstance<InfoItemVisitDataService>(InfoItemVisitDataService);
      infoItemVisitDataServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<InfoItemVisitDataClass>(InfoItemVisitDataComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          infoItemVisitDataService: () => infoItemVisitDataServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      infoItemVisitDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllInfoItemVisitDatas();
      await comp.$nextTick();

      // THEN
      expect(infoItemVisitDataServiceStub.retrieve.called).toBeTruthy();
      expect(comp.infoItemVisitData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      infoItemVisitDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(infoItemVisitDataServiceStub.retrieve.called).toBeTruthy();
      expect(comp.infoItemVisitData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      infoItemVisitDataServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(infoItemVisitDataServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      infoItemVisitDataServiceStub.retrieve.reset();
      infoItemVisitDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(infoItemVisitDataServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.infoItemVisitData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // GIVEN
      comp.propOrder = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      infoItemVisitDataServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeInfoItemVisitData();
      await comp.$nextTick();

      // THEN
      expect(infoItemVisitDataServiceStub.delete.called).toBeTruthy();
      expect(infoItemVisitDataServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
