/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import RelativeGoodsItemUpdateComponent from '@/entities/relative-goods-item/relative-goods-item-update.vue';
import RelativeGoodsItemClass from '@/entities/relative-goods-item/relative-goods-item-update.component';
import RelativeGoodsItemService from '@/entities/relative-goods-item/relative-goods-item.service';

import InfoStreamItemService from '@/entities/info-stream-item/info-stream-item.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('RelativeGoodsItem Management Update Component', () => {
    let wrapper: Wrapper<RelativeGoodsItemClass>;
    let comp: RelativeGoodsItemClass;
    let relativeGoodsItemServiceStub: SinonStubbedInstance<RelativeGoodsItemService>;

    beforeEach(() => {
      relativeGoodsItemServiceStub = sinon.createStubInstance<RelativeGoodsItemService>(RelativeGoodsItemService);

      wrapper = shallowMount<RelativeGoodsItemClass>(RelativeGoodsItemUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          relativeGoodsItemService: () => relativeGoodsItemServiceStub,

          infoStreamItemService: () => new InfoStreamItemService()
        }
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.relativeGoodsItem = entity;
        relativeGoodsItemServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(relativeGoodsItemServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.relativeGoodsItem = entity;
        relativeGoodsItemServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(relativeGoodsItemServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
