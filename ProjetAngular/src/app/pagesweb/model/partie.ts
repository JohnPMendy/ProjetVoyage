import { Personnage } from './personnage';
import { Inventaire } from './inventaire';
import { Events } from './events';
import { Environnement } from './environnement';
import { Compte } from './compte';
export class Partie {
  public get personnage(): Personnage | undefined {
    return this._personnage;
  }
  public set personnage(value: Personnage | undefined) {
    this._personnage = value;
  }
  public get date(): Date | undefined {
    return this._date;
  }
  public set date(value: Date | undefined) {
    this._date = value;
  }
  public get inventaire(): Inventaire | undefined {
    return this._inventaire;
  }
  public set inventaire(value: Inventaire | undefined) {
    this._inventaire = value;
  }
  public get eventRunning(): Events | undefined {
    return this._eventRunning;
  }
  public set eventRunning(value: Events | undefined) {
    this._eventRunning = value;
  }
  public get environment(): Environnement | undefined {
    return this._environment;
  }
  public set environment(value: Environnement | undefined) {
    this._environment = value;
  }
  public get compte(): Compte | undefined {
    return this._compte;
  }
  public set compte(value: Compte | undefined) {
    this._compte = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _compte?: Compte,
    private _environment?: Environnement,
    private _eventRunning?: Events,
    private _inventaire?: Inventaire,
    private _personnage?: Personnage,
    private _date?: Date
  ) {}
}
