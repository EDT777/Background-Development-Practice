/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import InfoStreamItemDetailComponent from '@/entities/info-stream-item/info-stream-item-details.vue';
import InfoStreamItemClass from '@/entities/info-stream-item/info-stream-item-details.component';
import InfoStreamItemService from '@/entities/info-stream-item/info-stream-item.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('InfoStreamItem Management Detail Component', () => {
    let wrapper: Wrapper<InfoStreamItemClass>;
    let comp: InfoStreamItemClass;
    let infoStreamItemServiceStub: SinonStubbedInstance<InfoStreamItemService>;

    beforeEach(() => {
      infoStreamItemServiceStub = sinon.createStubInstance<InfoStreamItemService>(InfoStreamItemService);

      wrapper = shallowMount<InfoStreamItemClass>(InfoStreamItemDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { infoStreamItemService: () => infoStreamItemServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundInfoStreamItem = { id: 123 };
        infoStreamItemServiceStub.find.resolves(foundInfoStreamItem);

        // WHEN
        comp.retrieveInfoStreamItem(123);
        await comp.$nextTick();

        // THEN
        expect(comp.infoStreamItem).toBe(foundInfoStreamItem);
      });
    });
  });
});
