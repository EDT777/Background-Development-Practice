import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IReplyVisitDataStat } from '@/shared/model/reply-visit-data-stat.model';

const baseApiUrl = 'api/reply-visit-data-stats';

export default class ReplyVisitDataStatService {
  public find(id: number): Promise<IReplyVisitDataStat> {
    return new Promise<IReplyVisitDataStat>((resolve, reject) => {
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

  public create(entity: IReplyVisitDataStat): Promise<IReplyVisitDataStat> {
    return new Promise<IReplyVisitDataStat>((resolve, reject) => {
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

  public update(entity: IReplyVisitDataStat): Promise<IReplyVisitDataStat> {
    return new Promise<IReplyVisitDataStat>((resolve, reject) => {
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
