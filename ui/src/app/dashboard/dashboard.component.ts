import { Component, OnInit } from '@angular/core';
import { FundService } from '../service/fund.service';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements OnInit {
  constructor( private fundService: FundService ) {
  }

  ngOnInit() {
  }
}
