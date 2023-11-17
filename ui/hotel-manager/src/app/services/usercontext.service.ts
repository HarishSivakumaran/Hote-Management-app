import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserContext {
  private user = { firstName: '', lastName: '', login: ''};

  clearContext() {
    this.user.firstName = '';
    this.user.lastName = '';
    this.user.login = '';
    localStorage.removeItem("token");
  }

  getUserContext() {
    return structuredClone(this.user);
  }

  setUser(creds: any) {
    this.user.firstName = creds.firstName;
    this.user.lastName = creds.lastNam;
    this.user.login = creds.login;
    localStorage.setItem("token", creds.token);
  }

  isLoggedIn() {
    return !!localStorage.getItem("token");
  }
}
