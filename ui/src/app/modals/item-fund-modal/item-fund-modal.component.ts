import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatSelectChange } from '@angular/material';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { FundService } from '../../api/service/fund.service';
import { Product } from '../../models/product';
import { Unit } from '../../models/unit';
import { ProductPosition } from '../../models/productPosition';
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
  products: Array<Product>;
  units: Array<Unit>;
  productPositions: Array<ProductPosition>;
  specifications: Array<string>;
  itemForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<ItemFundModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private fundService: FundService) {
    this.findProducts();
    this.findUnits();
    this.initForm(this.data.item);
    if (this.data.item.id) {
      this.findProductPositionBy(this.data.item.productPosition.product.id);
    }
  }

  findProducts(): void {
    this.fundService.findAllProducts().subscribe(allProducts => this.products = allProducts);
  }

  findUnits(): void {
    this.fundService.findAllUnits().subscribe(unitList => this.units = unitList);
  }

  initForm(item): void {
    this.itemForm = new FormGroup({
      product: new FormControl(item.productPosition.product.name, Validators.required),
      cost: new FormControl(new ConvertToHigherNominalPipe().transform(item.cost), Validators.required),
      amount: new FormControl(item.amount, Validators.required),
      unit: new FormControl(item.unit.name, Validators.required),
      type: new FormControl(item.type, Validators.required),
      comment: new FormControl(item.comment),
      specification: new FormControl(item.productPosition.specification, Validators.required),
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
    this.fillData();
    return this.data.item;
  }

  fillData(): void {
    this.setProductPositionToData();
    this.setInitFormValueToData();
  }

  setProductPositionToData(): void {
    this.data.item.productPosition = null;
    this.isSpecificationExist() ? this.updateProdPosition(this.itemForm.value.specification) : this.createProdPosition();
  }

  setInitFormValueToData(): void {
    this.data.item.cost = this.itemForm.value.cost * 100;
    this.data.item.amount = this.itemForm.value.amount;
    this.data.item.type = this.itemForm.value.type;
    this.data.item.comment = this.itemForm.value.comment;
    this.data.item.unit = this.findUnit(this.itemForm.value.unit);
  }

  findProduct = (productName: string): Product => this.products.find(product => product.name === productName);

  updateProdPosition(specification: string): void {
    this.data.item.productPositionId = this.productPositions.find(position => position.specification === specification).id;
  }

  isSpecificationExist(): boolean {
    return this.specifications.some(specification => specification === this.itemForm.value.specification);
  }

  findUnit = (unitName: string): any => this.units.find(unit => unit.name === unitName);

  changeProduct = (event: MatSelectChange): void => this.findProductPositionBy(this.findProduct(event.value).id);

  findProductPositionBy(id: string): void {
    this.fundService.findProductPositionBy(id).subscribe(productPositionList => this.setValueFromProductPositionList(productPositionList));
  }

  setValueFromProductPositionList(productPositionList: Array<ProductPosition>): void {
    if (productPositionList.length) {
      this.setProductPositionsAndSpecifications(productPositionList);
      this.setDefaultValueToInitForm(productPositionList[0]);
    }
  }

  setProductPositionsAndSpecifications(productPositionList: Array<ProductPosition>): void {
    this.productPositions = productPositionList;
    this.specifications = this.filteredSpecifications(productPositionList);
  }

  setDefaultValueToInitForm(productPosition: ProductPosition): void {
    if (!this.data.item.id) {
      this.itemForm.controls['unit'].setValue(productPosition.product.defaultUnit.name);
      this.itemForm.controls['specification'].setValue(productPosition.specification);
    }
  }

  filteredSpecifications(productPositionList: ProductPosition[]): Array<string> {
    return productPositionList.map(value => value.specification ? value.specification : null);
  }

  createProdPosition() {
    const newProductPosition = new ProductPosition(null, this.itemForm.value.specification, this.findProduct(this.itemForm.value.product));
    this.fundService.saveProductPosition(newProductPosition).subscribe(productPosition => {
      this.data.item.productPositionId = productPosition.id;
    });
  }
}
