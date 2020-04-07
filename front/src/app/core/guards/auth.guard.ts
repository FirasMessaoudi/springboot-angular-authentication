import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
// import { UtilisateurService } from '../services/utilisateur.service';
import {Router} from '@angular/router';
import { Store } from '@ngxs/store';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  users: Observable<any>;

  constructor( private store: Store,
    private router: Router) {
      this.users = this.store.select(state => state.users.users);

  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    //  this.userService.setUserToGo(state.url);
    return this.users.pipe(
      map(
      res=>{
        if(res.length>0)
          return true;
          else{
            this.router.navigate([''])
            return false;

          }
        
      }
    )
    )
  }
}
