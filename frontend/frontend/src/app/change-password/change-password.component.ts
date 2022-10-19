import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  loginRef = new FormGroup({
    emailid:new FormControl(),
    password:new FormControl()})
    msg:string="";
  constructor(public ls:LoginService) { }
  


  ngOnInit(): void {
  }
  changePassword(){
    let login = this.loginRef.value;
    this.ls.updatePassword(login).subscribe({
      next:(result:any)=>this.msg=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
         
      }
    )
  
    
   

  
}
}
