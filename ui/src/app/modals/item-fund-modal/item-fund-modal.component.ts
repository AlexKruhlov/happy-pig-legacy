import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Item } from '../../models/item';

@Component({
  selector: 'item-fund-modal',
  templateUrl: './item-fund-modal.component.html',
  styleUrls: ['./item-fund-modal.component.scss']
})
export class ItemFundModalComponent {
  typeOption: Array<any> = [
    {value: 'INCOME', viewValue: 'INCOME'},
    {value: 'EXPENSE', viewValue: 'EXPENSE'}
  ];
  isEdit: boolean = true;

  constructor(
    public dialogRef: MatDialogRef<ItemFundModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  onNoClick(): void {
    this.dialogRef.close();
    this.removeItem();
  }

  removeItem(): void {
    this.data.item.amount = null;
    this.data.item.type = null;
    this.isEdit = true;
  }

  changeFund(): any {
    this.addItem();
    return this.data.fund;
  }

  addItem(): any {
    if (this.isNewItem()) {
      return this.data.fund.items.push(this.data.item);
    }
    this.updateExistedItem();
  }

  updateExistedItem(): void {
    this.data.fund.items = this.mapItems();
  }

  mapItems(): Array<Item> {
    return this.data.fund.items.map(item => item.id === this.data.item.id ? this.data.item : item);
  }

  isNewItem(): boolean {
    return this.data.item.id === null;
  }

  onConvertToPennies( value: any ): void {
    this.isEdit = false;
    this.data.item.amount = value * 100;
  }
}
