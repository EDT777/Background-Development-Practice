/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import AuthorFavourDataComponent from '@/entities/author-favour-data/author-favour-data.vue';
import AuthorFavourDataClass from '@/entities/author-favour-data/author-favour-data.component';
import AuthorFavourDataService from '@/entities/author-favour-data/author-favour-data.service';

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
  describe('AuthorFavourData Management Component', () => {
    let wrapper: Wrapper<AuthorFavourDataClass>;
    let comp: AuthorFavourDataClass;
    let authorFavourDataServiceStub: SinonStubbedInstance<AuthorFavourDataService>;

    beforeEach(() => {
      authorFavourDataServiceStub = sinon.createStubInstance<AuthorFavourDataService>(AuthorFavourDataService);
      authorFavourDataServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<AuthorFavourDataClass>(AuthorFavourDataComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          authorFavourDataService: () => authorFavourDataServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      authorFavourDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllAuthorFavourDatas();
      await comp.$nextTick();

      // THEN
      expect(authorFavourDataServiceStub.retrieve.called).toBeTruthy();
      expect(comp.authorFavourData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      authorFavourDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(authorFavourDataServiceStub.retrieve.called).toBeTruthy();
      expect(comp.authorFavourData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      authorFavourDataServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(authorFavourDataServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      authorFavourDataServiceStub.retrieve.reset();
      authorFavourDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(authorFavourDataServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.authorFavourData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
      authorFavourDataServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeAuthorFavourData();
      await comp.$nextTick();

      // THEN
      expect(authorFavourDataServiceStub.delete.called).toBeTruthy();
      expect(authorFavourDataServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
