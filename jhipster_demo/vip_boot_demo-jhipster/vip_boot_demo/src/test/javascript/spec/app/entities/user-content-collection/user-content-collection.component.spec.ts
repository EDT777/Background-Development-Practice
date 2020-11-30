/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import UserContentCollectionComponent from '@/entities/user-content-collection/user-content-collection.vue';
import UserContentCollectionClass from '@/entities/user-content-collection/user-content-collection.component';
import UserContentCollectionService from '@/entities/user-content-collection/user-content-collection.service';

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
  describe('UserContentCollection Management Component', () => {
    let wrapper: Wrapper<UserContentCollectionClass>;
    let comp: UserContentCollectionClass;
    let userContentCollectionServiceStub: SinonStubbedInstance<UserContentCollectionService>;

    beforeEach(() => {
      userContentCollectionServiceStub = sinon.createStubInstance<UserContentCollectionService>(UserContentCollectionService);
      userContentCollectionServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<UserContentCollectionClass>(UserContentCollectionComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          userContentCollectionService: () => userContentCollectionServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      userContentCollectionServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllUserContentCollections();
      await comp.$nextTick();

      // THEN
      expect(userContentCollectionServiceStub.retrieve.called).toBeTruthy();
      expect(comp.userContentCollections[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      userContentCollectionServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(userContentCollectionServiceStub.retrieve.called).toBeTruthy();
      expect(comp.userContentCollections[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      userContentCollectionServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(userContentCollectionServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      userContentCollectionServiceStub.retrieve.reset();
      userContentCollectionServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(userContentCollectionServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.userContentCollections[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
      userContentCollectionServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeUserContentCollection();
      await comp.$nextTick();

      // THEN
      expect(userContentCollectionServiceStub.delete.called).toBeTruthy();
      expect(userContentCollectionServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
