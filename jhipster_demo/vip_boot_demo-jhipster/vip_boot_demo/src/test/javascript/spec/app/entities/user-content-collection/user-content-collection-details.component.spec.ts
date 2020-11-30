/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import UserContentCollectionDetailComponent from '@/entities/user-content-collection/user-content-collection-details.vue';
import UserContentCollectionClass from '@/entities/user-content-collection/user-content-collection-details.component';
import UserContentCollectionService from '@/entities/user-content-collection/user-content-collection.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('UserContentCollection Management Detail Component', () => {
    let wrapper: Wrapper<UserContentCollectionClass>;
    let comp: UserContentCollectionClass;
    let userContentCollectionServiceStub: SinonStubbedInstance<UserContentCollectionService>;

    beforeEach(() => {
      userContentCollectionServiceStub = sinon.createStubInstance<UserContentCollectionService>(UserContentCollectionService);

      wrapper = shallowMount<UserContentCollectionClass>(UserContentCollectionDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { userContentCollectionService: () => userContentCollectionServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundUserContentCollection = { id: 123 };
        userContentCollectionServiceStub.find.resolves(foundUserContentCollection);

        // WHEN
        comp.retrieveUserContentCollection(123);
        await comp.$nextTick();

        // THEN
        expect(comp.userContentCollection).toBe(foundUserContentCollection);
      });
    });
  });
});
