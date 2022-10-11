import { DatePipe } from '@angular/common';
import { CompteService } from './../../service/compte.service';
import { PartieService } from './../../service/partie.service';
import { Partie } from './../../model/partie';
import { Component, OnInit } from '@angular/core';
import { Compte } from '../../model/compte';

@Component({
  selector: 'app-partie',
  templateUrl: './partie.component.html',
  styleUrls: ['./partie.component.css'],
})
export class PartieComponent implements OnInit {
  parties!: Partie[];
  compte!: Compte;
  dateFormat!: string;
  hourFormat!: string;

  constructor(
    private datePipe: DatePipe,
    private partieService: PartieService,
    private compteService: CompteService
  ) {}

  ngOnInit(): void {
    this.compte = JSON.parse(sessionStorage.getItem('compte')!);
    this.listParties(this.compte.id as number);
  }

  listParties(id: number) {
    this.compteService.getByIdWithParties(id).subscribe((data) => {
      this.parties = data.parties as Partie[];
    });
  }

  delete(id: number) {
    this.partieService.delete(id).subscribe(() => {
      this.listParties(this.compte.id as number);
    });
  }
}
