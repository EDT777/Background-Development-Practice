export const enum ItemResourceType {
  VIDEO = 'VIDEO',
  AUDIO = 'AUDIO',
  IMAGE = 'IMAGE',
  ARTICAL = 'ARTICAL',
  ACTIVITY = 'ACTIVITY',
  SINGLE_PRODUCT = 'SINGLE_PRODUCT',
  COVER = 'COVER',
  OTHER = 'OTHER'
}

export interface IResourceItem {
  id?: number;
  type?: ItemResourceType;
  platform?: string;
  resourceId?: string;
  transcodeStatus?: boolean;
  uploadStatus?: boolean;
  updateDate?: Date;
  auditStatus?: boolean;
  auditDate?: Date;
  auditInfo?: string;
  fileSize?: number;
  contentSize?: number;
  source?: string;
  url?: string;
  urlExpire?: number;
  params?: string;
  auditUser?: number;
  delFlag?: boolean;
  infoStreamItemId?: number;
}

export class ResourceItem implements IResourceItem {
  constructor(
    public id?: number,
    public type?: ItemResourceType,
    public platform?: string,
    public resourceId?: string,
    public transcodeStatus?: boolean,
    public uploadStatus?: boolean,
    public updateDate?: Date,
    public auditStatus?: boolean,
    public auditDate?: Date,
    public auditInfo?: string,
    public fileSize?: number,
    public contentSize?: number,
    public source?: string,
    public url?: string,
    public urlExpire?: number,
    public params?: string,
    public auditUser?: number,
    public delFlag?: boolean,
    public infoStreamItemId?: number
  ) {
    this.transcodeStatus = this.transcodeStatus || false;
    this.uploadStatus = this.uploadStatus || false;
    this.auditStatus = this.auditStatus || false;
    this.delFlag = this.delFlag || false;
  }
}
