export class Item {
  id: string;
  type: string;
  amount: string;
  date: string;
  fundId: string;

  constructor( fundId: string = null,
               amount: string = null,
               type: string = null,
               date: string = null,
               id: string = null ) {
    this.id = id;
    this.type = type;
    this.amount = amount;
    this.date = date;
    this.fundId = fundId;
  }
}
