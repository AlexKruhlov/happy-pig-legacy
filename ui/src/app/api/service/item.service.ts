import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { URL } from '../requestPath';
import { Fund } from '../../models/fund';
import { Product } from '../../models/product';
import { Unit } from '../../models/unit';
import { ProductPosition } from '../../models/productPosition';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor( private http: HttpClient ) {
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

  delete(itemId: string, fundId: string): Observable<Fund> {
    return this.http.post<Fund>(`${URL}/item/deleteAndFindFund`, {itemId, fundId});
  }

  saveProductPosition( productPosition: ProductPosition ): Observable<ProductPosition> {
    return this.http.post<ProductPosition>(`${URL}/prodposition/save`, productPosition);
  }

  saveProduct( product: Product ): Observable<Product> {
    return this.http.post<Product>(`${URL}/product/create`, product);
  }
}
