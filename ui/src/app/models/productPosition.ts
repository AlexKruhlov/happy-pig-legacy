import { Product } from './product';

export class ProductPosition {

  constructor( readonly  id: string = null,
               readonly  specification: string = null,
               readonly  product: Product = new Product()
  ) {}
}
