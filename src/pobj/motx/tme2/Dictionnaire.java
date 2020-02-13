package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

  // stockage des mots
  private List<String> mots = new ArrayList<>();
  private EnsembleLettre [] cache = null;

  public static Dictionnaire loadDictionnaire(String path) {
    Dictionnaire dico = new Dictionnaire();
    // Try-with-resource : cette syntaxe permet d’accéder au contenu du fichier ligne par ligne.
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      for (String line = br.readLine(); line !=null; line = br.readLine()) {
        dico.add(line);
      }
    } catch(IOException e) {
      // Problème d’accès au fichier.
      e.printStackTrace();
    }
    return dico;
  }

  /**
   * Ajoute un mot au Dictionnaire, en dernière position.
   * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
   */
  public void add(String mot) {
    mots.add(mot.toLowerCase());
  }

  /**
   * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
   * @return la taille
   */
  public int size() {
    return mots.size();
  }

  /**
   * Accès au i-eme mot du dictionnaire.
   * @param i l'index du mot recherché, compris entre 0 et size-1.
   * @return le mot à cet index
   */
  public String get(int i) {
    return mots.get(i);
  }

  public List<String> getMots(){
    return mots;
  }

  /**
   * Rend une copie de ce Dictionnaire.
   * @return une copie identique de ce Dictionnaire
   */
  public Dictionnaire copy() {
    Dictionnaire copy = new Dictionnaire();
    copy.mots.addAll(mots);
    copy.cache = cache;
    return copy;
  }

  /**
   * Retire les mots qui ne font pas exactement "len" caractères de long.
   * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
   * @param len la longueur voulue
   * @return le nombre de mots supprimés
   */
  public int filtreLongueur(int len) {
    List<String> cible = new ArrayList<>();
    int cpt=0;
    for (String mot : mots) {
      if (mot.length() == len)
        cible.add(mot);
      else
        cpt++;
    }
    mots = cible;
    if (cpt > 0)
      cache = null;
    return cpt;
  }

  /**
   * filtre le dictionnaire avec uniquement les mots contenant la lettre c à l'emplacement i
   * @param c caractère que nous souhaitons garder
   * @param i emplacement du dit caractère
   * @return le nombre de mots supprimés
   */
  public int filtreParLettre(char c, int i) {
    List<String> cible = new ArrayList<>();
    int cpt=0;
    for (String mot : mots) {
      if (mot.charAt(i) == c)
        cible.add(mot);
      else
        cpt++;
    }
    mots = cible;
    if (cpt > 0)
      cache = null;
    return cpt;
  }

  /**
   * filtre le dictionnaire avec uniquement les mots contenant les lettres dans e à l'emplacement i
   * @param e ensemble de caractères que nous souhaitons garder
   * @param i emplacement du dit caractère
   * @return le nombre de mots supprimés
   */
  public int filtreParLettres(EnsembleLettre e, int i) {
    List<String> cible = new ArrayList<>();
    int cpt=0;
    for (String mot : mots) {
      if (e.contains(mot.charAt(i)))
        cible.add(mot);
      else
        cpt++;
    }
    mots = cible;
    if (cpt > 0)
      cache = null;
    return cpt;
  }

  /**
   * renvoie l’EnsembleLettre possible à une position donnée
   * @param i emplacement du dit caractère
   * @return l'ensemble
   */
  public EnsembleLettre lettresPosition(int index) {
    EnsembleLettre res = new EnsembleLettre();
    if (mots.isEmpty())
      return res;
    if (cache == null)
      cache = new EnsembleLettre[mots.get(0).length()];
    if (cache[index] == null) {
      for (String s : mots) {
        res.add(s.charAt(index));
      }
      cache[index] = res;
    }
    return cache[index];
  }

  @Override
  public String toString() {
    if (size() == 1) {
      return mots.get(0);
    } else {
      return "Dico size =" + size();
    }
  }

}
