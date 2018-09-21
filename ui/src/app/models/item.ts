import { Product } from "./product";

export class Item {
  id: string;
  type: string;
  amount: string;
  date: string;
  fundId: string;
  product: Product;

  constructor( fundId: string = null,
               amount: string = null,
               type: string = null,
               date: string = null,
               product = null,
               id: string = null ) {
    this.id = id;
    this.type = type;
    this.amount = amount;
    this.date = date;
    this.fundId = fundId;
    this.product = product;
  }
}
