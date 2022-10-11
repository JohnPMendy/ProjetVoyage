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
  compte!: session;

  constructor(
    private partieService: PartieService,
    private compteService: CompteService
  ) {}

  ngOnInit(): void {
    this.listParties();
  }

  listParties(id: number) {
    this.compte = sessionStorage.getItem('compte');
    this.compteService.getByIdWithParties(this.compte.id).subscribe((data) => {
      this.parties = data;
    });
  }

  delete(id: number) {
    this.partieService.delete(id).subscribe(() => {
      this.listParties();
    });
  }
}
