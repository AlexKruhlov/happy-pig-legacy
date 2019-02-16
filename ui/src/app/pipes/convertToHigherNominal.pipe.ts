import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertToHigherNominal'
})
export class ConvertToHigherNominalPipe implements PipeTransform {
  transform = (value: number): number => value ?  value / 100 : null;
}
