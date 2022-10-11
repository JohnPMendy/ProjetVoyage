import { Compte } from './../../model/compte';
import { CompteService } from './../../service/compte.service';
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

  //l'email c'est le login
  email:string='';
  password: string = '';
  compte:Compte=new Compte();
  form!: FormGroup;
  constructor(private authService: AuthService ,private compteService:CompteService,private router: Router) { }

  ngOnInit(): void {
    this.compte.login=this.email;
    this.compte.role='ROLE_USER';
    this.compte.mdp=this.password;
    this.compte.parties=[];
    this.form = new FormGroup({

      emailCtrl: new FormControl('', Validators.email),
      passwordCtrl: new FormControl('', Validators.required)

    });

  }
submit(){
  console.log("aaa");
  this.compteService.create(this.compte).subscribe((data) => {
    this.router.navigateByUrl('/compte?action=create&id=' + data.id);
    console.log("aaa");
  });
}

}
