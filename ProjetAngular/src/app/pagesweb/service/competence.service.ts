import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Competence } from '../model/competence';

@Injectable({
  providedIn: 'root'
})
export class CompetenceService {
  private static URL='http://localhost:8080/voyages/api/competence';

  constructor(private httpClient:HttpClient) { }

  public getAll(): Observable<Competence[]>{
    return this.httpClient.get<Competence[]>(CompetenceService.URL);
  }

  public getById(id:number):Observable<Competence>{
    return this.httpClient.get<Competence>(CompetenceService.URL+'/'+id);
  }

  public getByNom(nom:string):Observable<Competence>{
    return this.httpClient.get<Competence>(CompetenceService.URL+'/name/'+nom);
  }
  public delete(id:number):Observable<void>{
    return this.httpClient.delete<void>(CompetenceService.URL+'/'+id);
  }

  public update(competence:Competence):Observable<Competence>{
    return this.httpClient.put<Competence>(CompetenceService+'/'+competence.id,this.competenceToJson(competence));
  }

  public competenceToJson(competence:Competence){
    let obj={
      id: competence.id,
      nom: competence.nom,
      description: competence.description
    };
    console.log(obj);
    return obj;
  }
  public create(competence:Competence):Observable<Competence>{
    return this.httpClient.post<Competence>(CompetenceService.URL,this.competenceToJson);
    }
  }

