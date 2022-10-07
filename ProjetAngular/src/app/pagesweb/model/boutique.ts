import { ObjetBoutique } from './objet-boutique';
export class Boutique {
  public get objets(): ObjetBoutique[]|undefined {
    return this._objets;
  }
  public set objets(value: ObjetBoutique[]|undefined) {
    this._objets = value;
  }
  public get typeBoutique(): string|undefined {
    return this._typeBoutique;
  }
  public set typeBoutique(value: string |undefined) {
    this._typeBoutique = value;
  }
  public get nom(): string|undefined {
    return this._nom;
  }
  public set nom(value: string |undefined) {
    this._nom = value;
  }
  public get id(): number|undefined {
    return this._id;
  }
  public set id(value: number|undefined) {
    this._id = value;
  }


  constructor(private _id?: number,
              private _nom?: string,
              private _typeBoutique?: string,
              private _objets?: ObjetBoutique[] ){}
}
