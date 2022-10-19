import { Component, OnInit,HostListener } from '@angular/core';


declare var Razorpay:any;

@Component({
  selector: 'app-razorpay',
  templateUrl: './razorpay.component.html',
  styleUrls: ['./razorpay.component.css']
})
export class RazorpayComponent {
    message:string=" "
    paymentId="";
    error="";
    title = 'Payment';
    options = {
      "key": "rzp_test_QgxUUYmOqlYOdD",
       "amount": "200",
       "name": "Ritesh Team",
       "description": "Food Items",
       "image": "https://www.abhijitgatade.com/assets/img/favicon.png",
       "order_id":"",
       "handler": function (response: any){
  
          var event = new CustomEvent("payment.success",
  
              {
  
                  detail: response,
  
                  bubbles: true,
  
                  cancelable: true
  
              }
  
          );
  
          window.dispatchEvent(event);
  
      }
  
      ,
  
      "prefill": {
  
      "name": "",
  
      "email": "",
  
      "contact": ""
  
      },
  
      "notes": {
  
      "address": ""
  
      },
  
      "theme": {
  
      "color": "#3399cc"
  
      }
  
      };
      paynow(){
        this.paymentId = '';
  
            this.error = '';
  
              this.options.amount = "200"; //paise
  
              this.options.prefill.name = "Kishor";
  
              this.options.prefill.email = "riteshkumar96977@gmail.com";
  
              this.options.prefill.contact = "9561320192";
  
              var rzp1 = new Razorpay(this.options);
  
              rzp1.open();
  
              rzp1.on('payment.failed', function (response: any){
           //     this.message="Payment Failed"
  
                  // Todo - store this information in the server
                  console.log(response.error.code);
                  console.log(response.error.description);
                  console.log(response.error.source);
                  console.log(response.error.step);
                  console.log(response.error.reason);
                  console.log(response.error.metadata.order_id);
                  console.log(response.error.metadata.payment_id);
  
                  //this.error = response.error.reason;
  
              }
  
          );
  
      }
      @HostListener('window:payment.success', ['$event'])
  
      onPaymentSuccess(event: any): void {
  
         this.message = "Success Payment";
  
      }

 

}
