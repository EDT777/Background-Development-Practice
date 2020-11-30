export interface IAuthor {
  id?: number;
  name?: string;
  pct?: string;
  valid?: boolean;
  createDate?: Date;
  level?: number;
}

export class Author implements IAuthor {
  constructor(
    public id?: number,
    public name?: string,
    public pct?: string,
    public valid?: boolean,
    public createDate?: Date,
    public level?: number
  ) {
    this.valid = this.valid || false;
  }
}
