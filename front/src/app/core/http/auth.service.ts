import { Injectable } from '@angular/core';
import { LoginRequest } from 'src/app/shared/model/login-request';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import {HttpClient} from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Store } from '@ngxs/store';
import { Reset } from 'src/app/shared/state/action';

const URL_BASE = environment.baseUrl;

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router: Router, private store: Store,private  httpClient: HttpClient) { 
              }
  signIn(request: LoginRequest):Observable<any>{
    return this.httpClient.post<any>(URL_BASE + '/auth/login', request, {withCredentials: true});

  }
  refresh():Observable<any>{
    return this.httpClient.post<any>(URL_BASE+'/auth/refresh', {withCredentials: true});
  }
  getUser(): Observable<any> {
    return this.httpClient.get<any>(URL_BASE+'/profile/me', {withCredentials: true})
    .pipe(
      tap(user => {
        console.log(user);
      })
    );
    ;
  }
  logOut():Observable<any>{
    return this.httpClient.get(URL_BASE+'/auth/logout',{withCredentials: true}).pipe(
      tap(res => {
        console.log(res);
       this.store.dispatch(new Reset());
       localStorage.clear();
        this.router.navigate(['']);
      
      })
    )
    

  }
 
}
