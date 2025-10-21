import { Component } from '@angular/core';
import { AccountTS } from '../../types/tstypes/Accountts';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-accountsample',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './accountsample.component.html',
  styleUrls: ['./accountsample.component.css']
})
export class AccountsampleComponent {
  account: AccountTS;
  
  formattedBalance: string;
  constructor()
  {
    
this.account = new AccountTS('1', 1000, '1');
this.formattedBalance = this.account.balance.toFixed(2);

   // this.formattedBalance = this.account.balance.toFixed(2)

  }


}
