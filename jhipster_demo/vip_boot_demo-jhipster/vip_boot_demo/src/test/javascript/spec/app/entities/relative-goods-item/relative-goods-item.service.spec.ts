/* tslint:disable max-line-length */
import axios from 'axios';

import * as config from '@/shared/config/config';
import {} from '@/shared/date/filters';
import RelativeGoodsItemService from '@/entities/relative-goods-item/relative-goods-item.service';
import { RelativeGoodsItem } from '@/shared/model/relative-goods-item.model';

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
  describe('RelativeGoodsItem Service', () => {
    let service: RelativeGoodsItemService;
    let elemDefault;
    beforeEach(() => {
      service = new RelativeGoodsItemService();

      elemDefault = new RelativeGoodsItem(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        false,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        0,
        0,
        'AAAAAAA',
        0
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign({}, elemDefault);
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

      it('should create a RelativeGoodsItem', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a RelativeGoodsItem', async () => {
        mockedAxios.post.mockReturnValue(Promise.reject(error));

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a RelativeGoodsItem', async () => {
        const returnedFromService = Object.assign(
          {
            platform: 'BBBBBB',
            url: 'BBBBBB',
            itemId: 'BBBBBB',
            translated: true,
            translatedUrl: 'BBBBBB',
            mainImage: 'BBBBBB',
            smallImages: 'BBBBBB',
            title: 'BBBBBB',
            shopName: 'BBBBBB',
            sellCount: 1,
            price: 1,
            zkPrice: 1,
            commssion: 1,
            commssionRate: 1,
            description: 'BBBBBB',
            coupon: 1
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a RelativeGoodsItem', async () => {
        mockedAxios.put.mockReturnValue(Promise.reject(error));

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of RelativeGoodsItem', async () => {
        const returnedFromService = Object.assign(
          {
            platform: 'BBBBBB',
            url: 'BBBBBB',
            itemId: 'BBBBBB',
            translated: true,
            translatedUrl: 'BBBBBB',
            mainImage: 'BBBBBB',
            smallImages: 'BBBBBB',
            title: 'BBBBBB',
            shopName: 'BBBBBB',
            sellCount: 1,
            price: 1,
            zkPrice: 1,
            commssion: 1,
            commssionRate: 1,
            description: 'BBBBBB',
            coupon: 1
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of RelativeGoodsItem', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a RelativeGoodsItem', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a RelativeGoodsItem', async () => {
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
