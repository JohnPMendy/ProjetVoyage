import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { routes } from './routes';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { JeuComponent } from './pagesweb/component/jeu/jeu.component';
import { AccueilComponent } from './pagesweb/component/accueil/accueil.component';
import { ConnectionComponent } from './pagesweb/component/connection/connection.component';

@NgModule({
  declarations: [AppComponent, JeuComponent, AccueilComponent, ConnectionComponent],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
