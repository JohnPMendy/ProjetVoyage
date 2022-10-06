import { JeuComponent } from './pagesweb/component/jeu/jeu.component';
import { Routes } from '@angular/router';
import { AccueilComponent } from './pagesweb/component/accueil/accueil.component';
import { ConnectionComponent } from './pagesweb/component/connection/connection.component';

export const routes: Routes = [
  {
    path: 'jeu',
    component: JeuComponent,
  },

  {
    path: 'accueil',
    component: AccueilComponent,
  },

  {
    path: 'connection',
    component: ConnectionComponent,
  },
];
