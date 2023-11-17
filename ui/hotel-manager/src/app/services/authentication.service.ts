import { Injectable } from "@angular/core";
import axios from 'axios'
import { UserContext } from "./usercontext.service";
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private userContext: UserContext, private router:Router) {
    axios.defaults.baseURL = "http://localhost:8080";
    axios.defaults.headers.post["Content-Type"] = "application/json";
  }

  getHealth() {
   axios.get("/ping").then(v => alert(v));
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
