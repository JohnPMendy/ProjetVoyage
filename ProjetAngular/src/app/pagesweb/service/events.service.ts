import { Events } from './../model/events';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EventsService {
  private static URL = 'http://localhost:8080/voyages/api/events';

  constructor(private httpClient: HttpClient) {}

  public EnvToJson(events: Events): any {
    let obj = {
      id: events.id,
      histoire: events.histoire,
      reponses: events.reponses,
    };
    return obj;
  }

  public findById(id: number): Observable<Events> {
    return this.httpClient.get<Events>(EventsService.URL + '/' + id);
  }
}
