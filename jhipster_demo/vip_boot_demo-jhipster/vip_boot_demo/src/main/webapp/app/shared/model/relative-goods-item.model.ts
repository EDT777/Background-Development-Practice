export interface IRelativeGoodsItem {
  id?: number;
  platform?: string;
  url?: string;
  itemId?: string;
  translated?: boolean;
  translatedUrl?: string;
  mainImage?: string;
  smallImages?: string;
  title?: string;
  shopName?: string;
  sellCount?: number;
  price?: number;
  zkPrice?: number;
  commssion?: number;
  commssionRate?: number;
  description?: string;
  coupon?: number;
  streamItemId?: number;
  infoStreamItemId?: number;
}

export class RelativeGoodsItem implements IRelativeGoodsItem {
  constructor(
    public id?: number,
    public platform?: string,
    public url?: string,
    public itemId?: string,
    public translated?: boolean,
    public translatedUrl?: string,
    public mainImage?: string,
    public smallImages?: string,
    public title?: string,
    public shopName?: string,
    public sellCount?: number,
    public price?: number,
    public zkPrice?: number,
    public commssion?: number,
    public commssionRate?: number,
    public description?: string,
    public coupon?: number,
    public streamItemId?: number,
    public infoStreamItemId?: number
  ) {
    this.translated = this.translated || false;
  }
}
