import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import InfoStreamItemService from '../info-stream-item/info-stream-item.service';
import { IInfoStreamItem } from '@/shared/model/info-stream-item.model';

import AlertService from '@/shared/alert/alert.service';
import { IResourceItem, ResourceItem } from '@/shared/model/resource-item.model';
import ResourceItemService from './resource-item.service';

const validations: any = {
  resourceItem: {
    type: {},
    platform: {},
    resourceId: {},
    transcodeStatus: {},
    uploadStatus: {},
    updateDate: {},
    auditStatus: {},
    auditDate: {},
    auditInfo: {},
    fileSize: {},
    contentSize: {},
    source: {},
    url: {},
    urlExpire: {},
    params: {},
    auditUser: {},
    delFlag: {}
  }
};

@Component({
  validations
})
export default class ResourceItemUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('resourceItemService') private resourceItemService: () => ResourceItemService;
  public resourceItem: IResourceItem = new ResourceItem();

  @Inject('infoStreamItemService') private infoStreamItemService: () => InfoStreamItemService;

  public infoStreamItems: IInfoStreamItem[] = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.resourceItemId) {
        vm.retrieveResourceItem(to.params.resourceItemId);
      }
      vm.initRelationships();
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.resourceItem.id) {
      this.resourceItemService()
        .update(this.resourceItem)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.resourceItem.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.resourceItemService()
        .create(this.resourceItem)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.resourceItem.created', { param: param.id });
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
      this.resourceItem[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.resourceItem[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.resourceItem[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.resourceItem[field] = null;
    }
  }

  public retrieveResourceItem(resourceItemId): void {
    this.resourceItemService()
      .find(resourceItemId)
      .then(res => {
        res.updateDate = new Date(res.updateDate);
        res.auditDate = new Date(res.auditDate);
        this.resourceItem = res;
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
    this.infoStreamItemService()
      .retrieve()
      .then(res => {
        this.infoStreamItems = res.data;
      });
  }
}
