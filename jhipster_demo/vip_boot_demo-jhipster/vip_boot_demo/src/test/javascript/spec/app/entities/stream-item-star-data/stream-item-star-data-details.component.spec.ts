/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import StreamItemStarDataDetailComponent from '@/entities/stream-item-star-data/stream-item-star-data-details.vue';
import StreamItemStarDataClass from '@/entities/stream-item-star-data/stream-item-star-data-details.component';
import StreamItemStarDataService from '@/entities/stream-item-star-data/stream-item-star-data.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('StreamItemStarData Management Detail Component', () => {
    let wrapper: Wrapper<StreamItemStarDataClass>;
    let comp: StreamItemStarDataClass;
    let streamItemStarDataServiceStub: SinonStubbedInstance<StreamItemStarDataService>;

    beforeEach(() => {
      streamItemStarDataServiceStub = sinon.createStubInstance<StreamItemStarDataService>(StreamItemStarDataService);

      wrapper = shallowMount<StreamItemStarDataClass>(StreamItemStarDataDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { streamItemStarDataService: () => streamItemStarDataServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundStreamItemStarData = { id: 123 };
        streamItemStarDataServiceStub.find.resolves(foundStreamItemStarData);

        // WHEN
        comp.retrieveStreamItemStarData(123);
        await comp.$nextTick();

        // THEN
        expect(comp.streamItemStarData).toBe(foundStreamItemStarData);
      });
    });
  });
});
