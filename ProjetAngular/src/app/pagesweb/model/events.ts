import { Environnement } from './environnement';
export class Events {
  public get environnement(): Environnement | undefined {
    return this._environnement;
  }
  public set environnement(value: Environnement | undefined) {
    this._environnement = value;
  }
  public get histoire(): string | undefined {
    return this._histoire;
  }
  public set histoire(value: string | undefined) {
    this._histoire = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _histoire?: string,
    private _environnement?: Environnement
  ) {}
}
