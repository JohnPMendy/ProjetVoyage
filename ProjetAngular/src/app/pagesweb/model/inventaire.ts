import { ObjetInventaire } from './objet-inventaire';
import { Partie } from './partie';
export class Inventaire {
  public get partie(): Partie|undefined {
    return this._partie;
  }
  public set partie(value: Partie|undefined ) {
    this._partie = value;
  }
  public get objets(): ObjetInventaire[]|undefined {
    return this._objets;
  }
  public set objets(value: ObjetInventaire[]|undefined) {
    this._objets = value;
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
              private _objets?: ObjetInventaire[],
              private _partie?: Partie
              ){}
}
