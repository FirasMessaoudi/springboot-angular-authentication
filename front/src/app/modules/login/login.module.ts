import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { ProfileComponent } from './profile/profile.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [LoginComponent, ProfileComponent],
  imports: [
    CommonModule,
    FormsModule,
    LoginRoutingModule
  ]
})
export class LoginModule { }
