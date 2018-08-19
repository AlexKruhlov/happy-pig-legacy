import { Component, OnInit } from '@angular/core';
import { FundService } from '../api/service/fund.service';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements OnInit {
  funds: any;

  constructor( private fundService: FundService ) {
  }

  ngOnInit() {
    this.getAllFunds();
  }

  getAllFunds() {
    this.fundService.getAllFunds().subscribe(res => {
      this.funds = res;
    });
  }
}
