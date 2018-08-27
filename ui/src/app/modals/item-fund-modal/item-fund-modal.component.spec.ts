import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemFundModalComponent } from './item-fund-modal.component';

describe('ItemFundModalComponent', () => {
  let component: ItemFundModalComponent;
  let fixture: ComponentFixture<ItemFundModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemFundModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemFundModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
