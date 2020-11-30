import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IInfoItemVisitDataStat } from '@/shared/model/info-item-visit-data-stat.model';

const baseApiUrl = 'api/info-item-visit-data-stats';

export default class InfoItemVisitDataStatService {
  public find(id: number): Promise<IInfoItemVisitDataStat> {
    return new Promise<IInfoItemVisitDataStat>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(function(res) {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(paginationQuery?: any): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl + `?${buildPaginationQueryOpts(paginationQuery)}`)
        .then(function(res) {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public delete(id: number): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .delete(`${baseApiUrl}/${id}`)
        .then(function(res) {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: IInfoItemVisitDataStat): Promise<IInfoItemVisitDataStat> {
    return new Promise<IInfoItemVisitDataStat>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(function(res) {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public update(entity: IInfoItemVisitDataStat): Promise<IInfoItemVisitDataStat> {
    return new Promise<IInfoItemVisitDataStat>((resolve, reject) => {
      axios
        .put(`${baseApiUrl}`, entity)
        .then(function(res) {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
