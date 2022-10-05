import { JeuComponent } from './pagesweb/component/jeu/jeu.component';
import { Routes } from '@angular/router';
import { AccueilComponent } from './pagesweb/component/accueil/accueil.component';

export const routes: Routes = [
  {
    path: 'jeu',
    component: JeuComponent,
  },

  {
    path: 'accueil',
    component: AccueilComponent,
  },
];
