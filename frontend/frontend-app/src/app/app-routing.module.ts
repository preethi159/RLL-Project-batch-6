import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCuisineComponent } from './add-cuisine/add-cuisine.component';
import { AddFoodComponent } from './add-food/add-food.component';
import { AddProductComponent } from './add-product/add-product.component';
import { AdminProductRetrieveComponent } from './admin-product-retrieve/admin-product-retrieve.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { ViewFoodComponent } from './view-food/view-food.component';
import { ViewfoodUserComponent } from './viewfood-user/viewfood-user.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"changePassword",component:ChangePasswordComponent},
  {path:"adminHome",component:AdmindashboardComponent,children:[
    {path:"addProduct",component:AddProductComponent},
    {path:"addFood",component:AddFoodComponent},
    {path:"addCuisine",component:AddCuisineComponent},
    {path:"view-food",component:ViewFoodComponent},
    {path:"updateProfile",component:UpdateProfileComponent},
    {path:"findAllProduct",component:AdminProductRetrieveComponent}
  ]},
  
  {path:"userHome",component:UserdashboardComponent,children:[
    {path:"viewfood",component:ViewfoodUserComponent},
    {path:"updateProfile",component:UpdateProfileComponent},
    
  ]},

  {path:"signUp",component:SignupComponent},
  {path:"",redirectTo:"login",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }