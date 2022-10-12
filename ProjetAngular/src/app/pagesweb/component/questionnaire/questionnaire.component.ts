import { Router } from '@angular/router';
import { PersonnageService } from './../../service/personnage.service';
import { CompetenceService } from './../../service/competence.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Competence } from '../../model/competence';
import { Personnage } from '../../model/personnage';

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css'],
})
export class QuestionnaireComponent implements OnInit {
  formQuestionnaire!: FormGroup;
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

  constructor(private srvCompetence:CompetenceService, private srvPersonnage:PersonnageService, private router:Router) {}

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
  }

  onSubmitForm() {

    console.log(this.formQuestionnaire.value);


    let orga=0;
    let socio=0;
    let reac=0;
    let orient=0;
    let animaux=0;
    let lingui=0;
    let culture=0;


    let personnage: Personnage = {
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
      prenom: this.formQuestionnaire.get('nom')?.value,
      nom: this.formQuestionnaire.get('prenom')?.value,
    };
    //to do : control aux boutons radios

    //verification age
    switch (this.formQuestionnaire.get('age')?.value) {
      case 0:
        //moins de 25 ans
        personnage.faim = personnage.faim! + 20;
        personnage.force = personnage.force! + 5;
        personnage.argent = 2800;
        personnage.energie = personnage.energie! + 20;
        break;
      case 1:
        personnage.force = personnage.force! + 10;
        personnage.faim = personnage.faim! + 7;
        personnage.argent = 4000;
        personnage.energie = personnage.energie! + 5;
        break;

      case 2:
        personnage.force = personnage.force! + 3;
        personnage.argent = 6000;
        break;

      case 3:

        personnage.faim = personnage.faim! -7;
        personnage.argent = 7800;
        personnage.energie = personnage.energie! + 5;
        break;

      case 4:
        personnage.force = personnage.force! -20;
        personnage.faim = personnage.faim! -20;
        personnage.argent = 1000;
        personnage.energie = personnage.energie! -25;
        culture++;
        break;
      default:
        console.log(this.formQuestionnaire.get('age'));
        break;
    }
    switch (this.formQuestionnaire.get('weekend')?.value){
      case 0:
        //jogging
        personnage.force = personnage.force! +5;
        personnage.poids= personnage.poids! -10;
        break;
      case 1:
        //netflix
        personnage.energie=personnage.energie!+10;
        personnage.poids= personnage.poids! +10;
        lingui++;
        break;
      case 2:
        orga++;
        personnage.argent=personnage.argent!+300;
        break;
      case 3:
        socio++;
        break;
    }
    switch (this.formQuestionnaire.get('jeu')?.value){
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
    switch (this.formQuestionnaire.get('matiere')?.value){
      case 0:
        orga++;
        break;

      case 1:
        lingui++;
        break;
      case 2 :
        animaux++;
        break;
      case 3:
        culture++;
        break;
      case 4:
        orient ++;
        culture++;
        break;
      case 5:
        personnage.force=personnage.force!+10;
        reac++;
        break;
    }
    switch (this.formQuestionnaire.get('saison')?.value){
      case 0:
        personnage.energie=personnage.energie!+5;
        personnage.force=personnage.force!+5;
        personnage.humeur='ENJOUEE';
        break;
      case 1:
        personnage.energie=personnage.energie!+10;
        personnage.humeur='ENERVEE';
        break;
      case 2:
        personnage.argent=personnage.argent!+500;
        personnage.humeur='NERVEUX';
        break;
      case 3:
        personnage.force=personnage.force!+30;
        personnage.humeur='TRISTE';
        break;
    }

    if(socio>=1){
      //this.srvCompetence.getByNom("sociabilite").subscribe((data)=>console.log(data));
      //Ajout compétence socio aux compétences du perso
      this.srvCompetence.getByNom("sociabilite").subscribe((data)=>{personnage.competences?.push(data); console.log(data)});

    }
    if(reac>=1){
      this.srvCompetence.getByNom("reactivite").subscribe((data)=>personnage.competences?.push(data));
    }
    if(orga>=1){
      this.srvCompetence.getByNom("Organisation").subscribe((data)=>personnage.competences?.push(data));
    }
    if(orient>=1){
      this.srvCompetence.getByNom("Orientation").subscribe((data)=>personnage.competences?.push(data));
    }
    if(animaux>=1){
      this.srvCompetence.getByNom("Connaissance sur le monde animal").subscribe((data)=>personnage.competences?.push(data));
    }
    if(lingui>=1){
      this.srvCompetence.getByNom("Linguistique").subscribe((data)=>personnage.competences?.push(data));
    }
    if(culture>=1){
      this.srvCompetence.getByNom("culture generale").subscribe((data)=>personnage.competences?.push(data));
    }

    console.log(personnage);

    this.srvPersonnage.create(personnage).subscribe((data)=>{
      personnage.id=data.id;
      this.router.navigateByUrl('/jeu');
    });
    //TO DO
    //attribution personnage à partie
    //redirection vers jeu
  }
}
