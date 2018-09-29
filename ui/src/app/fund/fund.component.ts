import { Component, OnInit, Input } from '@angular/core';
import {Fund} from '../models/fund';
import {ConfirmModalComponent} from "../modals/confirm-modal/confirm-modal.component";
import {MatDialog} from '@angular/material';
import {FundService} from '../api/service/fund.service';

@Component({
  selector: 'fund',
  templateUrl: './fund.component.html',
  styleUrls: ['./fund.component.scss']
})
export class FundComponent implements OnInit {
  @Input() fund: Fund;

  constructor(private fundService: FundService,
              public dialog: MatDialog) {
  }

  ngOnInit() {}

  deleteFund(event) {
    event.stopPropagation();
    this.openConfirmationDialog();
  }

  openConfirmationDialog() {
    const dialogRef = this.dialog.open(ConfirmModalComponent, {
      width: '450px',
      data: {title: `${this.fund.name} Fund`}
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.removeFund();
      }
    });
  }

  removeFund(){
    this.fundService.deleteFund(this.fund.id).subscribe(res => {
      this.fundService.saveFundsToSubject(res);
    });
  }
}
