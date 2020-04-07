import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [{path: '', component: LoginComponent},
{path: 'profile', component: ProfileComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
