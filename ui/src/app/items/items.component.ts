import { Component, OnInit, OnDestroy } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { FundService } from '../api/service/fund.service';
import { ItemFundModalComponent } from '../modals/item-fund-modal/item-fund-modal.component';
import { ConfirmModalComponent } from '../modals/confirm-modal/confirm-modal.component';
import { Item } from '../models/item';
import { Fund } from '../models/fund';

@Component({
  selector: 'items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit, OnDestroy {
  fund: Fund;
  sub: any;
  displayedColumns: string[] = ['position', 'type', 'amount', 'date', 'action'];
  emptyItem: Item;

  constructor(
    private route: ActivatedRoute,
    private fundService: FundService,
    public dialog: MatDialog) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.getFund(params['id']);
    });
  }

  getFund( id: string ): void {
    this.fundService.getById(id).subscribe(res => {
      this.fund = res;
      this.emptyItem = new Item(res.id);
    });
  }

  openDialog( item: any, title: string ): void {
    const dialogRef = this.dialog.open(ItemFundModalComponent, {
      width: '650px',
      data: {fund: {...this.fund}, item: {...item}, modalTitle: title}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.updateFund(result);
      }
    });
  }

  updateFund( newFund: any ): void {
    this.fundService.update(newFund).subscribe(res => {
      this.fund = {...res};
    });
  }

  onDeleteItem( fund ) {
    this.openConfirmationDialog(fund);
  }

  openConfirmationDialog( fund ) {
    const dialogRef = this.dialog.open(ConfirmModalComponent, {
      width: '450px',
      data: {title: 'Item'}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.removeItem(fund);
      }
    });
  }

  removeItem( fund ) {
    this.fundService.deleteItem(fund.id, fund.fundId).subscribe(res => {
      this.fund = {...res};
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
