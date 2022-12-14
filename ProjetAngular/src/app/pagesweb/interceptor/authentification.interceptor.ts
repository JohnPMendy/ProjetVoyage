import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../service/auth.service';

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {
  constructor(private authenticationService: AuthService) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    if (this.authenticationService.isAuthenticated()) {
      request = request.clone({
        headers: request.headers.append(
          'Authorization',
          sessionStorage.getItem('token')!
        ),
      });
    }
    return next.handle(request);
  }
}
