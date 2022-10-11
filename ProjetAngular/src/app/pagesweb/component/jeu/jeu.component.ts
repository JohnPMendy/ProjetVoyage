import { Component, OnInit } from '@angular/core';
import { Personnage } from '../../model/personnage';
import { Events } from './../../model/events';
import { Reponses } from './../../model/reponses';
import { EventsService } from './../../service/events.service';
import { PersonnageService } from './../../service/personnage.service';
import { ReponsesService } from './../../service/reponses.service';

@Component({
  selector: 'app-jeu',
  templateUrl: './jeu.component.html',
  styleUrls: ['./jeu.component.css'],
})
export class JeuComponent implements OnInit {
  events: Events = new Events(0);
  reponses: Reponses[] = [];
  personnage: Personnage | undefined;

  constructor(
    private eventsService: EventsService,
    private reponsesService: ReponsesService,
    private personnageService: PersonnageService
  ) {}

  finDePartie: boolean | undefined = true;
  numeroCompte: number = 1;
  numeroPartie: number = 1;

  ngOnInit(): void {}

  nbReponses(reponses: Reponses[]) {
    return reponses.length;
  }

  initialisation() {
    this.finDePartie = true;
    this.events.id = 1;

    this.eventsService.findById(this.events.id).subscribe((data) => {
      this.events = data;
    });

    this.reponsesService.findById(this.events.id).subscribe((data) => {
      this.reponses = data;
    });

    this.personnageService.getById(this.numeroPartie).subscribe((data) => {
      this.personnage = data;
    });
  }

  prochainId(number: number): void {
    this.events.id = this.reponses[number].prochainEvenementId?.id;
    console.log(this.reponses[number].isAlive);
    this.finDePartie = this.reponses[number].isAlive;
    if (this.events.id) {
      this.eventsService.findById(this.events.id).subscribe((data) => {
        this.events = data;
      });
    }
    if (this.events.id && this.reponses[number].isAlive) {
      this.reponsesService.findById(this.events.id).subscribe((data) => {
        this.reponses = data;
        console.log(this.reponses);
      });
    }
  }
}
