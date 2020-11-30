import { mixins } from 'vue-class-component';

import { Component, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IReplyVisitDataStat } from '@/shared/model/reply-visit-data-stat.model';
import AlertMixin from '@/shared/alert/alert.mixin';

import ReplyVisitDataStatService from './reply-visit-data-stat.service';

@Component
export default class ReplyVisitDataStat extends mixins(Vue2Filters.mixin, AlertMixin) {
  @Inject('replyVisitDataStatService') private replyVisitDataStatService: () => ReplyVisitDataStatService;
  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public replyVisitDataStats: IReplyVisitDataStat[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllReplyVisitDataStats();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllReplyVisitDataStats();
  }

  public retrieveAllReplyVisitDataStats(): void {
    this.isFetching = true;

    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort()
    };
    this.replyVisitDataStatService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.replyVisitDataStats = res.data;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IReplyVisitDataStat): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeReplyVisitDataStat(): void {
    this.replyVisitDataStatService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('vip1App.replyVisitDataStat.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllReplyVisitDataStats();
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
    this.retrieveAllReplyVisitDataStats();
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
