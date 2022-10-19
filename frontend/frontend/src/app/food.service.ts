import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Food } from './food';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  baseUrl:string ="http://localhost:9090/food"
  constructor(public http:HttpClient) { }

  storeFood(food:any):Observable<string> {
    return this.http.post(this.baseUrl+"/storeFood",food,{responseType:"text"});
  }
  updateFood(food:any):Observable<string> {
    return this.http.patch(this.baseUrl+"/updateFood",food,{responseType:"text"});
  }

  findAllFood():Observable<Food[]> {
    return this.http.get<Food[]>(this.baseUrl+"/findAllFood");
  }

  findFoodByName(name:string):Observable<Food[]> {
    return this.http.get<Food[]>(this.baseUrl+"/findFoodByName/"+name);
  }
 findFoodByCuisine(fid:number):Observable<Food[]> {
     return this.http.get<Food[]>(this.baseUrl+"/findFoodByCuisine/"+fid);
   }
  findAllProductById(pid:number):Observable<string> {
    return this.http.get(this.baseUrl+"/findAllProduct/"+pid,{responseType:"text"});
  }
  deleteFood(id:number):Observable<string> {
    return this.http.delete(this.baseUrl+"/deleteFood/"+id,{responseType:"text"});
  }
  // deleteFoodByCuisine(fid:number):Observable<string> {
  //   return this.http.delete(this.baseUrl+"/deleteFoodByCuisine/"+fid,{responseType:"text"});
  // }
}