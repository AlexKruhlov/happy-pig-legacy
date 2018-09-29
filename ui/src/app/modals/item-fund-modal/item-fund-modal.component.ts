import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Item } from '../../models/item';
import { FundService } from '../../api/service/fund.service';
import { Product } from '../../models/product';

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
  products: Product[];

  constructor(
    public dialogRef: MatDialogRef<ItemFundModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private fundService: FundService) {
    this.fundService.findAllProducts().subscribe(allProducts => {
      this.products = allProducts;
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
    this.removeItem();
  }

  removeItem(): void {
    this.data.item.amount = null;
    this.data.item.type = null;
  }

  changeFund(): any {
    this.data.item.product = this.addProduct();
    return this.data.item;
  }


  addProduct(): any {
    return this.products.find(product => product.name === this.data.item.product.name);
  }

  onConvertToPennies( value: any ): void {
    if (value) {
      this.data.item.amount = value * 100;
    }
  }
}
