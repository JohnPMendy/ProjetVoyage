import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reponses } from '../model/reponses';

@Injectable({
  providedIn: 'root',
})
export class ReponsesService {
  private static URL = 'http://localhost:8080/voyages/api/reponses';

  constructor(private httpClient: HttpClient) {}

  public EnvToJson(reponses: Reponses): any {
    let obj = {
      id: reponses.id,
      texte: reponses.texte,
      prochainEvenementId: reponses.prochainEvenementId,
    };
    return obj;
  }

  public findById(id: number): Observable<Reponses[]> {
    return this.httpClient.get<Reponses[]>(ReponsesService.URL + '/' + id);
  }
}
