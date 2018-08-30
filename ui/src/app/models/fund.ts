import { Item } from './item';

export class Fund {
  id: string;
  name: string;
  amount?: string;
  income?: string;
  expense?: string;
  items: Array<Item>;

  constructor( name: string = null,
               items: Array<Item> = null,
               id: string = null ) {
    this.id = id;
    this.name = name;
    this.items = items;
  }
}
