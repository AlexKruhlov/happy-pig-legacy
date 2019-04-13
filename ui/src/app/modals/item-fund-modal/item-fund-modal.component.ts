import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatSelectChange, MatDialog } from '@angular/material';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ItemService } from '../../api/service/item.service';
import { Product } from '../../models/product';
import { Unit } from '../../models/unit';
import { ProductPosition } from '../../models/productPosition';
import { ConvertToHigherNominalPipe } from '../../pipes/convertToHigherNominal.pipe';
import { ProductModalComponent } from '../product-modal/product-modal.component';
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
  products: Array<Product>;
  units: Array<Unit>;
  productPositions: Array<ProductPosition>;
  specifications: Array<string>;
  itemForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<ItemFundModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private itemService: ItemService,
    private dialog: MatDialog) {
    this.findProducts();
    this.findUnits();
    this.initForm(this.data.item);
    if (this.data.item.id) {
      this.findProductPositionBy(this.data.item.productPosition.product.id);
    }
  }

  findProducts(): void {
    this.itemService.findAllProducts().subscribe(allProducts => this.products = allProducts);
  }

  findUnits(): void {
    this.itemService.findAllUnits().subscribe(unitList => this.units = unitList);
  }

  initForm(item: Item): void {
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
    this.isSpecificationExist() ? this.updateProdPosition(this.itemForm.value.specification) :
      this.createProdPosition(this.itemForm.value.specification, this.findProduct(this.itemForm.value.product));
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

  findUnit = (unitName: string): Unit => this.units.find(unit => unit.name === unitName);

  changeProduct = (event: MatSelectChange): void => this.findProductPositionBy(this.findProduct(event.value).id);

  findProductPositionBy(id: string): void {
    this.itemService.findProductPositionBy(id).subscribe(productPositionList => this.setValueFromProductPositionList(productPositionList));
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

  createProdPosition(specification: string, product: Product): void {
    const newProductPosition = new ProductPosition(null, specification, product);
    this.itemService.saveProductPosition(newProductPosition).subscribe(productPosition => {
      this.data.item.productPositionId = productPosition.id;
    });
  }

  addProduct(): void {
    const dialogRef = this.dialog.open(ProductModalComponent, {
      width: '600px',
      maxWidth: '95%'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) { this.createProduct(result); }
    });
  }

  createProduct(newProduct: FormGroup): void {
    const product = new Product(null, newProduct.value.productName, this.findUnit(newProduct.value.unit));
    this.itemService.saveProduct(product).subscribe(prod => this.addNewProduct(prod, newProduct.value.specification));
  }

  addNewProduct(product: Product, specification: string): void {
    this.findProducts();
    this.createProdPosition(specification, product);
    this.itemForm.controls['product'].setValue(product.name);
    this.itemForm.controls['specification'].setValue(specification);
    this.itemForm.controls['unit'].setValue(product.defaultUnit.name);
  }
}
