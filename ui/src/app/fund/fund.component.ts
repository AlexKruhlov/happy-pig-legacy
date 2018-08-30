import { Component, OnInit, Input } from '@angular/core';
import {Fund} from '../models/fund';

@Component({
  selector: 'fund',
  templateUrl: './fund.component.html',
  styleUrls: ['./fund.component.scss']
})
export class FundComponent implements OnInit {
  @Input() fund: Fund;

  constructor() {
  }

  ngOnInit() {
  }
}
