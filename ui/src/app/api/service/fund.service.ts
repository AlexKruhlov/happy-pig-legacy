import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { URL } from '../requestPath';


@Injectable({
  providedIn: 'root'
})
export class FundService {

  private subject = new Subject<any>();

  constructor( private http: HttpClient ) {
  }

  getAll(): Observable<any> {
    return this.http.get(`${URL}/fund/all`);
  }

  getById( id ): Observable<any> {
    return this.http.get(`${URL}/fund/${id}`);
  }

  save(fund: any) {
     return this.http.post(`${URL}/fund/save`, fund);
  }

  saveNew(fund: any) {
    this.http.post(`${URL}/fund/save`, fund)
      .subscribe(res => {
        this.update(res);
      });
  }

  update(res) {
    this.subject.next({ fund: res });
  }

  getNew(): Observable<any> {
    return this.subject.asObservable();
  }
}
