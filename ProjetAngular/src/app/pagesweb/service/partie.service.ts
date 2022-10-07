import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PartieService {
  private static URL = 'http://localhost:8080/voyages/api/partie';

  constructor(private httpClient: HttpClient) {}
}
