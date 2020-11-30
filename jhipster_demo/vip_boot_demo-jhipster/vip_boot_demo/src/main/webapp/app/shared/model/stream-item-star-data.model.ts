export interface IStreamItemStarData {
  id?: number;
  userId?: number;
  createDate?: Date;
  type?: number;
  itemId?: string;
  replayId?: string;
  valid?: boolean;
  starType?: number;
}

export class StreamItemStarData implements IStreamItemStarData {
  constructor(
    public id?: number,
    public userId?: number,
    public createDate?: Date,
    public type?: number,
    public itemId?: string,
    public replayId?: string,
    public valid?: boolean,
    public starType?: number
  ) {
    this.valid = this.valid || false;
  }
}
