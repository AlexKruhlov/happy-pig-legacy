import { Directive, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[onlyNumber]'
})
export class OnlyNumberDirective {

  constructor() { }

  @Input() onlyNumber: boolean;

  @HostListener('keydown', ['$event']) onKeyDown(event) {
    if (this.onlyNumber) {
      const charCode = (event.which) ? event.which : event.keyCode;
      return charCode > 31 && (charCode < 48 || charCode > 57) ? false : true;
    }
  }
}
