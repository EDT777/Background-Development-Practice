import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import InfoStreamItemService from '../info-stream-item/info-stream-item.service';
import { IInfoStreamItem } from '@/shared/model/info-stream-item.model';

import AlertService from '@/shared/alert/alert.service';
import { IReply, Reply } from '@/shared/model/reply.model';
import ReplyService from './reply.service';

const validations: any = {
  reply: {
    title: {},
    content: {},
    auditStatus: {},
    createData: {},
    auditDate: {},
    createUser: {},
    auditUser: {},
    replyUserId: {},
    replyUserNickName: {},
    delFlag: {}
  }
};

@Component({
  validations
})
export default class ReplyUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('replyService') private replyService: () => ReplyService;
  public reply: IReply = new Reply();

  public replies: IReply[] = [];

  @Inject('infoStreamItemService') private infoStreamItemService: () => InfoStreamItemService;

  public infoStreamItems: IInfoStreamItem[] = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.replyId) {
        vm.retrieveReply(to.params.replyId);
      }
      vm.initRelationships();
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.reply.id) {
      this.replyService()
        .update(this.reply)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.reply.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.replyService()
        .create(this.reply)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.reply.created', { param: param.id });
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
      this.reply[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.reply[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.reply[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.reply[field] = null;
    }
  }

  public retrieveReply(replyId): void {
    this.replyService()
      .find(replyId)
      .then(res => {
        res.createData = new Date(res.createData);
        res.auditDate = new Date(res.auditDate);
        this.reply = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.replyService()
      .retrieve()
      .then(res => {
        this.replies = res.data;
      });
    this.infoStreamItemService()
      .retrieve()
      .then(res => {
        this.infoStreamItems = res.data;
      });
  }
}
