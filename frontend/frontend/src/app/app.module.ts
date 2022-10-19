import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http'
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AddProductComponent } from './add-product/add-product.component';
import { AdminProductRetrieveComponent } from './admin-product-retrieve/admin-product-retrieve.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { AddFoodComponent } from './add-food/add-food.component';
import { FindAllFoodComponent } from './find-all-food/find-all-food.component';
import { ViewFoodComponent } from './view-food/view-food.component';
import { AddCuisineComponent } from './add-cuisine/add-cuisine.component';
import { ViewfoodUserComponent } from './viewfood-user/viewfood-user.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RazorpayComponent } from './razorpay/razorpay.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdmindashboardComponent,
    UserdashboardComponent,
    AddProductComponent,
    AdminProductRetrieveComponent,
    UpdateProfileComponent,
    ChangePasswordComponent,
    AddFoodComponent,
    FindAllFoodComponent,
    ViewFoodComponent,
    AddCuisineComponent,
    ViewfoodUserComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    RazorpayComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,HttpClientModule,FormsModule,ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
