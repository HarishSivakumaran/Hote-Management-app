import { Component } from '@angular/core';
import {FormsModule, Validators} from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent {
  credentials : any = {
    "firstName": "",
    "lastName" : "",
    "email": "",
    "password": "",
    "confirmPassword": ""
  }
  errorMessage: string = "";

  constructor(private authService: AuthenticationService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    const switchers = document.querySelectorAll('.switcher');

    switchers.forEach(item => {
      item.addEventListener('click', () => {
        switchers.forEach(item => item?.parentElement?.classList.remove('is-active'))
        item.parentElement?.classList.add('is-active');
        this.credentials.reset()
      })
    });

    this.credentials =  this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      login: ['', [Validators.email]],
      password: ['', [Validators.minLength(7)]],
      confirmPassword: [''],
    });

  }

  onLogin(event: any) {
    if(this.credentials.status === "INVALID") return;
      this.authService.login(this.credentials.value);
  }

  onRegister() {
    this.errorMessage = "";
    if(this.credentials.status === "INVALID") return;
    if(this.credentials.controls.password.value != this.credentials.controls.confirmPassword.value) {
      this.errorMessage = "Passwords don't match";
      return;
    }
    this.authService.register(this.credentials.value);
  }
}
