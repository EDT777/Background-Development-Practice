export interface IReply {
  id?: number;
  title?: string;
  content?: string;
  auditStatus?: boolean;
  createData?: Date;
  auditDate?: Date;
  createUser?: string;
  auditUser?: number;
  replyUserId?: number;
  replyUserNickName?: string;
  delFlag?: boolean;
  replyToId?: number;
  itemId?: number;
}

export class Reply implements IReply {
  constructor(
    public id?: number,
    public title?: string,
    public content?: string,
    public auditStatus?: boolean,
    public createData?: Date,
    public auditDate?: Date,
    public createUser?: string,
    public auditUser?: number,
    public replyUserId?: number,
    public replyUserNickName?: string,
    public delFlag?: boolean,
    public replyToId?: number,
    public itemId?: number
  ) {
    this.auditStatus = this.auditStatus || false;
    this.delFlag = this.delFlag || false;
  }
}
