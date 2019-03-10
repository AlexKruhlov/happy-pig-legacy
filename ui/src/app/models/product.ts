import { Unit } from './unit';
export class Product {

  constructor(readonly id: string = null,
              readonly name: string = null,
              readonly defaultUnit: Unit = null,
  ) {}
}
