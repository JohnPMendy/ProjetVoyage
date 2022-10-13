import { Personnage } from './../../model/personnage';
import { PersonnageService } from './../../service/personnage.service';
import { CompteService } from './../../service/compte.service';
import { PartieService } from './../../service/partie.service';
import { Partie } from './../../model/partie';
import { Component, OnInit } from '@angular/core';
import { Compte } from '../../model/compte';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-partie',
  templateUrl: './partie.component.html',
  styleUrls: ['./partie.component.css'],
})
export class PartieComponent implements OnInit {
  parties: Partie[] = [];
  compte!: Compte;
  partie: Partie = new Partie();
  personnage!: Observable<Personnage>;
  listId: number[] = [];

  constructor(
    private partieService: PartieService,
    private compteService: CompteService
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

      let i: number;
      for (i of listId) {
        this.partieService.findById(i).subscribe((params) => {
          let play: Partie = new Partie();
          play.id = params['id'];
          play.compte = params['compte'];
          play.personnage = params['personnage'];
          play.environment = params['environment'];
          play.inventaire = params['inventaire'];
          play.date = params['date'];
          play.eventRunning = params['eventRunning'];
          this.parties.push(play);
        });
      }
    });
  }

  delete(id: number) {
    this.partieService.delete(id).subscribe(() => {
      this.parties = [];
      this.listParties(this.compte.id as number);
    });
  }

  charger(id: number) {
    this.partieService.sendCharge(id);
  }
}
