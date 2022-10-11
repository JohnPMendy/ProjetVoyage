import { AnonymousGuardService } from './pagesweb/service/anonymous-guard.service';
import { JeuComponent } from './pagesweb/component/jeu/jeu.component';
import { Routes } from '@angular/router';
import { AccueilComponent } from './pagesweb/component/accueil/accueil.component';
import { ConnectionComponent } from './pagesweb/component/connection/connection.component';
import { PartieComponent } from './pagesweb/component/partie/partie.component';
import { AuthenticatedGuardService } from './pagesweb/service/authenticated-guard.service';
import { InscriptionComponent } from './pagesweb/component/inscription/inscription.component';

export const routes: Routes = [
  {
    path: 'jeu',
    component: JeuComponent,canActivate:[AuthenticatedGuardService]
  },

  {
    path: 'accueil',
    component: AccueilComponent, canActivate:[AnonymousGuardService] //on peut rentrer sans se connecter.
  },

  {
    path: 'connection',
    component: ConnectionComponent,canActivate:[AnonymousGuardService]
  },

  {
    path: 'partie',
    component: PartieComponent,canActivate:[AuthenticatedGuardService]
  },

  {
    path: '', redirectTo:'partie',pathMatch:'full'
  },

  {
    path: 'inscription',
    component: InscriptionComponent,canActivate:[AnonymousGuardService]
  },
];
