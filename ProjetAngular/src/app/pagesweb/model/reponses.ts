import { Events } from './events';
export class Reponses {
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
    private _prochainEvenementId?: Events
  ) {}
}
