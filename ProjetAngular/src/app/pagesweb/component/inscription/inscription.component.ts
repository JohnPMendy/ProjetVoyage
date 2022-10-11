import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  nom: string = '';
  prenom:string='';
  email:string='';
//l'email c'est le login
  password: string = '';
  form!: FormGroup;
  constructor(private authService: AuthService ,private router: Router) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      inputCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
      ]),

      emailCtrl: new FormControl('', Validators.email),
      passwordCtrl: new FormControl('', Validators.required)

    });
  }
submit(){
// a implementer
}

}
