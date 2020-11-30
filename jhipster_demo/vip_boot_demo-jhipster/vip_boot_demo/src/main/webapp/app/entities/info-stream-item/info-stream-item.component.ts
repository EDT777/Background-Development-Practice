import { mixins } from 'vue-class-component';

import { Component, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IInfoStreamItem } from '@/shared/model/info-stream-item.model';
import AlertMixin from '@/shared/alert/alert.mixin';

import InfoStreamItemService from './info-stream-item.service';

@Component
export default class InfoStreamItem extends mixins(Vue2Filters.mixin, AlertMixin) {
  @Inject('infoStreamItemService') private infoStreamItemService: () => InfoStreamItemService;
  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public infoStreamItems: IInfoStreamItem[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllInfoStreamItems();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllInfoStreamItems();
  }

  public retrieveAllInfoStreamItems(): void {
    this.isFetching = true;

    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort()
    };
    this.infoStreamItemService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.infoStreamItems = res.data;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IInfoStreamItem): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeInfoStreamItem(): void {
    this.infoStreamItemService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('vip1App.infoStreamItem.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllInfoStreamItems();
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
    this.retrieveAllInfoStreamItems();
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
