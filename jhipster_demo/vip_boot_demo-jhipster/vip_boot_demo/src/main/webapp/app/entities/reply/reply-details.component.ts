import { Component, Vue, Inject } from 'vue-property-decorator';

import { IReply } from '@/shared/model/reply.model';
import ReplyService from './reply.service';

@Component
export default class ReplyDetails extends Vue {
  @Inject('replyService') private replyService: () => ReplyService;
  public reply: IReply = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.replyId) {
        vm.retrieveReply(to.params.replyId);
      }
    });
  }

  public retrieveReply(replyId) {
    this.replyService()
      .find(replyId)
      .then(res => {
        this.reply = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
