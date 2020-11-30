import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IUserContentCollection, UserContentCollection } from '@/shared/model/user-content-collection.model';
import UserContentCollectionService from './user-content-collection.service';

const validations: any = {
  userContentCollection: {
    userId: {},
    platform: {},
    link: {},
    createDate: {},
    pctUrl: {},
    valid: {}
  }
};

@Component({
  validations
})
export default class UserContentCollectionUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('userContentCollectionService') private userContentCollectionService: () => UserContentCollectionService;
  public userContentCollection: IUserContentCollection = new UserContentCollection();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.userContentCollectionId) {
        vm.retrieveUserContentCollection(to.params.userContentCollectionId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.userContentCollection.id) {
      this.userContentCollectionService()
        .update(this.userContentCollection)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.userContentCollection.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.userContentCollectionService()
        .create(this.userContentCollection)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.userContentCollection.created', { param: param.id });
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
      this.userContentCollection[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.userContentCollection[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.userContentCollection[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.userContentCollection[field] = null;
    }
  }

  public retrieveUserContentCollection(userContentCollectionId): void {
    this.userContentCollectionService()
      .find(userContentCollectionId)
      .then(res => {
        res.createDate = new Date(res.createDate);
        this.userContentCollection = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
