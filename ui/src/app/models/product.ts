import { Unit } from './unit';
export class Product {

  constructor(readonly id: string = null,
              readonly name: string = null,
              readonly unit: Unit = new Unit(),
              readonly specification: string = null,
  ) {}
}
