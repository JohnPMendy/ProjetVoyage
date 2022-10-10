import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Events } from './../../model/events';
import { EventsService } from './../../service/events.service';

@Component({
  selector: 'app-jeu',
  templateUrl: './jeu.component.html',
  styleUrls: ['./jeu.component.css'],
})
export class JeuComponent implements OnInit {
  events: Events = new Events();
  constructor(
    private activatedRoute: ActivatedRoute,
    private eventsService: EventsService
  ) {}

  ngOnInit(): void {
    this.events.id = 2;
    this.activatedRoute.params.subscribe((params) => {
      if (this.events.id) {
        this.eventsService.findById(this.events.id).subscribe((data) => {
          this.events = data;
        });
      }
    });
  }
}
