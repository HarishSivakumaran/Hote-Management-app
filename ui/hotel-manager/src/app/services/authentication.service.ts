import { Injectable } from "@angular/core";
import axios from 'axios'
import { UserContext } from "./usercontext.service";
import { Router } from "@angular/router";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private userContext: UserContext, private router:Router, private http: HttpClient) {
    axios.defaults.baseURL = "http://localhost:8080";
    axios.defaults.headers.post["Content-Type"] = "application/json";
  }

  getHealth() {
   this.http.get("http://localhost:8080/ping").subscribe(data => alert(data));
  }

  login(creds: any) {
    axios.post("/login", creds).then(data => {
      this.userContext.setUser(data.data);
      this.router.navigate(['/','home']);
      });
  }

  register(creds: any) {
    axios.post("/register", creds).then(data => {
      this.userContext.setUser(data.data);
      this.router.navigate(['/','home']);
      });
  }

}
