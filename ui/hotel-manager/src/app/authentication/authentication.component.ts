import { Component } from '@angular/core';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent {
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

    document.getElementById("loginform")?.addEventListener("submit", this.onLogin);
    document.getElementById("signupform")?.addEventListener("submit", this.onLogin);

  }

  onLogin(event: any) {
    debugger;
  }
}
