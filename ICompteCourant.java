/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import metier.Compte;

/**
 *
 * @author admin
 */
public interface ICompteCourant {
    public abstract boolean virer(double montant, Compte compte);
}
