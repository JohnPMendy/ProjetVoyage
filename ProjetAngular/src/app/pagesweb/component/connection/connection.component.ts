import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.css']
})
export class ConnectionComponent implements OnInit {

  login: string = '';
  password: string = '';
  form!: FormGroup;

  constructor(private authService: AuthService ,private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      inputCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(2),

      ]),
      infoGrp: new FormGroup(
        {
          loginCtrl: new FormControl('', Validators.required),
          passwordCtrl: new FormControl('', Validators.required)
        },
      ),
    });
  }

  submit() {
    this.authService.authentication(this.login, this.password).subscribe({
      next: (data) => {
        console.log(data);
        sessionStorage.setItem('compte', JSON.stringify(data));
        sessionStorage.setItem(
          'token',
          'Basic ' + btoa(this.login + ':' + this.password)
        );
        this.router.navigateByUrl('/partie')
      }, //succes
      error: (err) => {
        console.log(err);
      }, //erreur
    });
  }

  // loginAndPrenomNotEquals(control: AbstractControl): ValidationErrors | null {
  //   let group = control as FormGroup;
  //   let prenom = group.controls['prenomCtrl'].value;
  //   let login = group.get('loginCtrl')?.value;
  //   return prenom == login ? { loginPrenomEquals: true } : null;
  // }

}









