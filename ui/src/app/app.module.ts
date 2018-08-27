import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FundService } from './api/service/fund.service';

import { AppRouting } from './app.routing';
import { MatGridListModule } from '@angular/material/grid-list';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {
  MatCardModule,
  MatButtonModule,
  MatTableModule,
  MatDialogModule,
  MatFormFieldModule,
  MatInputModule,
  MatSelectModule,
  MatIconModule
} from '@angular/material';

import { AppComponent } from './main/app.component';
import { FundComponent } from './fund/fund.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FundItemsComponent } from './fund-items/fund-items.component';
import { ItemFundModalComponent } from './modals/item-fund-modal/item-fund-modal.component';
import { ConvertToHigherNominalPipe } from './pipes/convertToHigherNominal.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FundComponent,
    DashboardComponent,
    FundItemsComponent,
    ItemFundModalComponent,
    ConvertToHigherNominalPipe
  ],
  imports: [
    BrowserModule,
    AppRouting,
    BrowserAnimationsModule,
    MatCardModule,
    MatGridListModule,
    MatButtonModule,
    MatTableModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatIconModule,
    HttpClientModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [
    ItemFundModalComponent
  ],
  providers: [FundService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
