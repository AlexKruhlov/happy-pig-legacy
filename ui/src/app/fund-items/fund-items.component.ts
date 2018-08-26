import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FundService } from '../api/service/fund.service';

@Component({
  selector: 'fund-items',
  templateUrl: './fund-items.component.html',
  styleUrls: ['./fund-items.component.scss']
})
export class FundItemsComponent implements OnInit, OnDestroy {
  fund: any;
  sub: any;
  displayedColumns: string[] = ['position', 'type', 'amount', 'date', 'action'];

  constructor(
    private route: ActivatedRoute,
    private fundService: FundService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.getFund(params['id']);
    });
  }

  getFund(id) {
    this.fundService.getFundById(id).subscribe(res => {
      this.fund = res;
    });
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
