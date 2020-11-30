export const enum VisitSource {
  SEARCH = 'SEARCH',
  LIST = 'LIST',
  PUSH = 'PUSH'
}

export interface IInfoItemVisitData {
  id?: number;
  userId?: string;
  deviceNo?: string;
  date?: Date;
  source?: VisitSource;
  action?: string;
  goods?: number;
  termimal?: string;
  streamItemId?: number;
}

export class InfoItemVisitData implements IInfoItemVisitData {
  constructor(
    public id?: number,
    public userId?: string,
    public deviceNo?: string,
    public date?: Date,
    public source?: VisitSource,
    public action?: string,
    public goods?: number,
    public termimal?: string,
    public streamItemId?: number
  ) {}
}
