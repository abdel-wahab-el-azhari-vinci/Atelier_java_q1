import java.util.ArrayList;

public class PizzaComposee extends Pizza {
    public static final int REMISE = 15;

    public PizzaComposee(String titre, String description, ArrayList<Ingredient> ingredients) {
        super(titre, description, ingredients);
    }
    public boolean ajouter (Ingredient ingredient){
         throw new UnsupportedOperationException(" Les ingrédients d'une pizza composée ne peuvent pas être modifiés");

    }
    public boolean supprimer (Ingredient ingredient){
        throw new UnsupportedOperationException(" Les ingrédients d'une pizza composée ne peuvent pas être modifiés");

    }
    public double calculerPrix(){
        double valeur=super.calculerPrix() *((REMISE/100.0));
        double prix_final= super.calculerPrix()-valeur;
      return Math.ceil(prix_final) ;
    }




}
