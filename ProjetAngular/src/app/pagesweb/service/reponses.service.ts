import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reponses } from '../model/reponses';

@Injectable({
  providedIn: 'root',
})
export class ReponsesService {
  private static URL = 'http://localhost:8080/voyages/api/reponses';

  constructor(private httpClient: HttpClient) {}

  public EnvToJson(reponses: Reponses): any {
    let obj = {
      id: reponses.id,
      texte: reponses.texte,
      prochainEvenementId: reponses.prochainEvenementId,
      ajoutPoids: reponses.ajoutPoids,
      ajoutFaim: reponses.ajoutFaim,
      ajoutArgent: reponses.ajoutArgent,
      ajoutEnergie: reponses.ajoutEnergie,
      ajoutForce: reponses.ajoutForce,
      ajoutCovid: reponses.ajoutCovid,
      isAlive: reponses.ajoutCovid,
      objetId: {
        id: reponses.objetId?.id,
        nom: reponses.objetId?.nom,
        typeObjetAlimentaire: reponses.objetId?.typeObjetAlimetaire,
        prix: reponses.objetId?.prix,
        typeObjets: reponses.objetId?.typeObjets,
      },
      conditionPoids: reponses.conditionPoids,
      conditionArgent: reponses.conditionArgent,
      conditionEnergie: reponses.conditionEnergie,
      conditionForce: reponses.conditionForce,
      conditionCovid: reponses.conditionCovid,
      conditionObjet: reponses.conditionObjet,
      conditionFaim: reponses.conditionFaim,
    };
    return obj;
  }

  public findById(id: number): Observable<Reponses[]> {
    return this.httpClient.get<Reponses[]>(ReponsesService.URL + '/' + id);
  }
}
