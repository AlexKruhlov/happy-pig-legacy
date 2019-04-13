import { Component, OnInit, OnDestroy } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { FundService } from '../api/service/fund.service';
import { ItemService } from '../api/service/item.service';
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
  displayedColumns: string[] = ['position', 'type', 'product', 'cost', 'amount', 'unit', 'date', 'action'];
  emptyItem: Item;

  constructor(
    private route: ActivatedRoute,
    private fundService: FundService,
    private itemService: ItemService,
    public dialog: MatDialog) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => this.getFund(params['id']));
  }

  getFund( id: string ): void {
    this.fundService.getById(id).subscribe(res => {
      this.fund = res;
      this.emptyItem = new Item(res.id);
    });
  }

  openDialog( item: Item, title: string ): void {
    const dialogRef = this.dialog.open(ItemFundModalComponent, {
      width: '700px',
      maxWidth: '95%',
      data: {item: {...item}, modalTitle: title}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.updateFund(result);
      }
    });
  }

  updateFund( item: Item ): void {
    this.fundService.saveAndFindFund(item).subscribe(res => this.fund = {...res});
  }

  onDeleteItem = ( item: Item ) => this.openConfirmationDialog(item);

  openConfirmationDialog( item ) {
    const dialogRef = this.dialog.open(ConfirmModalComponent, {
      width: '450px',
      data: {title: 'Item'}
    });

    this.afterClosedConfirmDialog(dialogRef, item);
  }

  afterClosedConfirmDialog (modal, item: Item) {
    modal.afterClosed().subscribe(result => {
      if (result) { this.removeItem(item); }
    });
  }

  removeItem( item: Item ) {
    this.itemService.delete(item.id, item.fundId).subscribe(res => this.fund = {...res});
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
