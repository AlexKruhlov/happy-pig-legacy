import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'found',
  templateUrl: './fund.component.html',
  styleUrls: ['./fund.component.scss']
})
export class FundComponent implements OnInit {
  @Input() fund: any;

  constructor() {
  }

  ngOnInit() {
  }
}
