export interface IAuthorFavourData {
  id?: number;
  userId?: number;
  createDate?: Date;
  authorId?: number;
}

export class AuthorFavourData implements IAuthorFavourData {
  constructor(public id?: number, public userId?: number, public createDate?: Date, public authorId?: number) {}
}
