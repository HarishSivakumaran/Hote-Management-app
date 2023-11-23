import { Component } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserContext } from 'src/app/services/usercontext.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  user :any = undefined;
  constructor(private service : AuthenticationService, private userContext: UserContext){}

  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.user = this.userContext.getUserContext();
  }

  checkHealth(){
    this.service.getHealth();
  }

}
