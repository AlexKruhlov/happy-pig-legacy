import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { URL } from '../requestPath';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FundService {

  constructor( private http: HttpClient ) {
  }

  getAll(): Observable<any> {
    return this.http.get(`${URL}/fund/all`);
  }

  getById( id ): Observable<any> {
    return this.http.get(`${URL}/fund/${id}`);
  }

  save(fund: any): Observable<any> {
    return this.http.post(`${URL}/fund/save`, fund);
  }
}
