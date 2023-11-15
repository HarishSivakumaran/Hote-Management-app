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

}
