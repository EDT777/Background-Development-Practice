import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { IInfoItemVisitDataStat, InfoItemVisitDataStat } from '@/shared/model/info-item-visit-data-stat.model';
import InfoItemVisitDataStatService from './info-item-visit-data-stat.service';

const validations: any = {
  infoItemVisitDataStat: {
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
export default class InfoItemVisitDataStatUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('infoItemVisitDataStatService') private infoItemVisitDataStatService: () => InfoItemVisitDataStatService;
  public infoItemVisitDataStat: IInfoItemVisitDataStat = new InfoItemVisitDataStat();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.infoItemVisitDataStatId) {
        vm.retrieveInfoItemVisitDataStat(to.params.infoItemVisitDataStatId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.infoItemVisitDataStat.id) {
      this.infoItemVisitDataStatService()
        .update(this.infoItemVisitDataStat)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.infoItemVisitDataStat.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.infoItemVisitDataStatService()
        .create(this.infoItemVisitDataStat)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.infoItemVisitDataStat.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveInfoItemVisitDataStat(infoItemVisitDataStatId): void {
    this.infoItemVisitDataStatService()
      .find(infoItemVisitDataStatId)
      .then(res => {
        this.infoItemVisitDataStat = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
