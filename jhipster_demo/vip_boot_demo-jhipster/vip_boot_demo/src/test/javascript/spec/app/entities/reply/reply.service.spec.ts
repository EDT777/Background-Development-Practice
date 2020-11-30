/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import ReplyService from '@/entities/reply/reply.service';
import { Reply } from '@/shared/model/reply.model';

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
  describe('Reply Service', () => {
    let service: ReplyService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new ReplyService();
      currentDate = new Date();

      elemDefault = new Reply(0, 'AAAAAAA', 'AAAAAAA', false, currentDate, currentDate, 'AAAAAAA', 0, 0, 'AAAAAAA', false);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            createData: format(currentDate, DATE_TIME_FORMAT),
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

      it('should create a Reply', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            createData: format(currentDate, DATE_TIME_FORMAT),
            auditDate: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createData: currentDate,
            auditDate: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a Reply', async () => {
        mockedAxios.post.mockReturnValue(Promise.reject(error));

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a Reply', async () => {
        const returnedFromService = Object.assign(
          {
            title: 'BBBBBB',
            content: 'BBBBBB',
            auditStatus: true,
            createData: format(currentDate, DATE_TIME_FORMAT),
            auditDate: format(currentDate, DATE_TIME_FORMAT),
            createUser: 'BBBBBB',
            auditUser: 1,
            replyUserId: 1,
            replyUserNickName: 'BBBBBB',
            delFlag: true
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createData: currentDate,
            auditDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a Reply', async () => {
        mockedAxios.put.mockReturnValue(Promise.reject(error));

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of Reply', async () => {
        const returnedFromService = Object.assign(
          {
            title: 'BBBBBB',
            content: 'BBBBBB',
            auditStatus: true,
            createData: format(currentDate, DATE_TIME_FORMAT),
            auditDate: format(currentDate, DATE_TIME_FORMAT),
            createUser: 'BBBBBB',
            auditUser: 1,
            replyUserId: 1,
            replyUserNickName: 'BBBBBB',
            delFlag: true
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createData: currentDate,
            auditDate: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of Reply', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a Reply', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a Reply', async () => {
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
