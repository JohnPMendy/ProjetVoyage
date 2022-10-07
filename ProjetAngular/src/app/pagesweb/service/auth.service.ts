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
    return this.router.parseUrl('/login?auth=false');
  }

  public authentication(login: string, password: string): Observable<any> {
    //definition d'un header avec l'entree Authorization qui va contenir la chaine :Basic XXXXX (chaine crypte pour l'authentification)
    let monHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(`${login}:${password}`),
    });

    return this.httpClient.get('http://localhost:8080/eshop/api/auth', {
      headers: monHeaders,
    });
  }
}
