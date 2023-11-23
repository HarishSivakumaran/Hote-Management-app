import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpResponse,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import {catchError, map} from 'rxjs/operators';


import { UserContext } from '../services/usercontext.service';
import { HttpStatusCode } from 'axios';
import { Router } from '@angular/router';
@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor(public auth: UserContext, private router: Router) {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(this.auth.isLoggedIn())
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${this.auth.getToken()}`
        }
      });
    return next.handle(request)
    .pipe(catchError((event: HttpErrorResponse) : Observable<any> => {
      if (event instanceof HttpErrorResponse && event.status === HttpStatusCode.Forbidden) {
        this.router.navigate(['auth']);
      }
      return throwError(event);
  }));
  }
}
