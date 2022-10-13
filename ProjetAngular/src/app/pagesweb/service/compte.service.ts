import { Compte } from './../model/compte';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  private static URL = 'http://localhost:8080/voyages/api/compte';

  constructor(private httpCLient: HttpClient) {}

  public getByIdWithParties(id: number): Observable<Compte> {
    return this.httpCLient.get<Compte>(
      CompteService.URL + '/' + id + '/parties'
    );
  }

  public objetToJson(compte:Compte) {
    let obj = {
      id: compte.id,
      login: compte.login,
      mdp:compte.mdp,
      role:compte.role,
      parties:compte.parties ,

    };

    console.log(obj);
    return obj;
  }

  public create(compte:Compte): Observable<Compte> {
    return this.httpCLient.post<Compte>(
      CompteService.URL,
      this.objetToJson(compte)
    );
  }

  public getAll(): Observable<Compte[]> {
    return this.httpCLient.get<Compte[]>(CompteService.URL);
  }
}
