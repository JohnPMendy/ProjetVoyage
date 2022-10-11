import { Partie } from './../../pagesweb/model/partie';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PartieService {
  private static URL = 'http://localhost:8080/voyages/api/partie';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Partie[]> {
    return this.httpClient.get<Partie[]>(PartieService.URL);
  }

  public findById(id: number): Observable<Partie> {
    return this.httpClient.get<Partie>(PartieService.URL + '/' + id);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(PartieService + '/' + id);
  }

  public findAllByCompteId(id: number): Observable<Partie[]> {
    return this.httpClient.get<Partie[]>(PartieService.URL + '/compte/' + id);
  }

  public partieToJson(partie: Partie): any {
    let obj = {
      id: partie.id,
      date: partie.date,
    };
    if (partie.compte) {
      Object.assign(obj, { compte: { id: partie.compte?.id } });
    }
    if (partie.inventaire) {
      Object.assign(obj, { inventaire: { id: partie.inventaire?.id } });
    }
    if (partie.eventRunning) {
      Object.assign(obj, { eventRunning: { id: partie.eventRunning?.id } });
    }
    if (partie.personnage) {
      Object.assign(obj, { personnage: { id: partie.personnage?.id } });
    }
    if (partie.environment) {
      Object.assign(obj, { environment: { id: partie.environment?.id } });
    }
    return obj;
  }
  public create(partie: Partie): Observable<Partie> {
    return this.httpClient.post<Partie>(
      PartieService.URL,
      this.partieToJson(partie)
    );
  }

  public update(partie: Partie): Observable<Partie> {
    return this.httpClient.put<Partie>(
      `${PartieService.URL}/${partie.id}`,
      this.partieToJson(partie)
    );
  }
}
