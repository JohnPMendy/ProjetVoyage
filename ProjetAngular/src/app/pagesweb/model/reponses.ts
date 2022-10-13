import { Environnement } from './environnement';
import { Events } from './events';
import { Objet } from './objet';
export class Reponses {
  public get ajoutCovid(): number | undefined {
    return this._ajoutCovid;
  }
  public set ajoutCovid(value: number | undefined) {
    this._ajoutCovid = value;
  }
  public get conditionCovid(): boolean | undefined {
    return this._conditionCovid;
  }
  public set conditionCovid(value: boolean | undefined) {
    this._conditionCovid = value;
  }
  public get conditionFaim(): number | undefined {
    return this._conditionFaim;
  }
  public set conditionFaim(value: number | undefined) {
    this._conditionFaim = value;
  }
  public get ajoutFaim(): number | undefined {
    return this._ajoutFaim;
  }
  public set ajoutFaim(value: number | undefined) {
    this._ajoutFaim = value;
  }
  public get conditionObjet(): number | undefined {
    return this._conditionObjet;
  }
  public set conditionObjet(value: number | undefined) {
    this._conditionObjet = value;
  }
  public get conditionForce(): number | undefined {
    return this._conditionForce;
  }
  public set conditionForce(value: number | undefined) {
    this._conditionForce = value;
  }
  public get conditionEnergie(): number | undefined {
    return this._conditionEnergie;
  }
  public set conditionEnergie(value: number | undefined) {
    this._conditionEnergie = value;
  }
  public get conditionArgent(): number | undefined {
    return this._conditionArgent;
  }
  public set conditionArgent(value: number | undefined) {
    this._conditionArgent = value;
  }
  public get conditionPoids(): number | undefined {
    return this._conditionPoids;
  }
  public set conditionPoids(value: number | undefined) {
    this._conditionPoids = value;
  }
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
    private _ajoutFaim?: number,
    private _isAlive?: boolean,
    private _environnement?: Environnement,
    private _objet?: Objet,
    private _conditionPoids?: number,
    private _conditionArgent?: number,
    private _conditionEnergie?: number,
    private _conditionForce?: number,
    private _conditionCovid?: boolean,
    private _conditionObjet?: number,
    private _conditionFaim?: number
  ) {}
}
