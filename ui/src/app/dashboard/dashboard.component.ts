import { Component, OnInit, OnDestroy } from '@angular/core';
import { FundService } from '../api/service/fund.service';
import { Fund } from '../models/fund';
import { Subscription } from 'rxjs';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements OnInit, OnDestroy {
  funds: Array<Fund>;
  subscription: Subscription;

  constructor( private fundService: FundService ) {
    this.subscription = this.fundService.getNew().subscribe(res => {
      this.funds.push(res.fund);
    });
  }

  ngOnInit() {
    this.getAllFunds();
  }

  getAllFunds() {
    this.fundService.getAll().subscribe(res => {
      this.funds = res;
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
