import { Component, Vue, Inject } from 'vue-property-decorator';

import { IInfoStreamItem } from '@/shared/model/info-stream-item.model';
import InfoStreamItemService from './info-stream-item.service';

@Component
export default class InfoStreamItemDetails extends Vue {
  @Inject('infoStreamItemService') private infoStreamItemService: () => InfoStreamItemService;
  public infoStreamItem: IInfoStreamItem = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.infoStreamItemId) {
        vm.retrieveInfoStreamItem(to.params.infoStreamItemId);
      }
    });
  }

  public retrieveInfoStreamItem(infoStreamItemId) {
    this.infoStreamItemService()
      .find(infoStreamItemId)
      .then(res => {
        this.infoStreamItem = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
