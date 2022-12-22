import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { take } from 'rxjs';
import { GrocessaryService } from '../../../app/components/service/grocessary.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  orderId: string = '';
  totalPrice: string = '';
  cardNumber: string = '';
  nameOnCard: number = 0;
  expYear: number = 0;
  cvv: string='';
  productId: any;

  constructor(

    private gService: GrocessaryService,
    private router: Router,
    private activateRouter: ActivatedRoute


  ) {

  }
  ngOnInit(): void {
  }

  paymentList(): void {

    const body: any = {
      cardNumber: this.cardNumber,
      nameOnCard: this.nameOnCard,
      expYear: this.expYear,
      cvv:this.cvv

    }
      console.log("=======>", body);
      this.gService.paymentList(body).pipe(take(1)).subscribe((res: any) => {
        console.log("*****", res);
        if (res && res?.paymentId) {
          alert("payment done sucessfully");
          this.router.navigate(["/src/app/components/client/client-order"]);
        }
      }, err => {
        console.log("Error  ", err);
        alert("Something going wrong!!pl try again");
      })
    }
  }
