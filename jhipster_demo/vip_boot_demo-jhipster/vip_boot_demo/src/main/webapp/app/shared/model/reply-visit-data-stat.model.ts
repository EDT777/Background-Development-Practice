export const enum VisitSource {
  SEARCH = 'SEARCH',
  LIST = 'LIST',
  PUSH = 'PUSH'
}

export interface IReplyVisitDataStat {
  id?: number;
  clickCount?: number;
  startDate?: Date;
  endDate?: Date;
  source?: VisitSource;
  termimal?: string;
  replyCount?: number;
  starCount?: number;
}

export class ReplyVisitDataStat implements IReplyVisitDataStat {
  constructor(
    public id?: number,
    public clickCount?: number,
    public startDate?: Date,
    public endDate?: Date,
    public source?: VisitSource,
    public termimal?: string,
    public replyCount?: number,
    public starCount?: number
  ) {}
}
