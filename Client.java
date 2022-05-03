/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Client {
    private String nom;
    private String prenom;
    private List<CompteEpargne> lesCompteEpargne;
    private List<CompteCourant> lesCompteCourant;
    
    private void setNom(String nom){
        this.nom=nom;
    }
    public String getNom(){
        return nom;
    }
    private void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public String getPrenom(){
        return prenom;
    }
    
    
    private void setLesCompteEpargne(List<CompteEpargne>lesCompteepargne){
        if(lesCompteepargne==null)
            this.lesCompteEpargne= new ArrayList<CompteEpargne>();
        else
            this.lesCompteEpargne=lesCompteepargne;
    }
    public List<CompteEpargne> getLesCompteEpargne(){
        return lesCompteEpargne;
    }
    
    private void setLesCompteCourant(List<CompteCourant>lesComptecourant){
        if(lesComptecourant==null)
            this.lesCompteCourant= new ArrayList<CompteCourant>();
        else
            this.lesCompteCourant=lesComptecourant;
    }
    public List<CompteCourant> getLesCompteCourant(){
        return lesCompteCourant;
    }
    
    
    
    public Client(String nom, String prenom){
        setNom(nom);
        setPrenom(prenom);
        setLesCompteCourant(lesCompteCourant);
        setLesCompteEpargne(lesCompteEpargne);
    }
    public void ajouterCompteCourant(CompteCourant unCompteCourant){
        lesCompteCourant.add(unCompteCourant);
    }
    public void ajouterCompteEpargne(CompteEpargne unCompteEpargne){
        lesCompteEpargne.add(unCompteEpargne);
    }
    public double calculerPatrimoine(){
        double patrimoine=0;
        for(int i=0;i<getLesCompteEpargne().size();i++){
            CompteEpargne unCompteEpargne=getLesCompteEpargne().get(i);
            patrimoine=patrimoine+unCompteEpargne.getSolde();
        }
        for(int i=0;i<getLesCompteCourant().size();i++){
            CompteCourant unCompteCourant=getLesCompteCourant().get(i);
            patrimoine=patrimoine+unCompteCourant.getSolde();
        }
        return patrimoine;
    }
}
