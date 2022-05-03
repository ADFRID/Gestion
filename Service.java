/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author admin
 */
public class Service {
    private String libelle;
    private Double prime;
    
    private void setLibelle(String libelle){
        this.libelle=libelle;
    }
    private String getLibelle(){
        return libelle;
    }
    private void setPrime(double prime){
        this.prime=prime;
    }
    public double getPrime(){
        return prime;
    }
    
    public Service(String lib, double prime){
        setLibelle(lib);
        setPrime(prime);
    }
        
}
