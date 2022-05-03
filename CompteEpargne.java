/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import gestion.ICompteCCEE;
import gestion.ICompteEpargne;
import java.util.Date;

/**
 *
 * @author admin
 */
public class CompteEpargne extends Compte implements ICompteCCEE, ICompteEpargne {
    private Date dateCreation;
    private Double tauxInterets;
    
    public void setDateCreation(Date date){
        this.dateCreation=date;
    }
    public Date getDateCreation(){
        return this.dateCreation;
    }
    public void setTauxInterets(Double taux){
        this.tauxInterets=taux;
    }
    public Double getTauxInterets(){
        return this.tauxInterets;
    }
    public CompteEpargne(String numero, double solde, Date date, Double taux){
        super(numero, solde);
        setDateCreation(date);
        setTauxInterets(taux);
    }
    
    @Override
    public double calculInterets(){
        double interet;
        interet=super.getSolde()*(1+getTauxInterets());
        return interet;
    }
    @Override
    public double calculInterets(int annee){
        double interet;
        interet = super.getSolde()*getTauxInterets()*(annee-Outils.getAnnee(dateCreation)); 
        return interet;
    }
    
    @Override
    public boolean retirer(double montant){
       boolean accept=true;
       if(montant<=getSolde())
           return accept;
       else
           return accept=false;
    }
    
   
    public Double getSolde(){
      // solde=super.getSolde()+calculInterets(2021);
       return super.getSolde()+calculInterets(2021);
    }
}
