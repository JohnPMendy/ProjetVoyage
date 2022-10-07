import { environment } from './../../../environments/environment';
import { Environnement } from './../model/environnement';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EnvironnementService {
  private static URL = 'http://localhost:8080/voyages/api/environnement';

  constructor(private httpClient: HttpClient) {}

  public EnvToJson(environment: Environnement): any {
    let obj = {
      id: environment.id,
      nom: environment.nom,
      temperature: environment.temperature,
      meteo: environment.meteo,
      environnement: environment.TypeEnv,
    };
    return obj;
  }

  public findById(id: number): Observable<Environnement> {
    return this.httpClient.get<Environnement>(
      EnvironnementService.URL + '/' + id
    );
  }

  public create(environment: Environnement): Observable<Environnement> {
    return this.httpClient.post<Environnement>(
      EnvironnementService.URL,
      this.EnvToJson(environment)
    );
  }

  public update(environment: Environnement): Observable<Environnement> {
    return this.httpClient.put<Environnement>(
      EnvironnementService.URL + '/' + environment.id,
      this.EnvToJson(environment)
    );
  }
}
