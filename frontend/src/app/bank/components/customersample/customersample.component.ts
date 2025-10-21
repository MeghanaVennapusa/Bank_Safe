import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Customer } from '../../types/Customer';
import { of } from 'rxjs';
import { CustomerTS } from '../../types/tstypes/Customerts';

@Component({
  selector: 'app-customersample',
  standalone: true,
  imports: [],
  templateUrl: './customersample.component.html',
  styleUrls: ['./customersample.component.css']
})
export class CustomersampleComponent {
  customer: CustomerTS;
  constructor()
  {
    
this.customer = new CustomerTS(
  'Meghana',           // name
  'vm@gmail.com',      // email
  'Megha',             // username
  'meghs@127',         // password
  'USER',              // role
  '123'                // customerId (optional)
);
  }
}

