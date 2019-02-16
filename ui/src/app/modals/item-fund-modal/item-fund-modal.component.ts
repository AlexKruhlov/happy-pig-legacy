import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { FundService } from '../../api/service/fund.service';
import { Product } from '../../models/product';
import { Unit } from '../../models/unit';
import { ConvertToHigherNominalPipe } from '../../pipes/convertToHigherNominal.pipe';

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
  units: Unit[];
  itemForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<ItemFundModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private fundService: FundService) {
    this.findProducts();
    this.findUnits();
    this.initForm();
  }

  findProducts(): void {
    this.fundService.findAllProducts().subscribe(allProducts => this.products = allProducts);
  }

  findUnits(): void {
    this.fundService.findAllUnits().subscribe(unitList => this.units = unitList);
  }

  initForm(): void {
    this.itemForm = new FormGroup({
      product: new FormControl(this.data.item.product.name, Validators.required),
      cost: new FormControl(new ConvertToHigherNominalPipe().transform(this.data.item.cost), Validators.required),
      amount: new FormControl(this.data.item.amount, Validators.required),
      unit: new FormControl(this.data.item.product.unit.name, Validators.required),
      type: new FormControl(this.data.item.type, Validators.required),
      specification: new FormControl( this.data.item.product.specification, Validators.required),
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
    this.data.item.product = this.findProduct(this.itemForm.value.product);
    this.fillData();
    return this.data.item;
  }

  fillData(): void {
    this.data.item.cost = this.itemForm.value.cost * 100;
    this.data.item.amount = this.itemForm.value.amount;
    this.data.item.type = this.itemForm.value.type;
    this.data.item.product.unit = this.findUnit(this.itemForm.value.unit);
    this.data.item.product.specification = this.itemForm.value.specification;
  }

  findProduct = (productName): any => this.products.find(product => product.name === productName);

  findUnit = (unitName): any => this.units.find(unit => unit.name === unitName);
}
