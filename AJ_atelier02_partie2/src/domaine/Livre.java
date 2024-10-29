package domaine;

import com.sun.source.tree.NewArrayTree;

import java.util.*;


public class Livre {
   HashMap<Plat.Type, SortedSet<Plat>> plats=new HashMap<>();

   public boolean ajouterPlat(Plat plat){
       if(plat==null){
           throw new IllegalArgumentException();
       }
      if(plats.containsKey(plat.getType())){
         return false;
      }
       TreeSet<Plat> sortedset= new TreeSet<>( new Comparator<Plat>(){
           public int compare(Plat p1, Plat p2) {

               if(p1.getNiveauDeDifficulte().equals(p2.getNiveauDeDifficulte())){
                   return p1.getNom().compareTo(p2.getNom());
               }

               return p1.getNiveauDeDifficulte().compareTo(p2.getNiveauDeDifficulte());



           }
       });
        sortedset.add(plat);
        plats.put(plat.getType(),sortedset);

      return true;
   }

    public boolean supprimerPlat (Plat plat) {
       return plats.remove(plat.getType(), plat);
    }


    public SortedSet<Plat> getPlatsParType(Plat.Type type) {

       TreeSet<Plat> set=new TreeSet<>();
        for (Plat.Type type1 : plats.keySet()) {
            if (type1.equals(type)) {


                for (SortedSet<Plat> value : plats.values()) {
                       Plat plat=(Plat) value;
                       set.add(plat);
                }
                break;
            }
        };

        return set;
    }

    public boolean contient(Plat plat) {
        for (Plat.Type type1 : plats.keySet()) {
            if (type1.equals(plat.getType())) {


                for (SortedSet<Plat> value : plats.values()) {
                    Plat plat1=(Plat) value;
                    if(plat.getNom().equals(plat1.getNom())&&plat.getNiveauDeDifficulte().equals(plat1.getNiveauDeDifficulte())){
                          return true;
                    }
                }
            }
        }
        return false;
       }

    public Set<Plat> tousLesPlats() {
       Set<Plat> set=new HashSet<>();
        for (SortedSet<Plat> value : plats.values()) {
            Plat plat=(Plat)value;
            set.add(plat);
        }

        return set;
   }


        @Override
    public String toString() {
        String str="je ne sais pas!"+"\n"+"===="+"\n";
        for (Plat.Type type : plats.keySet()) {
            str+=type;
            for (SortedSet<Plat> value : plats.values()) {
                str+=value;
            }
        };
        return str;
    }

}
