import { Component, OnInit } from '@angular/core';
import { Objet } from '../../model/objet';
import { ObjetInventaire } from '../../model/objet-inventaire';
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

  finDePartie: boolean | undefined = false;
  numeroCompte: number = 1;
  numeroPartie: number = 1;

  ngOnInit(): void {}

  nbReponses(reponses: Reponses[]) {
    return reponses.length;
  }


  ajoutObjetInventaire(objet:Objet , qte :number, inventaire:Inventaire,numeroReponse :number ) {
    let objetInventaire=new ObjetInventaire();
    objetInventaire.objet=objet;
    objetInventaire.quantiteInventaire=qte;
    if (this.reponses[numeroReponse].objetId==null){return;}
    else
    {inventaire.objets?.push(objetInventaire)};
  }

supprimerObjetInventaire(inventaire:Inventaire ,nbr :number){

//for(let i=0;i<inventaire.objets!.length;i++){
  let i=0;
while(i<inventaire.objets!.length){
if(inventaire.objets![i].objet?.id===this.reponses[nbr].conditionObjet)
{
  inventaire.objets?.splice(i,i);
}
i++
}}


  initialisation() {
    this.events.id = 1;
    this.covid = 'Non';
    this.vivant = 'Oui';

    this.eventsService.findById(this.events.id).subscribe((data) => {
      this.events = data;
    });

    this.reponsesService.findById(this.events.id).subscribe((data) => {
      this.reponses = data;
    });

    this.personnageService.getById(this.numeroPartie).subscribe((data) => {
      this.personnage = data;
    });

    this.inventaireService.getById(this.numeroPartie).subscribe((data) => {
      this.inventaire = data;
    });
  }

  prochainId(number: number): void {
    this.events.id = this.reponses[number].prochainEvenementId?.id;
    this.finDePartie = this.reponses[number].Fin;
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

    console.log(this.reponses);

    this.ajoutObjetInventaire(this.reponses[number].objetId!,1 ,this.inventaire,number);

    this.supprimerObjetInventaire(this.inventaire,number);
this
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
        console.log('aaaa');
      });
    }
  }
}
