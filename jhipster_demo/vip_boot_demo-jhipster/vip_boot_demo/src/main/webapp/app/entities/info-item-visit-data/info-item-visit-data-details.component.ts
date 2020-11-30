import { Component, Vue, Inject } from 'vue-property-decorator';

import { IInfoItemVisitData } from '@/shared/model/info-item-visit-data.model';
import InfoItemVisitDataService from './info-item-visit-data.service';

@Component
export default class InfoItemVisitDataDetails extends Vue {
  @Inject('infoItemVisitDataService') private infoItemVisitDataService: () => InfoItemVisitDataService;
  public infoItemVisitData: IInfoItemVisitData = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.infoItemVisitDataId) {
        vm.retrieveInfoItemVisitData(to.params.infoItemVisitDataId);
      }
    });
  }

  public retrieveInfoItemVisitData(infoItemVisitDataId) {
    this.infoItemVisitDataService()
      .find(infoItemVisitDataId)
      .then(res => {
        this.infoItemVisitData = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
