import { Component, Vue, Inject } from 'vue-property-decorator';

import { IInfoItemVisitDataStat } from '@/shared/model/info-item-visit-data-stat.model';
import InfoItemVisitDataStatService from './info-item-visit-data-stat.service';

@Component
export default class InfoItemVisitDataStatDetails extends Vue {
  @Inject('infoItemVisitDataStatService') private infoItemVisitDataStatService: () => InfoItemVisitDataStatService;
  public infoItemVisitDataStat: IInfoItemVisitDataStat = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.infoItemVisitDataStatId) {
        vm.retrieveInfoItemVisitDataStat(to.params.infoItemVisitDataStatId);
      }
    });
  }

  public retrieveInfoItemVisitDataStat(infoItemVisitDataStatId) {
    this.infoItemVisitDataStatService()
      .find(infoItemVisitDataStatId)
      .then(res => {
        this.infoItemVisitDataStat = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
