import {Fund} from './fund';

export class Statistic {
  funds: Fund[];
  total: string;

  constructor(funds: Fund[] = null, total: string = null) {
    this.funds = funds;
    this.total = total;
  }
}
