export class Item {
  id: string;
  type: string;
  amount: string;
  date: string;
  fundId: string;

  constructor( fundId: string,
               amount: string = null,
               type: string = null,
               date: string = '2018-08-27T11:08:36.742931',
               id: string = null ) {
    this.id = id;
    this.type = type;
    this.amount = amount;
    this.date = date;
    this.fundId = fundId;
  }
}
