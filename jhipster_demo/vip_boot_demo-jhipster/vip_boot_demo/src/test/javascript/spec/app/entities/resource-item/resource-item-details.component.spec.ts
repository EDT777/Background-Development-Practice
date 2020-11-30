/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import ResourceItemDetailComponent from '@/entities/resource-item/resource-item-details.vue';
import ResourceItemClass from '@/entities/resource-item/resource-item-details.component';
import ResourceItemService from '@/entities/resource-item/resource-item.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('ResourceItem Management Detail Component', () => {
    let wrapper: Wrapper<ResourceItemClass>;
    let comp: ResourceItemClass;
    let resourceItemServiceStub: SinonStubbedInstance<ResourceItemService>;

    beforeEach(() => {
      resourceItemServiceStub = sinon.createStubInstance<ResourceItemService>(ResourceItemService);

      wrapper = shallowMount<ResourceItemClass>(ResourceItemDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { resourceItemService: () => resourceItemServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundResourceItem = { id: 123 };
        resourceItemServiceStub.find.resolves(foundResourceItem);

        // WHEN
        comp.retrieveResourceItem(123);
        await comp.$nextTick();

        // THEN
        expect(comp.resourceItem).toBe(foundResourceItem);
      });
    });
  });
});
