/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import InfoItemVisitDataStatDetailComponent from '@/entities/info-item-visit-data-stat/info-item-visit-data-stat-details.vue';
import InfoItemVisitDataStatClass from '@/entities/info-item-visit-data-stat/info-item-visit-data-stat-details.component';
import InfoItemVisitDataStatService from '@/entities/info-item-visit-data-stat/info-item-visit-data-stat.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('InfoItemVisitDataStat Management Detail Component', () => {
    let wrapper: Wrapper<InfoItemVisitDataStatClass>;
    let comp: InfoItemVisitDataStatClass;
    let infoItemVisitDataStatServiceStub: SinonStubbedInstance<InfoItemVisitDataStatService>;

    beforeEach(() => {
      infoItemVisitDataStatServiceStub = sinon.createStubInstance<InfoItemVisitDataStatService>(InfoItemVisitDataStatService);

      wrapper = shallowMount<InfoItemVisitDataStatClass>(InfoItemVisitDataStatDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { infoItemVisitDataStatService: () => infoItemVisitDataStatServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundInfoItemVisitDataStat = { id: 123 };
        infoItemVisitDataStatServiceStub.find.resolves(foundInfoItemVisitDataStat);

        // WHEN
        comp.retrieveInfoItemVisitDataStat(123);
        await comp.$nextTick();

        // THEN
        expect(comp.infoItemVisitDataStat).toBe(foundInfoItemVisitDataStat);
      });
    });
  });
});
