import { mixins } from 'vue-class-component';

import { Component, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IRelativeGoodsItem } from '@/shared/model/relative-goods-item.model';
import AlertMixin from '@/shared/alert/alert.mixin';

import RelativeGoodsItemService from './relative-goods-item.service';

@Component
export default class RelativeGoodsItem extends mixins(Vue2Filters.mixin, AlertMixin) {
  @Inject('relativeGoodsItemService') private relativeGoodsItemService: () => RelativeGoodsItemService;
  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public relativeGoodsItems: IRelativeGoodsItem[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllRelativeGoodsItems();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllRelativeGoodsItems();
  }

  public retrieveAllRelativeGoodsItems(): void {
    this.isFetching = true;

    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort()
    };
    this.relativeGoodsItemService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.relativeGoodsItems = res.data;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IRelativeGoodsItem): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeRelativeGoodsItem(): void {
    this.relativeGoodsItemService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('vip1App.relativeGoodsItem.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllRelativeGoodsItems();
        this.closeDialog();
      });
  }

  public sort(): Array<any> {
    const result = [this.propOrder + ',' + (this.reverse ? 'asc' : 'desc')];
    if (this.propOrder !== 'id') {
      result.push('id');
    }
    return result;
  }

  public loadPage(page: number): void {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.transition();
    }
  }

  public transition(): void {
    this.retrieveAllRelativeGoodsItems();
  }

  public changeOrder(propOrder): void {
    this.propOrder = propOrder;
    this.reverse = !this.reverse;
    this.transition();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
