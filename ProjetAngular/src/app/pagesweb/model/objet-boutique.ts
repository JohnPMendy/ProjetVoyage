import { Boutique } from './boutique';
export class ObjetBoutique {
  public get quantiteBoutique(): number|undefined  {
    return this._quantiteBoutique;
  }
  public set quantiteBoutique(value: number|undefined ) {
    this._quantiteBoutique = value;
  }
  public get objet(): Object |undefined {
    return this._objet;
  }
  public set objet(value: Object|undefined ) {
    this._objet = value;
  }
  public get boutique(): Boutique|undefined  {
    return this._boutique;
  }
  public set boutique(value: Boutique|undefined ) {
    this._boutique = value;
  }



  constructor(
    private _id?: number,
    private _boutique?: Boutique,
    private _objet?: Object,
    private _quantiteBoutique?: number
    ){}
}
