import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import ResourceItemService from '../resource-item/resource-item.service';
import { IResourceItem } from '@/shared/model/resource-item.model';

import RelativeGoodsItemService from '../relative-goods-item/relative-goods-item.service';
import { IRelativeGoodsItem } from '@/shared/model/relative-goods-item.model';

import AuthorService from '../author/author.service';
import { IAuthor } from '@/shared/model/author.model';

import AlertService from '@/shared/alert/alert.service';
import { IInfoStreamItem, InfoStreamItem } from '@/shared/model/info-stream-item.model';
import InfoStreamItemService from './info-stream-item.service';

const validations: any = {
  infoStreamItem: {
    title: {},
    type: {},
    digist: {},
    content: {},
    createUser: {},
    lastUpdateDate: {},
    updateUser: {},
    createDate: {},
    tags: {},
    contentType: {}
  }
};

@Component({
  validations
})
export default class InfoStreamItemUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('infoStreamItemService') private infoStreamItemService: () => InfoStreamItemService;
  public infoStreamItem: IInfoStreamItem = new InfoStreamItem();

  @Inject('resourceItemService') private resourceItemService: () => ResourceItemService;

  public resourceItems: IResourceItem[] = [];

  @Inject('relativeGoodsItemService') private relativeGoodsItemService: () => RelativeGoodsItemService;

  public relativeGoodsItems: IRelativeGoodsItem[] = [];

  @Inject('authorService') private authorService: () => AuthorService;

  public authors: IAuthor[] = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.infoStreamItemId) {
        vm.retrieveInfoStreamItem(to.params.infoStreamItemId);
      }
      vm.initRelationships();
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.infoStreamItem.id) {
      this.infoStreamItemService()
        .update(this.infoStreamItem)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.infoStreamItem.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.infoStreamItemService()
        .create(this.infoStreamItem)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.infoStreamItem.created', { param: param.id });
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
      this.infoStreamItem[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.infoStreamItem[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.infoStreamItem[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.infoStreamItem[field] = null;
    }
  }

  public retrieveInfoStreamItem(infoStreamItemId): void {
    this.infoStreamItemService()
      .find(infoStreamItemId)
      .then(res => {
        res.lastUpdateDate = new Date(res.lastUpdateDate);
        res.createDate = new Date(res.createDate);
        this.infoStreamItem = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.resourceItemService()
      .retrieve()
      .then(res => {
        this.resourceItems = res.data;
      });
    this.resourceItemService()
      .retrieve()
      .then(res => {
        this.resourceItems = res.data;
      });
    this.relativeGoodsItemService()
      .retrieve()
      .then(res => {
        this.relativeGoodsItems = res.data;
      });
    this.authorService()
      .retrieve()
      .then(res => {
        this.authors = res.data;
      });
  }
}
