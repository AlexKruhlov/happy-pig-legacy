import { Product } from './product';

export class Item {

  constructor( readonly  fundId: string = null,
               readonly  amount: string = null,
               readonly  cost: string = null,
               readonly  type: string = null,
               readonly  date: string = null,
               readonly product: Product = new Product(),
               readonly id: string = null ) {}
}
