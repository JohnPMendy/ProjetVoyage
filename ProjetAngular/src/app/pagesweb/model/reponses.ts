import { Environnement } from './environnement';
import { Events } from './events';
import { Objet } from './objet';
export class Reponses {
  public get objet(): Objet | undefined {
    return this._objet;
  }
  public set objetId(value: Objet | undefined) {
    this._objet = value;
  }
  public get environnement(): Environnement | undefined {
    return this._environnement;
  }
  public set environnement(value: Environnement | undefined) {
    this._environnement = value;
  }
  public get isAlive(): boolean | undefined {
    return this._isAlive;
  }
  public set isAlive(value: boolean | undefined) {
    this._isAlive = value;
  }
  public get ajoutCovid(): number | undefined {
    return this._ajoutCovid;
  }
  public set ajoutCovid(value: number | undefined) {
    this._ajoutCovid = value;
  }
  public get ajoutForce(): number | undefined {
    return this._ajoutForce;
  }
  public set ajoutForce(value: number | undefined) {
    this._ajoutForce = value;
  }
  public get ajoutEnergie(): number | undefined {
    return this._ajoutEnergie;
  }
  public set ajoutEnergie(value: number | undefined) {
    this._ajoutEnergie = value;
  }
  public get ajoutArgent(): number | undefined {
    return this._ajoutArgent;
  }
  public set ajoutArgent(value: number | undefined) {
    this._ajoutArgent = value;
  }
  public get ajoutPoids(): number | undefined {
    return this._ajoutPoids;
  }
  public set ajoutPoids(value: number | undefined) {
    this._ajoutPoids = value;
  }
  public get prochainEvenementId(): Events | undefined {
    return this._prochainEvenementId;
  }
  public set prochainEvenementId(value: Events | undefined) {
    this._prochainEvenementId = value;
  }
  public get texte(): string | undefined {
    return this._texte;
  }
  public set texte(value: string | undefined) {
    this._texte = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }

  constructor(
    private _id?: number,
    private _texte?: string,
    private _prochainEvenementId?: Events,
    private _ajoutPoids?: number,
    private _ajoutArgent?: number,
    private _ajoutEnergie?: number,
    private _ajoutForce?: number,
    private _ajoutCovid?: number,
    private _isAlive?: boolean,
    private _environnement?: Environnement,
    private _objet?: Objet
  ) {}
}
