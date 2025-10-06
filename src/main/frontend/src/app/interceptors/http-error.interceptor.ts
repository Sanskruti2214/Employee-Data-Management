import { inject } from '@angular/core';
import { HttpInterceptorFn, HttpErrorResponse } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';

export const httpErrorInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      let msg = 'An unknown error occurred';

      if (error.error instanceof ErrorEvent) {
        // Client-side error
        msg = `Client error: ${error.error.message}`;
      } else {
        // Server-side error
        if (error.error && error.error.message) {
          msg = error.error.message; // from backend global exception handler
        } else if (typeof error.error === 'string') {
          msg = error.error; // plain text response
        } else {
          msg = error.statusText || msg;
        }
      }

      console.error('[HTTP Error Interceptor]', error);
      alert(msg); // ✅ Instead of Toastr

      return throwError(() => new Error(msg));
    })
  );
};

