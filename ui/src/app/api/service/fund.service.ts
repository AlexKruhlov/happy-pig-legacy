import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { URL } from '../requestPath';
import { Fund } from '../../models/fund';
import { Product } from '../../models/product';
import { Item } from '../../models/item';
import { Unit } from '../../models/unit';
import { ProductPosition } from '../../models/productPosition';

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

  findAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${URL}/product/all`);
  }

  findProductPositionBy( productId: string ): Observable<ProductPosition[]> {
    return this.http.get<ProductPosition[]>(`${URL}/prodposition/find/product/${productId}`);
  }

  findAllUnits(): Observable<Unit[]> {
    return this.http.get<Unit[]>(`${URL}/unit/all`);
  }

  deleteFund(fundId): Observable<Fund[]> {
    return this.http.get<Fund[]>(`${URL}/fund/delete/${fundId}`);
  }

  update(fund: Fund): Observable<Fund> {
     return this.http.post<Fund>(`${URL}/fund/update`, fund);
  }

  deleteItem(itemId: string, fundId: string): Observable<Fund> {
    return this.http.post<Fund>(`${URL}/item/deleteAndFindFund`, {itemId, fundId});
  }

  create(fund: any): void {
    this.http.post(`${URL}/fund/create`, fund)
      .subscribe(res => {
        this.saveFundsToSubject(res);
      });
  }

  saveFundsToSubject(res): void {
    this.subject.next({ fund: res });
  }

  saveProductPosition( productPosition: ProductPosition ): Observable<ProductPosition> {
    return this.http.post<ProductPosition>(`${URL}/prodposition/save`, productPosition);
  }

  saveAndFindFund(item: Item): Observable<Fund>  {
    return this.http.post<Fund>(`${URL}/item/saveAndFindFund`, item);
  }

  getNew(): Observable<any> {
    return this.subject.asObservable();
  }
}
