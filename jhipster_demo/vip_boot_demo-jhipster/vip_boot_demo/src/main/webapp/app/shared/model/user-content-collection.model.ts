export interface IUserContentCollection {
  id?: number;
  userId?: number;
  platform?: string;
  link?: string;
  createDate?: Date;
  pctUrl?: string;
  valid?: boolean;
}

export class UserContentCollection implements IUserContentCollection {
  constructor(
    public id?: number,
    public userId?: number,
    public platform?: string,
    public link?: string,
    public createDate?: Date,
    public pctUrl?: string,
    public valid?: boolean
  ) {
    this.valid = this.valid || false;
  }
}
