/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_FORMAT } from '@/shared/date/filters';
import InfoItemVisitDataStatService from '@/entities/info-item-visit-data-stat/info-item-visit-data-stat.service';
import { InfoItemVisitDataStat, VisitSource } from '@/shared/model/info-item-visit-data-stat.model';

const mockedAxios: any = axios;
const error = {
  response: {
    status: null,
    data: {
      type: null
    }
  }
};

jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('InfoItemVisitDataStat Service', () => {
    let service: InfoItemVisitDataStatService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new InfoItemVisitDataStatService();
      currentDate = new Date();

      elemDefault = new InfoItemVisitDataStat(0, 0, currentDate, currentDate, VisitSource.SEARCH, 'AAAAAAA', 0, 0);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            startDate: format(currentDate, DATE_FORMAT),
            endDate: format(currentDate, DATE_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a InfoItemVisitDataStat', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            startDate: format(currentDate, DATE_FORMAT),
            endDate: format(currentDate, DATE_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            startDate: currentDate,
            endDate: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a InfoItemVisitDataStat', async () => {
        mockedAxios.post.mockReturnValue(Promise.reject(error));

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a InfoItemVisitDataStat', async () => {
        const returnedFromService = Object.assign(
          {
            clickCount: 1,
            startDate: format(currentDate, DATE_FORMAT),
            endDate: format(currentDate, DATE_FORMAT),
            source: 'BBBBBB',
            termimal: 'BBBBBB',
            replyCount: 1,
            starCount: 1
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            startDate: currentDate,
            endDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a InfoItemVisitDataStat', async () => {
        mockedAxios.put.mockReturnValue(Promise.reject(error));

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of InfoItemVisitDataStat', async () => {
        const returnedFromService = Object.assign(
          {
            clickCount: 1,
            startDate: format(currentDate, DATE_FORMAT),
            endDate: format(currentDate, DATE_FORMAT),
            source: 'BBBBBB',
            termimal: 'BBBBBB',
            replyCount: 1,
            starCount: 1
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            startDate: currentDate,
            endDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of InfoItemVisitDataStat', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a InfoItemVisitDataStat', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a InfoItemVisitDataStat', async () => {
        mockedAxios.delete.mockReturnValue(Promise.reject(error));

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
