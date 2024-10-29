package domaine;

import java.time.Duration;
import java.util.*;

public class Plat {

    private String nom;
    private int nbPersonnes;
    private Difficulte niveauDeDifficulte;
    private Cout cout;
    private Duration dureeEnMinutes;
    private ArrayList<Instruction> recette=new ArrayList<Instruction>();
    private Set ingredients =new HashSet<>();

    public Plat(String nom, int nbPersonnes, Difficulte niveauDeDifficulte, Cout cout) {
        this.nom = nom;
        this.nbPersonnes = nbPersonnes;
        this.niveauDeDifficulte = niveauDeDifficulte;
        this.cout = cout;
        this.dureeEnMinutes=Duration.ofMinutes(0);
    }

    public String getNom() {
        return nom;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public Difficulte getNiveauDeDifficulte() {
        return niveauDeDifficulte;
    }

    public Cout getCout() {
        return cout;
    }

    public Duration getDureeEnMinutes() {
        return dureeEnMinutes;
    }
    public void insererInstruction(int position, Instruction instruction){
        if(position<=0 || position>recette.size()){
            throw new IllegalArgumentException();
        }

        recette.add(position-1, instruction);
        dureeEnMinutes=dureeEnMinutes.plus(instruction.getDureeMinutes());

    }
    public void ajouterInstruction (Instruction instruction){
        recette.add(instruction);
        dureeEnMinutes=dureeEnMinutes.plus(instruction.getDureeMinutes());


    }
    public Instruction remplacerInstruction (int position, Instruction instruction){
        if(recette.get(position-1)==null){
            throw new IllegalArgumentException();
        }
        Instruction instruction1=recette.get(position-1);
        recette.set(position-1, instruction);
        dureeEnMinutes=dureeEnMinutes.minus(instruction1.getDureeMinutes());
        dureeEnMinutes=dureeEnMinutes.plus(instruction.getDureeMinutes());


        return instruction1;
    }
    public Instruction supprimerInstruction (int position){
        Instruction instruction1=recette.get(position-1);
        recette.remove(position-1);
        dureeEnMinutes=dureeEnMinutes.minus(instruction1.getDureeMinutes());
        return instruction1;
    }
    public List<Instruction> instructions(){
        return Collections.unmodifiableList(recette);
    }




    public enum Difficulte{
        X, XX, XXX, XXXX , XXXXX;

        @Override
        public String toString() {
            return super.toString().replaceAll("X","*");
        }
    }


    public enum Cout{
        $, $$, $$$, $$$$ ,$$$$$ ;

        @Override
        public String toString() {
            return super.toString().replace("$","€");
        }
    }

    public String toString() {
        String hms = String.format("%d h %02d m", dureeEnMinutes.toHours(), dureeEnMinutes.toMinutes()%60);
        String res = this.nom + "\n\n";
        res += "Pour " + this.nbPersonnes + " personnes\n";
        res += "Difficulté : " + this.niveauDeDifficulte + "\n";
        res += "Coût : " + this.cout + "\n";
        res += "Durée : " + hms + " \n\n";
        res += "Ingrédients :\n";
      /* for (IngredientQuantifie ing : this.ingredients) {
            res += ing + "\n";
        }
        */

        int i = 1;
        res += "\n";
        for (Instruction instruction : this.recette) {
            res += i++ + ". " + instruction + "\n";
        }
        return res;
    }

}
