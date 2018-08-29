import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'new-fund',
  templateUrl: './new-fund.component.html',
  styleUrls: ['./new-fund.component.scss']
})
export class NewFundComponent {

  constructor(
    public dialogRef: MatDialogRef<NewFundComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
