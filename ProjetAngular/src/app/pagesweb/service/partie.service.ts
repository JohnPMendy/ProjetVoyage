import { Partie } from './../../pagesweb/model/partie';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PartieService {
  private static URL = 'http://localhost:8080/voyages/api/partie';
  private static _partie: Partie;

  public static get partie(): Partie {
    return PartieService._partie;
  }
  public static set partie(value: Partie) {
    PartieService._partie = value;
  }

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Partie[]> {
    return this.httpClient.get<Partie[]>(PartieService.URL);
  }

  public findById(id: number): Observable<Partie> {
    return this.httpClient.get<Partie>(PartieService.URL + '/' + id);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(PartieService.URL + '/' + id);
  }

  public partieToJson(partie: Partie): any {
    let obj = {
      id: partie.id,
      date: partie.date,
      compte:partie.compte,
      inventaire:partie.inventaire,
      eventRunning : partie.eventRunning,
      personnage:partie.personnage,
      environnement:partie.environment
    };

    console.log(obj)
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

  public sendCharge(id: number) {
    this.findById(id).subscribe((data) => (PartieService._partie = data));
  }

  public recieveCharge(partie: Partie) {
    partie = PartieService._partie;
  }

  public sauvegarde(partie: Partie) {
    if (partie.id) {
      this.update(partie).subscribe((data) => {});
    } else {
      this.create(partie).subscribe((data) => {});
    }
  }
}
