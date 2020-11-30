import { Component, Vue, Inject } from 'vue-property-decorator';

import { IRelativeGoodsItem } from '@/shared/model/relative-goods-item.model';
import RelativeGoodsItemService from './relative-goods-item.service';

@Component
export default class RelativeGoodsItemDetails extends Vue {
  @Inject('relativeGoodsItemService') private relativeGoodsItemService: () => RelativeGoodsItemService;
  public relativeGoodsItem: IRelativeGoodsItem = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.relativeGoodsItemId) {
        vm.retrieveRelativeGoodsItem(to.params.relativeGoodsItemId);
      }
    });
  }

  public retrieveRelativeGoodsItem(relativeGoodsItemId) {
    this.relativeGoodsItemService()
      .find(relativeGoodsItemId)
      .then(res => {
        this.relativeGoodsItem = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
