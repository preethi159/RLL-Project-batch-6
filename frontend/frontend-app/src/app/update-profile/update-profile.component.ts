import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  loginRef = new FormGroup({
    emailid:new FormControl(),
   name:new FormControl(),
   phno:new FormControl(),
   address:new FormControl()
  })
    msg:string="";
  constructor(public ls:LoginService) { }

  ngOnInit(): void {
  }
  updateProfile(){
    let login = this.loginRef.value;
    this.ls.updateProfile(login).subscribe({
      next:(result:any)=>this.msg=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
         
      }
    )

}
}
