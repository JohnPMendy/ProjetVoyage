import { JeuComponent } from './pagesweb/component/jeu/jeu.component';
import { Routes } from '@angular/router';
import { AccueilComponent } from './pagesweb/component/accueil/accueil.component';
import { ConnectionComponent } from './pagesweb/component/connection/connection.component';
import { PartieComponent } from './pagesweb/component/partie/partie.component';

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

  {
    path: 'partie',
    component: PartieComponent,
  },
];
