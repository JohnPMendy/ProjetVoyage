import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Events } from './../model/events';
import { Reponses } from './../model/reponses';

@Injectable({
  providedIn: 'root',
})
export class EventsService {
  private static URL = 'http://localhost:8080/voyages/api/events';

  constructor(private httpClient: HttpClient) {}

  public EnvToJson(events: Events, reponses: Reponses): any {
    let obj = {
      id: events.id,
      histoire: events.histoire,
      environnementId: {
        id: events.environnementId?.id,
        temperature: events.environnementId?.temperature,
        meteo: events.environnementId?.meteo,
        environnement: events.environnementId?.environnement,
      },
    };
    return obj;
  }

  public findById(id: number): Observable<Events> {
    return this.httpClient.get<Events>(EventsService.URL + '/' + id);
  }
}
