import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import InfoStreamItemService from '../info-stream-item/info-stream-item.service';
import { IInfoStreamItem } from '@/shared/model/info-stream-item.model';

import AlertService from '@/shared/alert/alert.service';
import { IRelativeGoodsItem, RelativeGoodsItem } from '@/shared/model/relative-goods-item.model';
import RelativeGoodsItemService from './relative-goods-item.service';

const validations: any = {
  relativeGoodsItem: {
    platform: {},
    url: {},
    itemId: {},
    translated: {},
    translatedUrl: {},
    mainImage: {},
    smallImages: {},
    title: {},
    shopName: {},
    sellCount: {},
    price: {},
    zkPrice: {},
    commssion: {},
    commssionRate: {},
    description: {},
    coupon: {}
  }
};

@Component({
  validations
})
export default class RelativeGoodsItemUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('relativeGoodsItemService') private relativeGoodsItemService: () => RelativeGoodsItemService;
  public relativeGoodsItem: IRelativeGoodsItem = new RelativeGoodsItem();

  @Inject('infoStreamItemService') private infoStreamItemService: () => InfoStreamItemService;

  public infoStreamItems: IInfoStreamItem[] = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.relativeGoodsItemId) {
        vm.retrieveRelativeGoodsItem(to.params.relativeGoodsItemId);
      }
      vm.initRelationships();
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.relativeGoodsItem.id) {
      this.relativeGoodsItemService()
        .update(this.relativeGoodsItem)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.relativeGoodsItem.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.relativeGoodsItemService()
        .create(this.relativeGoodsItem)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.relativeGoodsItem.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveRelativeGoodsItem(relativeGoodsItemId): void {
    this.relativeGoodsItemService()
      .find(relativeGoodsItemId)
      .then(res => {
        this.relativeGoodsItem = res;
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
