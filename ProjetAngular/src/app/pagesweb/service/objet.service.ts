import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Objet } from '../model/objet';

@Injectable({
  providedIn: 'root',
})
export class ObjetService {
  private static URL = 'http://localhost:8080/eshop/api/objet';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Objet[]> {
    return this.httpClient.get<Objet[]>(ObjetService.URL);
  }

  public getById(id: number): Observable<Objet> {
    return this.httpClient.get<Objet>(`${ObjetService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ObjetService.URL}/${id}`);
  }

  public update(objet: Objet): Observable<Objet> {
    return this.httpClient.put<Objet>(
      `${ObjetService.URL}/${objet.id}`,
      this.objetToJson(objet)
    );
  }

  public objetToJson(objet: Objet) {
    let obj = {
      id: objet.id,
      nom: objet.nom,
      typeObjetAlimentaire:objet.typeObjetAlimetaire,
      prix:objet.prix,
      typeObjets:objet.typeObjets
    };

    console.log(obj);
    return obj;
  }

  public create(objet: Objet): Observable<Objet> {
    return this.httpClient.post<Objet>(
      ObjetService.URL,
      this.objetToJson(objet)
    );
  }
}
