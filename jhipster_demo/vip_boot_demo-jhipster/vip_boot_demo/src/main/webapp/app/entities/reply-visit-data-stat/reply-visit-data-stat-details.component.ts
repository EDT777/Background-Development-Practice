import { Component, Vue, Inject } from 'vue-property-decorator';

import { IReplyVisitDataStat } from '@/shared/model/reply-visit-data-stat.model';
import ReplyVisitDataStatService from './reply-visit-data-stat.service';

@Component
export default class ReplyVisitDataStatDetails extends Vue {
  @Inject('replyVisitDataStatService') private replyVisitDataStatService: () => ReplyVisitDataStatService;
  public replyVisitDataStat: IReplyVisitDataStat = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.replyVisitDataStatId) {
        vm.retrieveReplyVisitDataStat(to.params.replyVisitDataStatId);
      }
    });
  }

  public retrieveReplyVisitDataStat(replyVisitDataStatId) {
    this.replyVisitDataStatService()
      .find(replyVisitDataStatId)
      .then(res => {
        this.replyVisitDataStat = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
