import { environment } from './../../../../environments/environment.prod';
import { inventaireService } from './../../service/inventaire.service';
import { PartieService } from './../../service/partie.service';
import { EventsService } from './../../service/events.service';
import { Router } from '@angular/router';
import { PersonnageService } from './../../service/personnage.service';
import { CompetenceService } from './../../service/competence.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Competence } from '../../model/competence';
import { Personnage } from '../../model/personnage';
import { Events } from '../../model/events';
import { Inventaire } from '../../model/inventaire';
import { Partie } from '../../model/partie';
import { timestamp } from 'rxjs';
import { ObjetInventaire } from '../../model/objet-inventaire';
import { Compte } from '../../model/compte';

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css'],
})
export class QuestionnaireComponent implements OnInit {
  formQuestionnaire!: FormGroup;
  personnage!: Personnage;
  reactivite!: Competence;
  sociabilite!: Competence;
  organisation!: Competence;
  orientation!: Competence;
  anim!: Competence;
  linguistique!: Competence;
  culture!: Competence;

  inventaire!:Inventaire;
  eventInit!:Events;



  isFormInvalid!: boolean;

  ages: string[] = [
    'Moins de 25 ans',
    'Entre 25 et 34 ans',
    'Entre 35 et 49 ans',
    'Entre 50 et 65 ans',
    'Plus de 65 ans',
  ];

  weekendList: string[] = [
    'Vous faites votre jogging tôt le dimanche matin',
    'Vous aimez chiller sur Netflix',
    'Vous faites vos comptes',
    'Vous sortez voir vos amis',
  ];

  jeux: string[] = [
    'Les RPGs',
    'Les jeux de plateforme',
    'Les jeux de simulation',
    "Les jeux d'action",
  ];

  matieres: string[] = [
    'Les maths',
    "l'anglais",
    'les SVT',
    'le français',
    'la géographie',
    "l'EPS",
  ];

  saison!: string;
  saisons: string[] = ['le printemps', "l'été", "l'automne", "l'hiver"];

  compte!:Compte;

  constructor(
    private srvCompetence: CompetenceService,
    private srvPersonnage: PersonnageService,
    private srvInventaire:inventaireService,
    private srvEvents:EventsService,
    private srvPartie:PartieService,
    private router: Router
  ) {}

  ngOnInit(): void {


    //initialisation formulaire
    this.formQuestionnaire = new FormGroup({
      id: new FormControl(),
      nom: new FormControl('', Validators.required),
      prenom: new FormControl('', Validators.required),
      weekend: new FormControl('', Validators.required),
      jeu: new FormControl('', Validators.required),
      saison: new FormControl('', Validators.required),
      age: new FormControl('', Validators.required),
      matiere: new FormControl('', Validators.required),
    });

    this.compte=JSON.parse(sessionStorage.getItem('compte')!);

    //récupération des compétences à attribuer à partir de la bdd
    this.srvCompetence
      .getByNom('reactivite')
      .subscribe((data) => (this.reactivite = data));
    this.srvCompetence
      .getByNom('sociabilite')
      .subscribe((data) => (this.sociabilite = data));
    this.srvCompetence
      .getByNom('Organisation')
      .subscribe((data) => (this.organisation = data));
    this.srvCompetence
      .getByNom('Orientation')
      .subscribe((data) => (this.orientation = data));
    this.srvCompetence
      .getByNom('Connaissance sur le monde animal')
      .subscribe((data) => (this.anim = data));
    this.srvCompetence
      .getByNom('Linguistique')
      .subscribe((data) => (this.linguistique = data));
    this.srvCompetence
      .getByNom('culture generale')
      .subscribe((data) => (this.culture = data));

      //initialisation inventaire

    this.inventaire={
      id : undefined,
      partie:undefined,
      nom:"nouvel inventaire",
      objets : [],
    };

    console.log(this.inventaire);
    this.srvInventaire.create(this.inventaire).subscribe((data)=>{this.inventaire.id=data.id});

    this.srvEvents.findById(1).subscribe((data)=>this.eventInit=data);

    this.personnage = {
      id: undefined,
      competences: [],
      humeur: undefined,
      isAlive: true,
      isCovided: false,
      force: 50,
      faim: 50,
      energie: 50,
      argent: undefined,
      poids: 60,
      nom: undefined,
      prenom: undefined,
    };
  }

  onSubmitForm() {

    console.log(this.formQuestionnaire.value);

    if (
      this.formQuestionnaire.get('nom')?.value==="" || this.formQuestionnaire.get('nom')?.value.isBlank ||
      this.formQuestionnaire.get('prenom')?.value===""  ||this.formQuestionnaire.get('prenom')?.value.isBlank ||
      this.formQuestionnaire.get('age')?.value===""  ||
      this.formQuestionnaire.get('weekend')?.value===""  ||
      this.formQuestionnaire.get('jeu')?.value===""  ||
      this.formQuestionnaire.get('saison')?.value==="" ||
      this.formQuestionnaire.get('matiere')?.value===""
    ) {
      this.isFormInvalid = true;
      console.log("champ invalide")
    } else {
      console.log("considere les verifs ok");
      this.personnage.prenom = this.formQuestionnaire.get('nom')?.value;
      this.personnage.nom = this.formQuestionnaire.get('prenom')?.value;


      let orga = 0;
      let socio = 0;
      let reac = 0;
      let orient = 0;
      let animaux = 0;
      let lingui = 0;
      let culturePt = 0;
      //to do : control aux boutons radios

      //verification age
      switch (this.formQuestionnaire.get('age')?.value) {
        case 0:
          //moins de 25 ans
          this.personnage.faim = this.personnage.faim! + 20;
          this.personnage.force = this.personnage.force! + 5;
          this.personnage.argent = 2800;
          this.personnage.energie = this.personnage.energie! + 20;
          break;
        case 1:
          this.personnage.force = this.personnage.force! + 10;
          this.personnage.faim = this.personnage.faim! + 7;
          this.personnage.argent = 4000;
          this.personnage.energie = this.personnage.energie! + 5;
          break;

        case 2:
          this.personnage.force = this.personnage.force! + 3;
          this.personnage.argent = 6000;
          break;

        case 3:
          this.personnage.faim = this.personnage.faim! - 7;
          this.personnage.argent = 7800;
          this.personnage.energie = this.personnage.energie! + 5;
          break;

        case 4:
          this.personnage.force = this.personnage.force! - 20;
          this.personnage.faim = this.personnage.faim! - 20;
          this.personnage.argent = 1000;
          this.personnage.energie = this.personnage.energie! - 25;
          culturePt++;
          break;
        default:
          console.log(this.formQuestionnaire.get('age'));
          break;
      }
      switch (this.formQuestionnaire.get('weekend')?.value) {
        case 0:
          //jogging
          this.personnage.force = this.personnage.force! + 5;
          this.personnage.poids = this.personnage.poids! - 10;
          break;
        case 1:
          //netflix
          this.personnage.energie = this.personnage.energie! + 10;
          this.personnage.poids = this.personnage.poids! + 10;
          lingui++;
          break;
        case 2:
          orga++;
          this.personnage.argent = this.personnage.argent! + 300;
          break;
        case 3:
          socio++;
          break;
      }
      switch (this.formQuestionnaire.get('jeu')?.value) {
        case 0:
          //rpg
          animaux++;
          break;
        case 1:
          orient++;
          break;
        case 2:
          orga++;
          break;
        case 3:
          reac++;
          break;
      }
      switch (this.formQuestionnaire.get('matiere')?.value) {
        case 0:
          orga++;
          break;

        case 1:
          lingui++;
          break;
        case 2:
          animaux++;
          break;
        case 3:
          culturePt++;
          break;
        case 4:
          orient++;
          break;
        case 5:
          this.personnage.force = this.personnage.force! + 10;
          reac++;
          break;
      }
      switch (this.formQuestionnaire.get('saison')?.value) {
        case 0:
          this.personnage.energie = this.personnage.energie! + 5;
          this.personnage.force = this.personnage.force! + 5;
          this.personnage.humeur = 'ENJOUEE';
          break;
        case 1:
          this.personnage.energie = this.personnage.energie! + 10;
          this.personnage.humeur = 'ENERVEE';
          break;
        case 2:
          this.personnage.argent = this.personnage.argent! + 500;
          this.personnage.humeur = 'NERVEUX';
          break;
        case 3:
          this.personnage.force = this.personnage.force! + 30;
          this.personnage.humeur = 'TRISTE';
          break;
      }

      if (socio >= 1) {
        this.personnage.competences!.push(this.sociabilite);
      }
      if (reac >= 1) {
        this.personnage.competences!.push(this.reactivite);
      }
      if (orga >= 1) {
        this.personnage.competences!.push(this.organisation);
      }
      if (orient >= 1) {
        this.personnage.competences!.push(this.orientation);
      }
      if (animaux >= 1) {
        this.personnage.competences!.push(this.anim);
      }
      if (lingui >= 1) {
        this.personnage.competences!.push(this.linguistique);
      }
      if (culturePt >= 1) {
        this.personnage.competences!.push(this.culture);
      }

      console.log(this.personnage);


      this.srvPersonnage.create(this.personnage).subscribe((data) => {
        let partie ={
          id: undefined,
          compte:this.compte,
          personnage : data,
          eventRunning : this.eventInit,
          environment:this.eventInit.environnementId,
          inventaire:this.inventaire,
          date:new Date()
        }
        console.log(partie);

        this.srvPartie.create(partie).subscribe((data2)=>{
          console.log(data2);
          //part sur la page du jeu en envoyant l'id de la partie
          this.router.navigateByUrl('/jeu/new/'+data2.id);
        })



      });


      //TO DO
      //attribution personnage à partie
      //redirection vers jeu
    }
  }
}
