export class Environnement {
  public get TypeEnv(): string | undefined {
    return this._TypeEnv;
  }
  public set TypeEnv(value: string | undefined) {
    this._TypeEnv = value;
  }
  public get meteo(): string | undefined {
    return this._meteo;
  }
  public set meteo(value: string | undefined) {
    this._meteo = value;
  }
  public get temperature(): number | undefined {
    return this._temperature;
  }
  public set temperature(value: number | undefined) {
    this._temperature = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _nom?: string,
    private _temperature?: number,
    private _meteo?: string,
    private _TypeEnv?: string
  ) {}
}
