import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { Food } from '../food'; 
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-view-food',
  templateUrl: './view-food.component.html',
  styleUrls: ['./view-food.component.css']
})
export class ViewFoodComponent implements OnInit {
foods:Array<Food>=[];
foods1:Array<Food>=[];
foods2:Array<Food>=[];
msg:string="";
flag:boolean=false;
flag1:boolean=false;
flag2:boolean=false;
flag3:boolean=false;
price:number=0;
offer:number=0;
description:string="";
url:string="";
id:number=0;
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
  deleteFood(id:number){
    //console.log(id)
    this.fs.deleteFood(id).subscribe({
      next:(result:any)=>this.msg=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
      
             
      }
    )
  }
  updateFood(food:any){
    this.flag= true;
    this.id=food.id;
    this.price=food.price;
    this.url=food.url;
    this.description=food.description;
    this.offer=food.offer;
}

updateFoodFromDB(){
  let food = {id:this.id,price:this.price,url:this.url,offer:this.offer,description:this.description};
  this.fs.updateFood(food).subscribe({
    next:(result:any)=>this.msg=result,
    error:(error:any)=>console.log(error),
    complete:()=>console.log("completed")
           
    
  })
  this.flag=false;
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
