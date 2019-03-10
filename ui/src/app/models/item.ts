import { ProductPosition } from './productPosition';
import { Unit } from './unit';

export class Item {

  constructor( readonly  fundId: string = null,
               readonly  amount: string = null,
               readonly  cost: string = null,
               readonly  type: string = null,
               readonly  date: string = null,
               readonly  comment: string = null,
               readonly  productPositionId: string = null,
               readonly unit: Unit = new Unit(),
               readonly  productPosition: ProductPosition = new ProductPosition(),
               readonly  id: string = null ) {}
}
