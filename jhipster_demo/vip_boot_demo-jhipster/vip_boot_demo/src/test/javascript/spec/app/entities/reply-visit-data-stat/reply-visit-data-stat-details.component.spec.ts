/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import ReplyVisitDataStatDetailComponent from '@/entities/reply-visit-data-stat/reply-visit-data-stat-details.vue';
import ReplyVisitDataStatClass from '@/entities/reply-visit-data-stat/reply-visit-data-stat-details.component';
import ReplyVisitDataStatService from '@/entities/reply-visit-data-stat/reply-visit-data-stat.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('ReplyVisitDataStat Management Detail Component', () => {
    let wrapper: Wrapper<ReplyVisitDataStatClass>;
    let comp: ReplyVisitDataStatClass;
    let replyVisitDataStatServiceStub: SinonStubbedInstance<ReplyVisitDataStatService>;

    beforeEach(() => {
      replyVisitDataStatServiceStub = sinon.createStubInstance<ReplyVisitDataStatService>(ReplyVisitDataStatService);

      wrapper = shallowMount<ReplyVisitDataStatClass>(ReplyVisitDataStatDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { replyVisitDataStatService: () => replyVisitDataStatServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundReplyVisitDataStat = { id: 123 };
        replyVisitDataStatServiceStub.find.resolves(foundReplyVisitDataStat);

        // WHEN
        comp.retrieveReplyVisitDataStat(123);
        await comp.$nextTick();

        // THEN
        expect(comp.replyVisitDataStat).toBe(foundReplyVisitDataStat);
      });
    });
  });
});
