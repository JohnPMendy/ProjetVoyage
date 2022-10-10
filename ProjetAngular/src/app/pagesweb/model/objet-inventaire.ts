import { Inventaire } from "./inventaire";

export class ObjetInventaire {

  public get quantiteinventaire(): number|undefined  {
    return this._quantiteinventaire;
  }
  public set quantiteinventaire(value: number|undefined ) {
    this._quantiteinventaire = value;
  }
  public get objet(): Object |undefined {
    return this._objet;
  }
  public set objet(value: Object|undefined ) {
    this._objet = value;
  }
  public get inventaire(): Inventaire|undefined  {
    return this._inventaire;
  }
  public set inventaire(value: Inventaire|undefined ) {
    this._inventaire = value;
  }



  constructor(
    private _id?: number,
    private _inventaire?: inventaire,
    private _objet?: Object,
    private _quantiteinventaire?: number
    ){}
}


