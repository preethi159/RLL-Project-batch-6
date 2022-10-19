import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cuisines } from './cuisines';

@Injectable({
  providedIn: 'root'
})
export class CuisinesService {

  baseUrl:string ="http://localhost:9090/cuisines"
  constructor(public http:HttpClient) { }

  storeCuisines(cuisines:any):Observable<string> {
    return this.http.post(this.baseUrl+"/storeCuisines",cuisines,{responseType:"text"});
  }
  deleteCuisinesById(id:number):Observable<string> {
    return this.http.delete(this.baseUrl+"/deleteCuisine/"+id,{responseType:"text"});
  }
  findAllCuisines():Observable<Cuisines[]> {
    return this.http.get<Cuisines[]>(this.baseUrl+"/findAllCuisines");
  }

}
