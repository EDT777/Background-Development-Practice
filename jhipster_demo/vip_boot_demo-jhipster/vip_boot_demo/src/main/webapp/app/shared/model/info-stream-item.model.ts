import { IResourceItem } from '@/shared/model/resource-item.model';
import { IRelativeGoodsItem } from '@/shared/model/relative-goods-item.model';

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

export interface IInfoStreamItem {
  id?: number;
  title?: string;
  type?: string;
  digist?: string;
  content?: string;
  createUser?: string;
  lastUpdateDate?: Date;
  updateUser?: string;
  createDate?: Date;
  tags?: string;
  contentType?: ItemResourceType;
  resources?: IResourceItem[];
  covers?: IResourceItem[];
  goods?: IRelativeGoodsItem[];
  authorId?: number;
}

export class InfoStreamItem implements IInfoStreamItem {
  constructor(
    public id?: number,
    public title?: string,
    public type?: string,
    public digist?: string,
    public content?: string,
    public createUser?: string,
    public lastUpdateDate?: Date,
    public updateUser?: string,
    public createDate?: Date,
    public tags?: string,
    public contentType?: ItemResourceType,
    public resources?: IResourceItem[],
    public covers?: IResourceItem[],
    public goods?: IRelativeGoodsItem[],
    public authorId?: number
  ) {}
}
