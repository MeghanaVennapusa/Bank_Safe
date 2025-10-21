// import { Component } from '@angular/core';
// import { FormGroup, FormBuilder, Validators } from '@angular/forms';
// import { of } from 'rxjs';
// import { Customer } from '../../types/Customer';

// @Component({
//   selector: 'app-customerarray',
//   standalone: true,
//   imports: [],
//   templateUrl: './customerarray.component.html',
//   styleUrls: ['./customerarray.component.css']
// })
// export class CustomerarrayComponent {
  
// }
import { Component } from '@angular/core';
import { CustomerTS } from '../../types/tstypes/Customerts';

@Component({
  selector: 'app-customerarray',
  templateUrl: './customerarray.component.html',
  styleUrls: ['./customerarray.component.css'],
  
})
export class CustomerarrayComponent {
  customers: CustomerTS[] = [];

  constructor() {
    this.customers = [
      new CustomerTS(
        'Meghana',
        'meghana@example.com',
        'megha123',
        'securePass1!',
        'USER',
        'CUST001'
      ),
      new CustomerTS(
        'Rahul',
        'rahul@example.com',
        'rahul456',
        'securePass2!',
        'ADMIN',
        'CUST002'
      )
    ];
  }
}