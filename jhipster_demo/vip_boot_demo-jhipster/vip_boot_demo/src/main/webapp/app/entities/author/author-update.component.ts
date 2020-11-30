import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { IAuthor, Author } from '@/shared/model/author.model';
import AuthorService from './author.service';

const validations: any = {
  author: {
    name: {},
    pct: {},
    valid: {},
    createDate: {},
    level: {}
  }
};

@Component({
  validations
})
export default class AuthorUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('authorService') private authorService: () => AuthorService;
  public author: IAuthor = new Author();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.authorId) {
        vm.retrieveAuthor(to.params.authorId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.author.id) {
      this.authorService()
        .update(this.author)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.author.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.authorService()
        .create(this.author)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('vip1App.author.created', { param: param.id });
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
      this.author[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.author[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.author[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.author[field] = null;
    }
  }

  public retrieveAuthor(authorId): void {
    this.authorService()
      .find(authorId)
      .then(res => {
        res.createDate = new Date(res.createDate);
        this.author = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
