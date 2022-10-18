import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FoodService } from '../food.service';

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.component.html',
  styleUrls: ['./add-food.component.css']
})
export class AddFoodComponent implements OnInit {
  foodRef = new FormGroup({
    id:new FormControl(),
    name:new FormControl(),
    price:new FormControl(),
    description:new FormControl(),
    offer:new FormControl(),
    fid:new FormControl(),
    url:new FormControl()
  })
msg:string="";
  constructor(public fs:FoodService) { }

  ngOnInit(): void {
  }

  storeFood() {
    let food= this.foodRef.value;
    this.fs.storeFood(food).subscribe({
      next:(result:any)=>this.msg=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })

    this.foodRef.reset();
}
}
