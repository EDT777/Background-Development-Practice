/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import ReplyDetailComponent from '@/entities/reply/reply-details.vue';
import ReplyClass from '@/entities/reply/reply-details.component';
import ReplyService from '@/entities/reply/reply.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Reply Management Detail Component', () => {
    let wrapper: Wrapper<ReplyClass>;
    let comp: ReplyClass;
    let replyServiceStub: SinonStubbedInstance<ReplyService>;

    beforeEach(() => {
      replyServiceStub = sinon.createStubInstance<ReplyService>(ReplyService);

      wrapper = shallowMount<ReplyClass>(ReplyDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { replyService: () => replyServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundReply = { id: 123 };
        replyServiceStub.find.resolves(foundReply);

        // WHEN
        comp.retrieveReply(123);
        await comp.$nextTick();

        // THEN
        expect(comp.reply).toBe(foundReply);
      });
    });
  });
});
