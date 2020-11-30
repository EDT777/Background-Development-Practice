/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import StreamItemStarDataService from '@/entities/stream-item-star-data/stream-item-star-data.service';
import { StreamItemStarData } from '@/shared/model/stream-item-star-data.model';

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
  describe('StreamItemStarData Service', () => {
    let service: StreamItemStarDataService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new StreamItemStarDataService();
      currentDate = new Date();

      elemDefault = new StreamItemStarData(0, 0, currentDate, 0, 'AAAAAAA', 'AAAAAAA', false, 0);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            createDate: format(currentDate, DATE_TIME_FORMAT)
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

      it('should create a StreamItemStarData', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            createDate: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createDate: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a StreamItemStarData', async () => {
        mockedAxios.post.mockReturnValue(Promise.reject(error));

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a StreamItemStarData', async () => {
        const returnedFromService = Object.assign(
          {
            userId: 1,
            createDate: format(currentDate, DATE_TIME_FORMAT),
            type: 1,
            itemId: 'BBBBBB',
            replayId: 'BBBBBB',
            valid: true,
            starType: 1
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a StreamItemStarData', async () => {
        mockedAxios.put.mockReturnValue(Promise.reject(error));

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of StreamItemStarData', async () => {
        const returnedFromService = Object.assign(
          {
            userId: 1,
            createDate: format(currentDate, DATE_TIME_FORMAT),
            type: 1,
            itemId: 'BBBBBB',
            replayId: 'BBBBBB',
            valid: true,
            starType: 1
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of StreamItemStarData', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a StreamItemStarData', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a StreamItemStarData', async () => {
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
