import { Observable } from 'rxjs';
import { Personnage } from './../../model/personnage';
import { PersonnageService } from './../../service/personnage.service';
import { DatePipe } from '@angular/common';
import { CompteService } from './../../service/compte.service';
import { PartieService } from './../../service/partie.service';
import { Partie } from './../../model/partie';
import { Component, OnInit } from '@angular/core';
import { Compte } from '../../model/compte';
import { Router } from '@angular/router';

@Component({
  selector: 'app-partie',
  templateUrl: './partie.component.html',
  styleUrls: ['./partie.component.css'],
})
export class PartieComponent implements OnInit {
  parties!: Observable<Partie[]>;
  partiesTest!: Observable<Partie[]>;
  compte!: Compte;
  dateFormat!: string;
  hourFormat!: string;
  partie: Partie = new Partie();
  personnage!: Personnage;

  constructor(
    private datePipe: DatePipe,
    private partieService: PartieService,
    private compteService: CompteService,
    private personnageService: PersonnageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.compte = JSON.parse(sessionStorage.getItem('compte')!);
    this.listParties(this.compte.id as number);
  }

  listParties(id: number) {
    let listId: number[] = [];
    this.compteService.getByIdWithParties(id).subscribe((data) => {
      let p: Partie;
      for (p of data.parties!) {
        listId.push(p.id as number);
      }
      console.log(listId);
      this.parties = this.partieService.getAll();

      console.log(this.parties);
      console.log(this.parties.operator?.call.length);
    });
  }

  delete(id: number) {
    this.partieService.delete(id).subscribe(() => {
      this.listParties(this.compte.id as number);
    });
  }

  creation() {
    if (!this.partie.id) {
      this.partieService.create(this.partie).subscribe((data) => {
        //this.router.navigateByUrl('/questionnaire');
        this.router.navigateByUrl('/partie');
      });
    }
  }

  charger() {}
}
