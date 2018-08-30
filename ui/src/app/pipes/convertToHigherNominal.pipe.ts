import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertToHigherNominal'
})
export class ConvertToHigherNominalPipe implements PipeTransform {
  transform(value: any, args?: any): number {
    if (value === null) {
      return 0;
    }
    return value / 100;
  }
}
