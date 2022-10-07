import { AuthenticationInterceptor } from './pagesweb/interceptor/authentification.interceptor';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { routes } from './routes';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { JeuComponent } from './pagesweb/component/jeu/jeu.component';
import { AccueilComponent } from './pagesweb/component/accueil/accueil.component';
import { ConnectionComponent } from './pagesweb/component/connection/connection.component';
import { PartieComponent } from './pagesweb/component/partie/partie.component';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [AppComponent, JeuComponent, AccueilComponent, ConnectionComponent, PartieComponent],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [{provide:HTTP_INTERCEPTORS,useClass: AuthenticationInterceptor ,multi:true}],
  bootstrap: [AppComponent],
})
export class AppModule {}
