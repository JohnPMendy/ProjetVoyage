import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Events } from './../../model/events';
import { Reponses } from './../../model/reponses';
import { EventsService } from './../../service/events.service';
import { ReponsesService } from './../../service/reponses.service';

@Component({
  selector: 'app-jeu',
  templateUrl: './jeu.component.html',
  styleUrls: ['./jeu.component.css'],
})
export class JeuComponent implements OnInit {
  events: Events = new Events(1);
  reponses: Reponses[] = [];
  constructor(
    private activatedRoute: ActivatedRoute,
    private eventsService: EventsService,
    private reponsesService: ReponsesService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (this.events.id) {
        this.eventsService.findById(this.events.id).subscribe((data) => {
          this.events = data;
          console.log(this.events.id);
        });

        this.reponsesService.findById(this.events.id).subscribe((data) => {
          this.reponses = data;
        });
      }
    });
  }

  nbReponses(reponses: Reponses[]) {
    return reponses.length;
  }

  prochainId(number: number): void {
    this.events.id = this.reponses[number].prochainEvenementId?.id;
    this.activatedRoute.params.subscribe((params) => {
      if (this.events.id) {
        this.eventsService.findById(this.events.id).subscribe((data) => {
          this.events = data;
          console.log(this.events.id);
        });

        this.reponsesService.findById(this.events.id).subscribe((data) => {
          this.reponses = data;
          console.log(this.reponses);
        });
      }
    });
  }
}
