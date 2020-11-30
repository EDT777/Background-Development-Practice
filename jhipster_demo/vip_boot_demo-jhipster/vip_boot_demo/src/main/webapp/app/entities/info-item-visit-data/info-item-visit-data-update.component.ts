import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import InfoStreamItemService from '../info-stream-item/info-stream-item.service';
import { IInfoStreamItem } from '@/shared/model/info-stream-item.model';

import AlertService from '@/shared/alert/alert.service';
import { IInfoItemVisitData, InfoItemVisitData } from '@/shared/model/info-item-visit-data.model';
import InfoItemVisitDataService from './info-item-visit-data.service';

const validations: any = {
  infoItemVisitData: {
    userId: {},
    deviceNo: {},
    date: {},
    source: {},
    action: {},
    goods: {},
    termimal: {}
  }
};

@Component({
  validations
})
export default class InfoItemVisitDataUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('infoItemVisitDataService') private infoItemVisitDataService: () => InfoItemVisitDataService;
  public infoItemVisitData: IInfoItemVisitData = new InfoItemVisitData();

  @Inject('infoStreamItemService') private infoStreamItemService: () => InfoStreamItemService;

  public infoStreamItems: IInfoStreamItem[] = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.infoItemVisitDataId) {
        vm.retrieveInfoItemVisitData(to.params.infoItemVisitDataId);
      }
      vm.initRelationships();
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.infoItemVisitData.id) {
      this.infoItemVisitDataService()
        .update(this.infoItemVisitData)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.infoItemVisitData.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.infoItemVisitDataService()
        .create(this.infoItemVisitData)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.infoItemVisitData.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveInfoItemVisitData(infoItemVisitDataId): void {
    this.infoItemVisitDataService()
      .find(infoItemVisitDataId)
      .then(res => {
        this.infoItemVisitData = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.infoStreamItemService()
      .retrieve()
      .then(res => {
        this.infoStreamItems = res.data;
      });
  }
}
