import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Inventaire } from './../model/inventaire';

@Injectable({
  providedIn: 'root',
})
export class inventaireService {
  private number: number | undefined;
  private static URL = 'http://localhost:8080/voyages/api/inventaire';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Inventaire[]> {
    return this.httpClient.get<Inventaire[]>(inventaireService.URL);
  }

  public getById(id: number): Observable<Inventaire> {
    return this.httpClient.get<Inventaire>(`${inventaireService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${inventaireService.URL}/${id}`);
  }

  public update(inventaire: Inventaire): Observable<Inventaire> {
    return this.httpClient.put<Inventaire>(
      `${inventaireService.URL}/${inventaire.id}`,
      this.objetToJson(inventaire)
    );
  }

  public objetToJson(inventaire: Inventaire) {
    let obj = {
      id: inventaire.id,
      objets: inventaire.objets,
      partie: inventaire.partie,
    };

    console.log(obj);
    return obj;
  }

  public create(inventaire: Inventaire): Observable<Inventaire> {
    return this.httpClient.post<Inventaire>(
      inventaireService.URL,
      this.objetToJson(inventaire)
    );
  }
}
