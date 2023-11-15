import { Injectable } from "@angular/core";
import axios from 'axios'

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() {
    axios.defaults.baseURL = "http://localhost:8080";
    axios.defaults.headers.post["Content-Type"] = "application/json";
  }

  getHealth() {
   axios.get("/ping").then(v => alert(v));
  }

  login(creds: any) {
    let payload = {
      "login" : creds.email,
      "password": creds.password
    }
    axios.post("/login", payload).then(data => console.log(data));
  }

}
