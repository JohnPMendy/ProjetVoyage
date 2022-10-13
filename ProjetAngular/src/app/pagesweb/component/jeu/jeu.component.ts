import { Component, OnInit } from '@angular/core';
import { Personnage } from '../../model/personnage';
import { Events } from './../../model/events';
import { Inventaire } from './../../model/inventaire';
import { Reponses } from './../../model/reponses';
import { EventsService } from './../../service/events.service';
import { inventaireService } from './../../service/inventaire.service';
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
  inventaire!: Inventaire;
  covid!: String;
  vivant!: String;

  constructor(
    private eventsService: EventsService,
    private reponsesService: ReponsesService,
    private personnageService: PersonnageService,
    private inventaireService: inventaireService
  ) {}

  finDePartie: boolean | undefined = true;
  numeroCompte: number = 1;
  numeroPartie: number = 1;

  ngOnInit(): void {}

  nbReponses(reponses: Reponses[]) {
    return reponses.length;
  }

  ajoutObjetInventaire(id: number) {

    //this.inventaire.objets!.objet.push( this.reponses[id].objetId?);
    // this.inventaire.objets!= this.reponses[id].objetId!.nom;
    // this.inventaire.objets!= this.reponses[id].objetId!.prix;
    // this.inventaire.objets![id].objet!.typeObjetAlimetaire= this.reponses[id].objetId!.typeObjetAlimetaire;
    // this.inventaire.objets![id].objet!.typeObjets= this.reponses[id].objetId!.typeObjets;
  }

  initialisation() {
    this.finDePartie = true;
    this.events.id = 1;
    this.covid = 'Non';
    this.vivant = 'Oui';

    this.eventsService.findById(this.events.id).subscribe((data) => {
      this.events = data;
      console.log(this.events);
    });

    this.reponsesService.findById(this.events.id).subscribe((data) => {
      this.reponses = data;
      console.log(this.reponses);
    });

    this.personnageService.getById(this.numeroPartie).subscribe((data) => {
      this.personnage = data;
    });

    this.inventaireService.getById(this.numeroPartie).subscribe((data) => {
      this.inventaire = data;
      console.log(this.inventaire.objets![0].objet?.nom);
    });
  }

  prochainId(number: number): void {
    this.events.id = this.reponses[number].prochainEvenementId?.id;
    this.finDePartie = this.reponses[number].isAlive;
    this.personnage!.isAlive = this.finDePartie;

    this.personnage!.argent =
      this.personnage!.argent! +
      this.reponses[number].ajoutArgent! -
      this.reponses[number].conditionArgent!;

    this.personnage!.energie =
      this.personnage!.energie! +
      this.reponses[number].ajoutEnergie! -
      this.reponses[number].conditionEnergie!;

    this.personnage!.faim =
      this.personnage!.faim! +
      this.reponses[number].ajoutFaim! -
      this.reponses[number].conditionFaim!;

    this.personnage!.force =
      this.personnage!.force! +
      this.reponses[number].ajoutForce! -
      this.reponses[number].conditionForce!;

    this.personnage!.poids =
      this.personnage!.poids! +
      this.reponses[number].ajoutPoids! -
      this.reponses[number].conditionPoids!;

    console.log(this.reponses.length);

    //this.ajoutObjetInventaire(number);

    //console.log(Math.random());
    //if (Math.random() < this.reponses[number]!.ajoutCovid! / 100) {
    //this.personnage?.isCovided != true;
    //this.covid = 'Oui';
    //} else {
    //this.personnage?.isCovided != false;
    //this.covid = 'Non';
    //}

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
