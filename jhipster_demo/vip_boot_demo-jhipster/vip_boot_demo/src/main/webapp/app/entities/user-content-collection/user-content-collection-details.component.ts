import { Component, Vue, Inject } from 'vue-property-decorator';

import { IUserContentCollection } from '@/shared/model/user-content-collection.model';
import UserContentCollectionService from './user-content-collection.service';

@Component
export default class UserContentCollectionDetails extends Vue {
  @Inject('userContentCollectionService') private userContentCollectionService: () => UserContentCollectionService;
  public userContentCollection: IUserContentCollection = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.userContentCollectionId) {
        vm.retrieveUserContentCollection(to.params.userContentCollectionId);
      }
    });
  }

  public retrieveUserContentCollection(userContentCollectionId) {
    this.userContentCollectionService()
      .find(userContentCollectionId)
      .then(res => {
        this.userContentCollection = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
