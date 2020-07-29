import { Injectable } from '@angular/core';

import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Rental } from './rental.model';

const baseUrl = environment.url + "/rental";
@Injectable({
  providedIn: 'root'
})
export class RentalService {
  
  constructor(
    private http: HttpClient) { }

  getAll(): Observable<Rental[]> {
    return this.http.get<Rental[]>(baseUrl + '/all')
    .pipe(
      catchError(this.handleError<Rental[]>(baseUrl + '/all', []))
    );
  }

  add(rental: Rental) {
    return this.http.post<Rental>(baseUrl + '/add', rental)
    .pipe(
      catchError(this.handleError<Rental>('addRental'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
