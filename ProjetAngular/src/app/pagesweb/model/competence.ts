export class Competence {
  public get description(): string |undefined {
    return this._description;
  }
  public set description(value: string |undefined) {
    this._description = value;
  }
  public get nom(): string |undefined {
    return this._nom;
  }
  public set nom(value: string |undefined) {
    this._nom = value;
  }
  public get id(): number |undefined{
    return this._id;
  }
  public set id(value: number|undefined) {
    this._id = value;
  }

  constructor(private _id?: number, private _nom?: string,private _description?: string){}
}
