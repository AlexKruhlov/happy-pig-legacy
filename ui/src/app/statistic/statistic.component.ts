import { Component, OnInit } from '@angular/core';
import { StatisticService } from '../api/service/statistic.service';
import { Statistic } from '../models/statistic';

@Component({
  selector: 'app-statistic',
  templateUrl: './statistic.component.html',
  styleUrls: ['./statistic.component.scss']
})
export class StatisticComponent implements OnInit {

  statistic: Statistic;
  displayedColumns: string[] = ['position', 'name', 'date', 'income', 'expense', 'amount'];

  constructor( private  statisticService: StatisticService ) {}

  ngOnInit() {
    this.getStatistic();
  }

  getStatistic(): void {
    this.statisticService.createStatistic().subscribe(res => this.statistic = res);
  }

  hasBalanceProfitable(element) {
   return parseInt(element.income, 10) >= parseInt(element.expense, 10);
  }

}
