import { Component, OnInit } from '@angular/core';
import { Cuisines } from '../cuisines';
import { CuisinesService } from '../cuisines.service';
import {FormGroup,FormControl} from '@angular/forms'

@Component({
  selector: 'app-add-cuisine',
  templateUrl: './add-cuisine.component.html',
  styleUrls: ['./add-cuisine.component.css']
})
export class AddCuisineComponent implements OnInit {
  cuisinesRef = new FormGroup({
    id:new FormControl(),
    name:new FormControl(),
  })
  cuisines:Array<Cuisines>=[];
  msg:string="";
  flag:boolean=false;
  constructor(public cs:CuisinesService) { }

  ngOnInit(): void {
    this.findAllCuisines();
  }
  findAllCuisines() {
    this.cs.findAllCuisines().subscribe({
      next:(result:any)=>this.cuisines=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }
  addCuisines() {
    let cuisines= this.cuisinesRef.value;
    this.cs.storeCuisines(cuisines).subscribe({
      next:(result:any)=>this.msg=result,
      error:(error:any)=>console.log(error),
      complete:()=>{
        this.findAllCuisines();   
    }
  
    })
  this.flag=false;
}
addmore()
{
this.flag=true;


}
deleteCuisines(id:number){
  //console.log(pid)
  this.cs. deleteCuisinesById(id).subscribe({
    next:(result:any)=>console.log(result),
    error:(error:any)=>console.log(error),
    complete:()=>console.log("completed")
    // {
    //     //this.findAllCuisines();   
    // }
  })
  this.msg="i came here";
}
}
