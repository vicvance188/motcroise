package pobj.motx.tme1;

import java.util.List;
import java.util.ArrayList;


/**
 * Classe representant un emplacement de mot present dans notre grille
 *
 */
public class Emplacement {
  private List<Case> lettres; /** Un Emplacement correpond à une liste de case non pleine */

  /**
   * Constructeur de Emplacement consistant à creer une liste de Case
   */
  public Emplacement() {
    lettres = new ArrayList<Case>();
  }

  /**
   * permet d'afficher notre emplacement (les caractère constituant les mots à cet emplacement
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Case lettre : lettres) {
      sb.append(lettre.getChar());
    }
    return sb.toString();
  }

  /**
   * @return la taille de notre emplacement
   */
  public int size() {
    return lettres.size();
  }

  /**
   * méthode permettant d'ajouter une case à notre emplacement
   * @param c une Case à ajouter à notre emplacement
   */
  public void add(Case c) {
    lettres.add(c);
  }

  /**
   * retourne la case à l'indice i
   * @param i indice de la case à retourner
   * @return la case
   */
  public Case get(int i) {
    return lettres.get(i);
  }

  /**
   * retourne la liste des lettres de l'emplacement
   * @return la liste
   */
  public List<Case> getLettres(){
    return lettres;
  }

  /**
   * teste si l'emplacement contient au moins une case vide
   * @return true si l'emplacement contient au moins une case vide,
   *          false sinon
   */
  public boolean hasCaseVide() {
    for (Case c : lettres) {
      if (c.isVide())
        return true;
    }
    return false;
  }
}
