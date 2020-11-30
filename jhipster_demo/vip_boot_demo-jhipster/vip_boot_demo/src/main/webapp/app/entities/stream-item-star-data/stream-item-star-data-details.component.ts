import { Component, Vue, Inject } from 'vue-property-decorator';

import { IStreamItemStarData } from '@/shared/model/stream-item-star-data.model';
import StreamItemStarDataService from './stream-item-star-data.service';

@Component
export default class StreamItemStarDataDetails extends Vue {
  @Inject('streamItemStarDataService') private streamItemStarDataService: () => StreamItemStarDataService;
  public streamItemStarData: IStreamItemStarData = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.streamItemStarDataId) {
        vm.retrieveStreamItemStarData(to.params.streamItemStarDataId);
      }
    });
  }

  public retrieveStreamItemStarData(streamItemStarDataId) {
    this.streamItemStarDataService()
      .find(streamItemStarDataId)
      .then(res => {
        this.streamItemStarData = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
