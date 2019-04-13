import { Unit } from './unit';
export class Product {

  constructor(public id: string = null,
              public name: string = null,
              public defaultUnit: Unit = null,
  ) {}
}
