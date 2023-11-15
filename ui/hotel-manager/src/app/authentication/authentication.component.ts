import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import axios from 'axios';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent {
  credentials : any = {
    "email": "",
    "password": "",
    "confirmPassword": ""
  }

  constructor(private authService: AuthenticationService) {

  }

  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    const switchers = document.querySelectorAll('.switcher');

    switchers.forEach(item => {
      item.addEventListener('click', function() {
        switchers.forEach(item => item?.parentElement?.classList.remove('is-active'))
        item.parentElement?.classList.add('is-active')
      })
    });

  }

  onLogin(event: any) {
    if(!!this.credentials.confirmPassword) {
      // sign up
    } else {
      //login
      this.authService.login(this.credentials);
    }
  }
}
