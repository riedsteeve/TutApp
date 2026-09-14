import { Routes } from '@angular/router';
import { Home } from './home/home';
import { UserCreateAccount } from './user-create-account/user-create-account';
import { UserConnexion } from './user-connexion/user-connexion';
import { Acceuil } from './acceuil/acceuil';
import { LayoutPostConn } from './layout-post-conn/layout-post-conn';
import { NavPostConn } from './nav-post-conn/nav-post-conn';
import { MesCours } from './mes-cours/mes-cours';
import { PublierTuto } from './publier-tuto/publier-tuto';
import { UserProfil } from './user-profil/user-profil';

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
  },
  {
    path: '',
    component: LayoutPostConn,
    children: [
      {
        path: 'acceuil',
        component: Acceuil
      },
      {
        path: 'mes-cours',
        component: MesCours
      },
      {
        path: 'publier-tuto',
        component: PublierTuto
      },
      {
        path: 'profil',
        component: UserProfil
      }
  ]
  }
];
