import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Food } from '../food';
import { FoodService } from '../food.service';
@Component({
  selector: 'app-viewfood-user',
  templateUrl: './viewfood-user.component.html',
  styleUrls: ['./viewfood-user.component.css']
})
export class ViewfoodUserComponent implements OnInit {
  foods:Array<Food>=[];
  foods1:Array<Food>=[];
  foods2:Array<Food>=[];
  msg:string="";
flag:boolean=false;
flag1:boolean=false;
flag2:boolean=false;
flag3:boolean=false;
foodRef = new FormGroup({
  pid:new FormControl(),
  pname:new FormControl()
  
})
  constructor(public fs:FoodService) { }

  ngOnInit(): void {
  }
  findAllFood() {
    this.flag1=false;
    this.flag2=true;
    this.flag3=false;
    this.fs.findAllFood().subscribe({
      next:(result:any)=>this.foods=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }
  findByFid()
{
this.flag1=true;
this.flag2=false;
this.flag3=false;
  let food= this.foodRef.value;
  this.fs.findFoodByCuisine(food.pid).subscribe({
    next:(result:any)=>this.foods1=result,
    error:(error:any)=>console.log(error),
    complete:()=>console.log("completed")
  })

}
findByName()
{
  this.flag1=false;
  this.flag2=false;
  this.flag3=true;
  let food= this.foodRef.value;
  this.fs.findFoodByName(food.pname).subscribe({
    next:(result:any)=>this.foods2=result,
    error:(error:any)=>console.log(error),
    complete:()=>console.log("completed")
  })
}
}


