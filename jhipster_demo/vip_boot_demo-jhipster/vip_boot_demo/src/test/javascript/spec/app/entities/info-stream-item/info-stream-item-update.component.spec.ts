/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import format from 'date-fns/format';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import InfoStreamItemUpdateComponent from '@/entities/info-stream-item/info-stream-item-update.vue';
import InfoStreamItemClass from '@/entities/info-stream-item/info-stream-item-update.component';
import InfoStreamItemService from '@/entities/info-stream-item/info-stream-item.service';

import ResourceItemService from '@/entities/resource-item/resource-item.service';

import RelativeGoodsItemService from '@/entities/relative-goods-item/relative-goods-item.service';

import AuthorService from '@/entities/author/author.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('InfoStreamItem Management Update Component', () => {
    let wrapper: Wrapper<InfoStreamItemClass>;
    let comp: InfoStreamItemClass;
    let infoStreamItemServiceStub: SinonStubbedInstance<InfoStreamItemService>;

    beforeEach(() => {
      infoStreamItemServiceStub = sinon.createStubInstance<InfoStreamItemService>(InfoStreamItemService);

      wrapper = shallowMount<InfoStreamItemClass>(InfoStreamItemUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          infoStreamItemService: () => infoStreamItemServiceStub,

          resourceItemService: () => new ResourceItemService(),

          relativeGoodsItemService: () => new RelativeGoodsItemService(),

          authorService: () => new AuthorService()
        }
      });
      comp = wrapper.vm;
    });

    describe('load', () => {
      it('Should convert date from string', () => {
        // GIVEN
        const date = new Date('2019-10-15T11:42:02Z');

        // WHEN
        const convertedDate = comp.convertDateTimeFromServer(date);

        // THEN
        expect(convertedDate).toEqual(format(date, DATE_TIME_LONG_FORMAT));
      });

      it('Should not convert date if date is not present', () => {
        expect(comp.convertDateTimeFromServer(null)).toBeNull();
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.infoStreamItem = entity;
        infoStreamItemServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(infoStreamItemServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.infoStreamItem = entity;
        infoStreamItemServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(infoStreamItemServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
