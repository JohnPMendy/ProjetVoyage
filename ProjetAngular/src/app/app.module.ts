import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { routes } from './routes';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { JeuComponent } from './pagesweb/component/jeu/jeu.component';

@NgModule({
  declarations: [AppComponent, JeuComponent],
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
