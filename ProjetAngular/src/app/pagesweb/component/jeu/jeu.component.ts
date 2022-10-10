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
  events: Events = new Events();
  reponses: Reponses[] = [];
  constructor(
    private activatedRoute: ActivatedRoute,
    private eventsService: EventsService,
    private reponsesService: ReponsesService
  ) {}

  ngOnInit(): void {
    this.events.id = 1;
    this.activatedRoute.params.subscribe((params) => {
      if (this.events.id) {
        this.eventsService.findById(this.events.id).subscribe((data) => {
          this.events = data;
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

  prochainId() {
    return null;
  }
}
