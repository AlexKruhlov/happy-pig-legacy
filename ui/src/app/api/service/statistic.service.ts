import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";
import { URL } from '../requestPath';
import { Statistic } from '../../models/statistic';

@Injectable({
  providedIn: 'root'
})
export class StatisticService {

  constructor( private http: HttpClient ) { }

  createStatistic(): Observable<Statistic> {
    return this.http.get<Statistic>(`${URL}/statistic/create`);
  }
}
