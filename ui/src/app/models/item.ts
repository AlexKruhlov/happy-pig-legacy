import { ProductPosition } from './productPosition';
import { Unit } from './unit';

export class Item {

  constructor( public  fundId: string = null,
               public  amount: string = null,
               public  cost: string = null,
               public  type: string = null,
               public  date: string = null,
               public  comment: string = null,
               public  productPositionId: string = null,
               public  unit: Unit = new Unit(),
               public  productPosition: ProductPosition = new ProductPosition(),
               public  id: string = null ) {}
}
