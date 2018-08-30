import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { URL } from '../requestPath';
import { Fund } from '../../models/fund';

@Injectable({
  providedIn: 'root'
})
export class FundService {

  private subject = new Subject<any>();

  constructor( private http: HttpClient ) {
  }

  getAll(): Observable<Fund[]> {
    return this.http.get<Fund[]>(`${URL}/fund/all`);
  }

  getById( id: string ): Observable<Fund> {
    return this.http.get<Fund>(`${URL}/fund/${id}`);
  }

  save(fund: Fund): Observable<Fund> {
     return this.http.post<Fund>(`${URL}/fund/save`, fund);
  }

  deleteItem(itemId: string, fundId: string): Observable<Fund> {
    return this.http.post<Fund>(`${URL}/item/delete`, {itemId, fundId});
  }

  saveNew(fund: any): void {
    this.http.post(`${URL}/fund/save`, fund)
      .subscribe(res => {
        this.update(res);
      });
  }

  update(res): void {
    this.subject.next({ fund: res });
  }

  getNew(): Observable<any> {
    return this.subject.asObservable();
  }
}
