import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IStreamItemStarData, StreamItemStarData } from '@/shared/model/stream-item-star-data.model';
import StreamItemStarDataService from './stream-item-star-data.service';

const validations: any = {
  streamItemStarData: {
    userId: {},
    createDate: {},
    type: {},
    itemId: {},
    replayId: {},
    valid: {},
    starType: {}
  }
};

@Component({
  validations
})
export default class StreamItemStarDataUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('streamItemStarDataService') private streamItemStarDataService: () => StreamItemStarDataService;
  public streamItemStarData: IStreamItemStarData = new StreamItemStarData();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.streamItemStarDataId) {
        vm.retrieveStreamItemStarData(to.params.streamItemStarDataId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.streamItemStarData.id) {
      this.streamItemStarDataService()
        .update(this.streamItemStarData)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.streamItemStarData.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.streamItemStarDataService()
        .create(this.streamItemStarData)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.streamItemStarData.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public convertDateTimeFromServer(date: Date): string {
    if (date) {
      return format(date, DATE_TIME_LONG_FORMAT);
    }
    return null;
  }

  public updateInstantField(field, event) {
    if (event.target.value) {
      this.streamItemStarData[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.streamItemStarData[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.streamItemStarData[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.streamItemStarData[field] = null;
    }
  }

  public retrieveStreamItemStarData(streamItemStarDataId): void {
    this.streamItemStarDataService()
      .find(streamItemStarDataId)
      .then(res => {
        res.createDate = new Date(res.createDate);
        this.streamItemStarData = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
