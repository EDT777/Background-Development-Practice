/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import InfoItemVisitDataDetailComponent from '@/entities/info-item-visit-data/info-item-visit-data-details.vue';
import InfoItemVisitDataClass from '@/entities/info-item-visit-data/info-item-visit-data-details.component';
import InfoItemVisitDataService from '@/entities/info-item-visit-data/info-item-visit-data.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('InfoItemVisitData Management Detail Component', () => {
    let wrapper: Wrapper<InfoItemVisitDataClass>;
    let comp: InfoItemVisitDataClass;
    let infoItemVisitDataServiceStub: SinonStubbedInstance<InfoItemVisitDataService>;

    beforeEach(() => {
      infoItemVisitDataServiceStub = sinon.createStubInstance<InfoItemVisitDataService>(InfoItemVisitDataService);

      wrapper = shallowMount<InfoItemVisitDataClass>(InfoItemVisitDataDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { infoItemVisitDataService: () => infoItemVisitDataServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundInfoItemVisitData = { id: 123 };
        infoItemVisitDataServiceStub.find.resolves(foundInfoItemVisitData);

        // WHEN
        comp.retrieveInfoItemVisitData(123);
        await comp.$nextTick();

        // THEN
        expect(comp.infoItemVisitData).toBe(foundInfoItemVisitData);
      });
    });
  });
});
