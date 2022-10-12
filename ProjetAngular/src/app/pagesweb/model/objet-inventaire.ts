import { Inventaire } from './inventaire';
import { Objet } from './objet';

export class ObjetInventaire {
  public get objet(): Objet | undefined {
    return this._objet;
  }
  public set objet(value: Objet | undefined) {
    this._objet = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  public get quantiteInventaire(): number | undefined {
    return this._quantiteInventaire;
  }
  public set quantiteInventaire(value: number | undefined) {
    this._quantiteInventaire = value;
  }
  public get inventaire(): Inventaire | undefined {
    return this._inventaire;
  }
  public set inventaire(value: Inventaire | undefined) {
    this._inventaire = value;
  }

  constructor(
    private _id?: number,
    private _inventaire?: Inventaire,
    private _objet?: Objet,
    private _quantiteInventaire?: number
  ) {}
}
