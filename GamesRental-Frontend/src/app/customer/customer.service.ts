import { Injectable } from '@angular/core';

import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Customer } from './customer.model';

const baseUrl = environment.url + "/customer";
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
  constructor(
    private http: HttpClient) { }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(baseUrl + '/all')
    .pipe(
      catchError(this.handleError<Customer[]>(baseUrl + '/all', []))
    );
  }

  add(customer: Customer) {
    return this.http.post<Customer>(baseUrl + '/add', customer)
    .pipe(
      catchError(this.handleError<Customer>('addCustomer'))
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
