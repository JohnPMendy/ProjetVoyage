import { Compte } from './../../model/compte';
import { CompteService } from './../../service/compte.service';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  //l'email c'est le login

  compte:Compte=new Compte();
  form!: FormGroup;
  test!:number;
  constructor(private authService: AuthService ,private compteService:CompteService,private router: Router) { }

  ngOnInit(): void {

    this.form = new FormGroup({

      loginCtrl: new FormControl('', Validators.email),
      passwordCtrl: new FormControl('', Validators.required)

    }, this.loginEgalMdp);

  }



  loginEgalMdp(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    let login = group.get('loginCtrl');
    let mdp = group.get('passwordCtrl');
    if (login?.invalid||mdp?.invalid) {
      return null;
    }
    return login?.value === mdp?.value ? { error: true} : null;


  }


submit(){
  this.compte.login=this.form.get('loginCtrl')?.value;
  this.compte.role='ROLE_USER';
  this.compte.mdp=this.form.get('passwordCtrl')?.value;
  this.compte.parties=[];

  this.compteService.create(this.compte).subscribe((data) => {
    this.router.navigateByUrl('/connection?action=create&id=' + data.id);
  });
}

}
