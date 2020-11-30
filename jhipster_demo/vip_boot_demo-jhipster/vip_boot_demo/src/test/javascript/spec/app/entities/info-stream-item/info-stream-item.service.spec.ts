/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import InfoStreamItemService from '@/entities/info-stream-item/info-stream-item.service';
import { InfoStreamItem, ItemResourceType } from '@/shared/model/info-stream-item.model';

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
  describe('InfoStreamItem Service', () => {
    let service: InfoStreamItemService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new InfoStreamItemService();
      currentDate = new Date();

      elemDefault = new InfoStreamItem(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        ItemResourceType.VIDEO
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            lastUpdateDate: format(currentDate, DATE_TIME_FORMAT),
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

      it('should create a InfoStreamItem', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            lastUpdateDate: format(currentDate, DATE_TIME_FORMAT),
            createDate: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            lastUpdateDate: currentDate,
            createDate: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a InfoStreamItem', async () => {
        mockedAxios.post.mockReturnValue(Promise.reject(error));

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a InfoStreamItem', async () => {
        const returnedFromService = Object.assign(
          {
            title: 'BBBBBB',
            type: 'BBBBBB',
            digist: 'BBBBBB',
            content: 'BBBBBB',
            createUser: 'BBBBBB',
            lastUpdateDate: format(currentDate, DATE_TIME_FORMAT),
            updateUser: 'BBBBBB',
            createDate: format(currentDate, DATE_TIME_FORMAT),
            tags: 'BBBBBB',
            contentType: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            lastUpdateDate: currentDate,
            createDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a InfoStreamItem', async () => {
        mockedAxios.put.mockReturnValue(Promise.reject(error));

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of InfoStreamItem', async () => {
        const returnedFromService = Object.assign(
          {
            title: 'BBBBBB',
            type: 'BBBBBB',
            digist: 'BBBBBB',
            content: 'BBBBBB',
            createUser: 'BBBBBB',
            lastUpdateDate: format(currentDate, DATE_TIME_FORMAT),
            updateUser: 'BBBBBB',
            createDate: format(currentDate, DATE_TIME_FORMAT),
            tags: 'BBBBBB',
            contentType: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            lastUpdateDate: currentDate,
            createDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of InfoStreamItem', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a InfoStreamItem', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a InfoStreamItem', async () => {
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
