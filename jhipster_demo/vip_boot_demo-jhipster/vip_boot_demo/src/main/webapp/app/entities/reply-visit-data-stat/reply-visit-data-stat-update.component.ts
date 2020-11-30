import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { IReplyVisitDataStat, ReplyVisitDataStat } from '@/shared/model/reply-visit-data-stat.model';
import ReplyVisitDataStatService from './reply-visit-data-stat.service';

const validations: any = {
  replyVisitDataStat: {
    clickCount: {},
    startDate: {},
    endDate: {},
    source: {},
    termimal: {},
    replyCount: {},
    starCount: {}
  }
};

@Component({
  validations
})
export default class ReplyVisitDataStatUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('replyVisitDataStatService') private replyVisitDataStatService: () => ReplyVisitDataStatService;
  public replyVisitDataStat: IReplyVisitDataStat = new ReplyVisitDataStat();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.replyVisitDataStatId) {
        vm.retrieveReplyVisitDataStat(to.params.replyVisitDataStatId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.replyVisitDataStat.id) {
      this.replyVisitDataStatService()
        .update(this.replyVisitDataStat)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.replyVisitDataStat.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.replyVisitDataStatService()
        .create(this.replyVisitDataStat)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.replyVisitDataStat.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveReplyVisitDataStat(replyVisitDataStatId): void {
    this.replyVisitDataStatService()
      .find(replyVisitDataStatId)
      .then(res => {
        this.replyVisitDataStat = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
