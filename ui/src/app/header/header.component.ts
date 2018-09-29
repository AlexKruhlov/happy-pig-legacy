import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { NewFundComponent } from '../modals/new-fund/new-fund.component';
import { FundService } from '../api/service/fund.service';
import { Fund } from '../models/fund';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  fund: Fund = new Fund();

  constructor( public dialog: MatDialog,
               private fundService: FundService) {
  }

  ngOnInit() {
  }

  openDialog() {
    const dialogRef = this.dialog.open(NewFundComponent, {
      width: '650px',
      data: {fund: this.fund}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.addFund(result);
      }
    });
  }

  addFund( newFund: any ): void {
    this.fundService.create(newFund);
  }

}
