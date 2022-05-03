/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import gestion.ICompte;

/**
 *
 * @author admin
 */
public class Compte implements ICompte {
    private String numero;
    protected Double solde;
    
    public void setNumero(String n){
        this.numero=n;
    }
    public String getNumero(){
        return this.numero;
    }
    public void setSolde(double s){
        this.solde=s;
    }
    public Double getSolde(){
        return this.solde;
    }
    public Compte(String numero, double solde){
        setNumero(numero);
        setSolde(solde);
    }
    @Override
    public void verser(double montant){
        
    }
    
}
