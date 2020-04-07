import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/core/http/auth.service';
import { Store } from '@ngxs/store';
import { LoginRequest } from 'src/app/shared/model/login-request';
import { LoginResponse } from 'src/app/shared/model/login-response';
import { UserProfile } from 'src/app/shared/model/profile';
import { AddUser } from 'src/app/shared/state/action';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
   username: string;
   password: string;
  constructor(private aut: AuthService,
    private toastr: ToastrService,
     private store: Store, private router: Router) { }

  ngOnInit() {
  }
  onConnect(){
  let request: LoginRequest =new LoginRequest()
  request.username = this.username;
  request.password = this.password;
  let response: LoginResponse = new LoginResponse();
  let profile: UserProfile = new UserProfile();
  this.aut.signIn(request).subscribe(
    res => response = res,
    err => console.log(err),
    ()=>{
      if(response.error=='User Already logged in'){
        this.toastr.error('User Already logged in');
      } else if(response.status=='SUCCESS'){
      
        this.aut.getUser().subscribe(
          res=> profile = res,
          err => console.log(err),
          ()=>{
            this.store.dispatch(new AddUser(profile));
            this.router.navigate(['/profile']);
          }
          
        )
      }
      else {
        //toaster invalid credentials
        this.toastr.error('Invalid credentials');
      }
    }
    
  )

  }

}
