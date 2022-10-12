import { Boutique } from './../model/boutique';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Objet } from '../model/objet';
import { ObjetService } from './objet.service';

@Injectable({
  providedIn: 'root'
})
export class BoutiqueService {

  private static URL = 'http://localhost:8080/voyages/api/boutique';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Boutique[]> {
    return this.httpClient.get<Boutique[]>(BoutiqueService.URL);
  }

  public getById(id: number): Observable<Boutique> {
    return this.httpClient.get<Boutique>(`${BoutiqueService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${BoutiqueService.URL}/${id}`);
  }

  public update(boutique: Boutique): Observable<Boutique> {
    return this.httpClient.put<Boutique>(
      `${BoutiqueService.URL}/${boutique.id}`,
      this.objetToJson(boutique)
    );
  }

  public objetToJson(boutique: Boutique) {
    let obj = {
      id: boutique.id,
      nom: boutique.nom,
      objets : boutique.objets,
      typeBoutique : boutique.typeBoutique
    };

    console.log(obj);
    return obj;
  }

  public create(boutique: Boutique): Observable<Boutique> {
    return this.httpClient.post<Boutique>(
      BoutiqueService.URL,
      this.objetToJson(boutique)
    );
  }
}
