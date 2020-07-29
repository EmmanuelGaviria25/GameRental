import { Injectable } from '@angular/core';

import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Game } from './game.model';

const baseUrl = environment.url + "/game";
@Injectable({
  providedIn: 'root'
})
export class GameService {
  
  constructor(
    private http: HttpClient) { }

  getAll(): Observable<Game[]> {
    return this.http.get<Game[]>(baseUrl + '/all')
    .pipe(
      catchError(this.handleError<Game[]>(baseUrl + '/all', []))
    );
  }

  add(game: Game) {
    return this.http.post<Game>(baseUrl + '/add', game)
    .pipe(
      catchError(this.handleError<Game>('addGame'))
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
