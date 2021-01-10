import { Niveau } from './niveau';
import { Filiere } from './filiere';
export class Etudiant {

    matricule: string;
    nom: string;
    prenom: string;
    datenais: Date;
    lieu: string;
    email: string;
    tel: number;
    pw: string;
    etatinscription: number;
    anneeaca: number;
    filiere: Filiere = new Filiere();
    niveau: Niveau = new Niveau();

}
