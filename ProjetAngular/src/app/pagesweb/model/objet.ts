export class Objet {
  public get typeObjets(): string|undefined {
    return this._typeObjets;
  }
  public set typeObjets(value: string|undefined) {
    this._typeObjets = value;
  }
  public get prix(): number |undefined{
    return this._prix;
  }
  public set prix(value: number|undefined) {
    this._prix = value;
  }
  public get typeObjetAlimetaire(): boolean |undefined{
    return this._typeObjetAlimetaire;
  }
  public set typeObjetAlimetaire(value: boolean|undefined) {
    this._typeObjetAlimetaire = value;
  }
  public get nom(): string |undefined{
    return this._nom;
  }
  public set nom(value: string|undefined) {
    this._nom = value;
  }
  public get id(): number |undefined{
    return this._id;
  }
  public set id(value: number|undefined) {
    this._id = value;
  }

  constructor(
      private _id?: number,
      private _nom?: string,
      private _typeObjetAlimetaire?: boolean,
      private _prix?: number,
      private _typeObjets?: string
  ){}
}
