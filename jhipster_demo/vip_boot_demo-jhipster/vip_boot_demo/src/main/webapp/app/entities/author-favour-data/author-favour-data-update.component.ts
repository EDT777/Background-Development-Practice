import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AuthorService from '../author/author.service';
import { IAuthor } from '@/shared/model/author.model';

import AlertService from '@/shared/alert/alert.service';
import { IAuthorFavourData, AuthorFavourData } from '@/shared/model/author-favour-data.model';
import AuthorFavourDataService from './author-favour-data.service';

const validations: any = {
  authorFavourData: {
    userId: {},
    createDate: {}
  }
};

@Component({
  validations
})
export default class AuthorFavourDataUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('authorFavourDataService') private authorFavourDataService: () => AuthorFavourDataService;
  public authorFavourData: IAuthorFavourData = new AuthorFavourData();

  @Inject('authorService') private authorService: () => AuthorService;

  public authors: IAuthor[] = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.authorFavourDataId) {
        vm.retrieveAuthorFavourData(to.params.authorFavourDataId);
      }
      vm.initRelationships();
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.authorFavourData.id) {
      this.authorFavourDataService()
        .update(this.authorFavourData)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.authorFavourData.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.authorFavourDataService()
        .create(this.authorFavourData)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.authorFavourData.created', { param: param.id });
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
      this.authorFavourData[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.authorFavourData[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.authorFavourData[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.authorFavourData[field] = null;
    }
  }

  public retrieveAuthorFavourData(authorFavourDataId): void {
    this.authorFavourDataService()
      .find(authorFavourDataId)
      .then(res => {
        res.createDate = new Date(res.createDate);
        this.authorFavourData = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.authorService()
      .retrieve()
      .then(res => {
        this.authors = res.data;
      });
  }
}
