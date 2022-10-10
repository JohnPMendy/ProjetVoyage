import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {
  Router,
  ActivatedRouteSnapshot,
  CanActivate,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService implements CanActivate {
  constructor(private httpClient: HttpClient, private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | boolean
    | UrlTree
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree> {
    if (sessionStorage.getItem('token')) {
      return true;
    }
    return this.router.parseUrl('/connection?auth=false');
  }

  public authentication(login: string, password: string): Observable<any> {
    //definition d'un header avec l'entree Authorization qui va contenir la chaine :Basic XXXXX (chaine crypte pour l'authentification)
    let monHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(`${login}:${password}`),
    });

    return this.httpClient.get('http://localhost:8080/voyages/api/auth', {
      headers: monHeaders,
    });
  }

  public isAuthenticated(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }

  public logout() {
    sessionStorage.clear();
  }

  public isAdmin(): boolean {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).role == 'ROLE_ADMIN';
    }
    return false;
  }
}
