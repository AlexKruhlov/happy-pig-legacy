import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertToHigherNominal'
})
export class ConvertToHigherNominalPipe implements PipeTransform {
  transform = (value: number | string): number => value ?  Number(value) / 100 : null;
}
