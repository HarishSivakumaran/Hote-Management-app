import { inject } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivateFn,
  Router,
  RouterStateSnapshot,
} from '@angular/router';
import { map } from 'rxjs';
import { UserContext } from '../services/usercontext.service';

export const AuthGuard: CanActivateFn = (
  next: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const userContext: UserContext = inject(UserContext);
  const router: Router = inject(Router);
  if(!userContext.isLoggedIn()){
      return router.createUrlTree(['/auth']);
  }

  return true;
}
