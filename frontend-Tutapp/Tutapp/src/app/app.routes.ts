import { Routes } from '@angular/router';
import { Home } from './home/home';
import { UserCreateAccount } from './user-create-account/user-create-account';
import { UserConnexion } from './user-connexion/user-connexion';

export const routes: Routes = [
  {
    path: '',
    component: Home
  },
  {
    path: 'login',
    component: UserConnexion
  },
  {
    path: 'CreateAccount',
    component: UserCreateAccount
  }
];
