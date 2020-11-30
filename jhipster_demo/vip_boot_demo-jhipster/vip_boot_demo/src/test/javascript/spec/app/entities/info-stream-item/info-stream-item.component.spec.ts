/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import InfoStreamItemComponent from '@/entities/info-stream-item/info-stream-item.vue';
import InfoStreamItemClass from '@/entities/info-stream-item/info-stream-item.component';
import InfoStreamItemService from '@/entities/info-stream-item/info-stream-item.service';

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
  describe('InfoStreamItem Management Component', () => {
    let wrapper: Wrapper<InfoStreamItemClass>;
    let comp: InfoStreamItemClass;
    let infoStreamItemServiceStub: SinonStubbedInstance<InfoStreamItemService>;

    beforeEach(() => {
      infoStreamItemServiceStub = sinon.createStubInstance<InfoStreamItemService>(InfoStreamItemService);
      infoStreamItemServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<InfoStreamItemClass>(InfoStreamItemComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          infoStreamItemService: () => infoStreamItemServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      infoStreamItemServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllInfoStreamItems();
      await comp.$nextTick();

      // THEN
      expect(infoStreamItemServiceStub.retrieve.called).toBeTruthy();
      expect(comp.infoStreamItems[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      infoStreamItemServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(infoStreamItemServiceStub.retrieve.called).toBeTruthy();
      expect(comp.infoStreamItems[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      infoStreamItemServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(infoStreamItemServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      infoStreamItemServiceStub.retrieve.reset();
      infoStreamItemServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(infoStreamItemServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.infoStreamItems[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
      infoStreamItemServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeInfoStreamItem();
      await comp.$nextTick();

      // THEN
      expect(infoStreamItemServiceStub.delete.called).toBeTruthy();
      expect(infoStreamItemServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
