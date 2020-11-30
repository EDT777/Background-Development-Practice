/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import ResourceItemService from '@/entities/resource-item/resource-item.service';
import { ResourceItem, ItemResourceType } from '@/shared/model/resource-item.model';

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
  describe('ResourceItem Service', () => {
    let service: ResourceItemService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new ResourceItemService();
      currentDate = new Date();

      elemDefault = new ResourceItem(
        0,
        ItemResourceType.VIDEO,
        'AAAAAAA',
        'AAAAAAA',
        false,
        false,
        currentDate,
        false,
        currentDate,
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        false
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            updateDate: format(currentDate, DATE_TIME_FORMAT),
            auditDate: format(currentDate, DATE_TIME_FORMAT)
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

      it('should create a ResourceItem', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            updateDate: format(currentDate, DATE_TIME_FORMAT),
            auditDate: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            updateDate: currentDate,
            auditDate: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a ResourceItem', async () => {
        mockedAxios.post.mockReturnValue(Promise.reject(error));

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a ResourceItem', async () => {
        const returnedFromService = Object.assign(
          {
            type: 'BBBBBB',
            platform: 'BBBBBB',
            resourceId: 'BBBBBB',
            transcodeStatus: true,
            uploadStatus: true,
            updateDate: format(currentDate, DATE_TIME_FORMAT),
            auditStatus: true,
            auditDate: format(currentDate, DATE_TIME_FORMAT),
            auditInfo: 'BBBBBB',
            fileSize: 1,
            contentSize: 1,
            source: 'BBBBBB',
            url: 'BBBBBB',
            urlExpire: 1,
            params: 'BBBBBB',
            auditUser: 1,
            delFlag: true
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            updateDate: currentDate,
            auditDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a ResourceItem', async () => {
        mockedAxios.put.mockReturnValue(Promise.reject(error));

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of ResourceItem', async () => {
        const returnedFromService = Object.assign(
          {
            type: 'BBBBBB',
            platform: 'BBBBBB',
            resourceId: 'BBBBBB',
            transcodeStatus: true,
            uploadStatus: true,
            updateDate: format(currentDate, DATE_TIME_FORMAT),
            auditStatus: true,
            auditDate: format(currentDate, DATE_TIME_FORMAT),
            auditInfo: 'BBBBBB',
            fileSize: 1,
            contentSize: 1,
            source: 'BBBBBB',
            url: 'BBBBBB',
            urlExpire: 1,
            params: 'BBBBBB',
            auditUser: 1,
            delFlag: true
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            updateDate: currentDate,
            auditDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of ResourceItem', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a ResourceItem', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a ResourceItem', async () => {
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
