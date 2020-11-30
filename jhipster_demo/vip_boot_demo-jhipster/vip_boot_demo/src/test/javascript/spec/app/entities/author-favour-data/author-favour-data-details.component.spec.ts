/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import AuthorFavourDataDetailComponent from '@/entities/author-favour-data/author-favour-data-details.vue';
import AuthorFavourDataClass from '@/entities/author-favour-data/author-favour-data-details.component';
import AuthorFavourDataService from '@/entities/author-favour-data/author-favour-data.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('AuthorFavourData Management Detail Component', () => {
    let wrapper: Wrapper<AuthorFavourDataClass>;
    let comp: AuthorFavourDataClass;
    let authorFavourDataServiceStub: SinonStubbedInstance<AuthorFavourDataService>;

    beforeEach(() => {
      authorFavourDataServiceStub = sinon.createStubInstance<AuthorFavourDataService>(AuthorFavourDataService);

      wrapper = shallowMount<AuthorFavourDataClass>(AuthorFavourDataDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { authorFavourDataService: () => authorFavourDataServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundAuthorFavourData = { id: 123 };
        authorFavourDataServiceStub.find.resolves(foundAuthorFavourData);

        // WHEN
        comp.retrieveAuthorFavourData(123);
        await comp.$nextTick();

        // THEN
        expect(comp.authorFavourData).toBe(foundAuthorFavourData);
      });
    });
  });
});
