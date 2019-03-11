import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Unit } from '../../models/unit';
import { ItemService } from '../../api/service/item.service';

@Component({
  selector: 'app-product-modal',
  templateUrl: './product-modal.component.html',
  styleUrls: []
})
export class ProductModalComponent {
  productForm: FormGroup;
  units: Array<Unit>;
  constructor(
    private dialogRef: MatDialogRef<ProductModalComponent>,
    private itemService: ItemService) {
    this.initForm();
    this.findUnits();
  }

  initForm(): void {
    this.productForm = new FormGroup({
      productName: new FormControl('', Validators.required),
      unit: new FormControl('', Validators.required),
      specification: new FormControl('', Validators.required),
    });
  }

  findUnits(): void {
    this.itemService.findAllUnits().subscribe(unitList => this.units = unitList);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
