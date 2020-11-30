import { Component, Vue, Inject } from 'vue-property-decorator';

import { IResourceItem } from '@/shared/model/resource-item.model';
import ResourceItemService from './resource-item.service';

@Component
export default class ResourceItemDetails extends Vue {
  @Inject('resourceItemService') private resourceItemService: () => ResourceItemService;
  public resourceItem: IResourceItem = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.resourceItemId) {
        vm.retrieveResourceItem(to.params.resourceItemId);
      }
    });
  }

  public retrieveResourceItem(resourceItemId) {
    this.resourceItemService()
      .find(resourceItemId)
      .then(res => {
        this.resourceItem = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
