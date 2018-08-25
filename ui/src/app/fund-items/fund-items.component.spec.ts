import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundItemsComponent } from './fund-items.component';

describe('FundItemsComponent', () => {
  let component: FundItemsComponent;
  let fixture: ComponentFixture<FundItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
