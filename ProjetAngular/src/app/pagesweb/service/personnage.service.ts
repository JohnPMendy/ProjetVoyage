import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Personnage } from '../model/personnage';

@Injectable({
  providedIn: 'root'
})
export class PersonnageService {
  private static URL ='http://localhost:8080/voyages/api/personnage';

  constructor(private httpClient:HttpClient) {
  }

  public getAll():Observable<Personnage[]>{
      return this.httpClient.get<Personnage[]>(PersonnageService.URL);
  }

  public getById(id:number):Observable<Personnage>{
    return this.httpClient.get<Personnage>(PersonnageService.URL+'/'+id);
  }
  public delete(id:number):Observable<void>{
    return this.httpClient.delete<void>(PersonnageService.URL+'/'+id);
  }
  public update(personnage:Personnage):Observable<Personnage>{
    return this.httpClient.put<Personnage>(PersonnageService.URL+'/'+personnage.id,this.personnageToJson(personnage));
  }
  public personnageToJson(personnage:Personnage){
    let obj={
      id:personnage.id,
      nom:personnage.nom,
      prenom:personnage.prenom,
      poids:personnage.poids,
      argent:personnage.argent,
      energie:personnage.energie,
      faim:personnage.faim,
      force:personnage.force,
      isCovided:personnage.isCovided,
      isAlive:personnage.isAlive,
      humeur:personnage.humeur,
      competences:personnage.competences

    };

    console.log(obj);
    return obj;
  }
}
