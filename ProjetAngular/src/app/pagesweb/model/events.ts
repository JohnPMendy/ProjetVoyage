import { Reponses } from './reponses';

export class Events {
  public get reponses(): Reponses[] | undefined {
    return this._reponses;
  }
  public set reponses(value: Reponses[] | undefined) {
    this._reponses = value;
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
    private _reponses?: Reponses[]
  ) {}
}
