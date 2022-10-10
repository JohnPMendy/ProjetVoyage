import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './pagesweb/service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  constructor(public router: Router,private authService: AuthService) {}
  title = 'ProjetAngular';

  ngOnInit() {

  }
deconnexion(){
  this.authService.logout()
}

}
