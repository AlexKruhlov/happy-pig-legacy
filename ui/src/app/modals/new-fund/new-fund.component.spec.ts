import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewFundComponent } from './new-fund.component';

describe('NewFundComponent', () => {
  let component: NewFundComponent;
  let fixture: ComponentFixture<NewFundComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewFundComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewFundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
