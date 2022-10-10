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

  public findById(id: number): Observable<Partie> {
    return this.httpClient.get<Partie>(PartieService.URL + '/' + id);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(PartieService + '/' + id);
  }
}
