import { Component, Vue, Inject } from 'vue-property-decorator';

import { IAuthorFavourData } from '@/shared/model/author-favour-data.model';
import AuthorFavourDataService from './author-favour-data.service';

@Component
export default class AuthorFavourDataDetails extends Vue {
  @Inject('authorFavourDataService') private authorFavourDataService: () => AuthorFavourDataService;
  public authorFavourData: IAuthorFavourData = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.authorFavourDataId) {
        vm.retrieveAuthorFavourData(to.params.authorFavourDataId);
      }
    });
  }

  public retrieveAuthorFavourData(authorFavourDataId) {
    this.authorFavourDataService()
      .find(authorFavourDataId)
      .then(res => {
        this.authorFavourData = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
