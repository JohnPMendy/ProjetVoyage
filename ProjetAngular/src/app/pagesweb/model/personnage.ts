import { Competence } from "./competence";

export class Personnage {
  public get id(): number |undefined{
    return this._id;
  }
  public set id(value: number |undefined) {
    this._id = value;
  }
  public get competences(): Competence[] |undefined{
    return this._competences;
  }
  public set competences(value: Competence[]|undefined) {
    this._competences = value;
  }
  public get humeur(): string |undefined{
    return this._humeur;
  }
  public set humeur(value: string|undefined) {
    this._humeur = value;
  }
  public get isAlive(): boolean|undefined {
    return this._isAlive;
  }
  public set isAlive(value: boolean|undefined) {
    this._isAlive = value;
  }
  public get isCovided(): boolean|undefined{
    return this._isCovided;
  }
  public set isCovided(value: boolean|undefined) {
    this._isCovided = value;
  }
  public get force(): number|undefined {
    return this._force;
  }
  public set force(value: number|undefined) {
    this._force = value;
  }
  public get faim(): number|undefined {
    return this._faim;
  }
  public set faim(value: number|undefined) {
    this._faim = value;
  }
  public get energie(): number|undefined{
    return this._energie;
  }
  public set energie(value: number|undefined) {
    this._energie = value;
  }
  public get argent(): number |undefined{
    return this._argent;
  }
  public set argent(value: number|undefined) {
    this._argent = value;
  }
  public get poids(): number |undefined{
    return this._poids;
  }
  public set poids(value: number|undefined) {
    this._poids = value;
  }
  public get prenom(): string |undefined{
    return this._prenom;
  }
  public set prenom(value: string|undefined) {
    this._prenom = value;
  }
  public get nom(): string|undefined {
    return this._nom;
  }
  public set nom(value: string|undefined) {
    this._nom = value;
  }

  constructor (private _id?: number,
              private _nom?: string,
              private _prenom?: string,
              private _poids?: number,
              private _argent?: number,
              private _energie?: number,
              private _faim?: number,
              private _force?: number,
              private _isCovided?: boolean,
              private _isAlive?: boolean,
              private _humeur?: string,
              private _competences?: Competence[]
              ){}
}
