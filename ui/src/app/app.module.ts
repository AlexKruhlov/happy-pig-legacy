import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FundService } from './api/service/fund.service';

import { AppRouting } from './app.routing';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule} from '@angular/material/table';

import { AppComponent } from './main/app.component';
import { FundComponent } from './fund/fund.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FundItemsComponent } from './fund-items/fund-items.component';

@NgModule({
  declarations: [
    AppComponent,
    FundComponent,
    DashboardComponent,
    FundItemsComponent
  ],
  imports: [
    BrowserModule,
    AppRouting,
    BrowserAnimationsModule,
    MatCardModule,
    MatGridListModule,
    MatButtonModule,
    MatTableModule,
    HttpClientModule,
    FlexLayoutModule
  ],
  providers: [FundService],
  bootstrap: [AppComponent]
})
export class AppModule { }
