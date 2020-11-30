/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import RelativeGoodsItemDetailComponent from '@/entities/relative-goods-item/relative-goods-item-details.vue';
import RelativeGoodsItemClass from '@/entities/relative-goods-item/relative-goods-item-details.component';
import RelativeGoodsItemService from '@/entities/relative-goods-item/relative-goods-item.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('RelativeGoodsItem Management Detail Component', () => {
    let wrapper: Wrapper<RelativeGoodsItemClass>;
    let comp: RelativeGoodsItemClass;
    let relativeGoodsItemServiceStub: SinonStubbedInstance<RelativeGoodsItemService>;

    beforeEach(() => {
      relativeGoodsItemServiceStub = sinon.createStubInstance<RelativeGoodsItemService>(RelativeGoodsItemService);

      wrapper = shallowMount<RelativeGoodsItemClass>(RelativeGoodsItemDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { relativeGoodsItemService: () => relativeGoodsItemServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundRelativeGoodsItem = { id: 123 };
        relativeGoodsItemServiceStub.find.resolves(foundRelativeGoodsItem);

        // WHEN
        comp.retrieveRelativeGoodsItem(123);
        await comp.$nextTick();

        // THEN
        expect(comp.relativeGoodsItem).toBe(foundRelativeGoodsItem);
      });
    });
  });
});
