import { mixins } from 'vue-class-component';

import { Component, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IUserContentCollection } from '@/shared/model/user-content-collection.model';
import AlertMixin from '@/shared/alert/alert.mixin';

import UserContentCollectionService from './user-content-collection.service';

@Component
export default class UserContentCollection extends mixins(Vue2Filters.mixin, AlertMixin) {
  @Inject('userContentCollectionService') private userContentCollectionService: () => UserContentCollectionService;
  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public userContentCollections: IUserContentCollection[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllUserContentCollections();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllUserContentCollections();
  }

  public retrieveAllUserContentCollections(): void {
    this.isFetching = true;

    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort()
    };
    this.userContentCollectionService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.userContentCollections = res.data;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IUserContentCollection): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeUserContentCollection(): void {
    this.userContentCollectionService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('vip1App.userContentCollection.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllUserContentCollections();
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
    this.retrieveAllUserContentCollections();
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
