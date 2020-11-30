/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import StreamItemStarDataComponent from '@/entities/stream-item-star-data/stream-item-star-data.vue';
import StreamItemStarDataClass from '@/entities/stream-item-star-data/stream-item-star-data.component';
import StreamItemStarDataService from '@/entities/stream-item-star-data/stream-item-star-data.service';

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
  describe('StreamItemStarData Management Component', () => {
    let wrapper: Wrapper<StreamItemStarDataClass>;
    let comp: StreamItemStarDataClass;
    let streamItemStarDataServiceStub: SinonStubbedInstance<StreamItemStarDataService>;

    beforeEach(() => {
      streamItemStarDataServiceStub = sinon.createStubInstance<StreamItemStarDataService>(StreamItemStarDataService);
      streamItemStarDataServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<StreamItemStarDataClass>(StreamItemStarDataComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          streamItemStarDataService: () => streamItemStarDataServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      streamItemStarDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllStreamItemStarDatas();
      await comp.$nextTick();

      // THEN
      expect(streamItemStarDataServiceStub.retrieve.called).toBeTruthy();
      expect(comp.streamItemStarData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      streamItemStarDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(streamItemStarDataServiceStub.retrieve.called).toBeTruthy();
      expect(comp.streamItemStarData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      streamItemStarDataServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(streamItemStarDataServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      streamItemStarDataServiceStub.retrieve.reset();
      streamItemStarDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(streamItemStarDataServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.streamItemStarData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
      streamItemStarDataServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeStreamItemStarData();
      await comp.$nextTick();

      // THEN
      expect(streamItemStarDataServiceStub.delete.called).toBeTruthy();
      expect(streamItemStarDataServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
