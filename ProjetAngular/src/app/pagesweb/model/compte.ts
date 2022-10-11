import { Partie } from './partie';
export class Compte {
  public get parties(): Partie[] | undefined {
    return this._parties;
  }
  public set parties(value: Partie[] | undefined) {
    this._parties = value;
  }
  public get role(): string | undefined {
    return this._role;
  }
  public set role(value: string | undefined) {
    this._role = value;
  }
  public get login(): string | undefined {
    return this._login;
  }
  public set login(value: string | undefined) {
    this._login = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _login?: string,
    private _role?: string,
    private _parties?: Partie[]
  ) {}
}
