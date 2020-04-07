import { Component, OnInit } from '@angular/core';
import { Store } from '@ngxs/store';
import { Observable } from 'rxjs';
import { UserProfile } from 'src/app/shared/model/profile';
import { AuthService } from 'src/app/core/http/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user$: Observable<any>;
  currentUser: UserProfile = new UserProfile();
  constructor(private store: Store, private auth: AuthService) { 
    this.user$ = this.store.select(state=> state.users.users);
  }
  
  ngOnInit() {
    this.user$.subscribe(
      res => this.currentUser = res[0]
    )
  
  }
  logout(){
    this.auth.logOut().subscribe(
     res=> console.log(res),
     err => console.log(err)
     
     
    )
  }

}
