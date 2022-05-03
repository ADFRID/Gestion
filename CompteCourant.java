/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import gestion.ICompteCCEE;
import gestion.ICompteCourant;

/**
 *
 * @author admin
 */
public class CompteCourant extends Compte implements ICompteCourant, ICompteCCEE {
    public Double decouvert;
    
    public void setDecouvert(double decouvert){
        this.decouvert=decouvert;
    }
    public double getDecouvert(){
        return this.decouvert;
    }
    public CompteCourant(String numero, double solde, double decouvert){
        super(numero, solde);
        setDecouvert(decouvert);
        
    }
    @Override
    public boolean virer(double montant, Compte unCompte){
        boolean accept=true;
       if(montant<=unCompte.getSolde())
           return accept;
       else
           return accept=false;
    }
    
    @Override
    public boolean retirer(double montant){
      boolean accept=true;
       if(montant<=getSolde())
           return accept;
       else
           return accept=false;
          
       }
    }
    
    
   

