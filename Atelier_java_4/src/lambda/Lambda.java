package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {

    /**
     * Retourne une liste contenant uniquement les Integer qui correspondent
     * au predicat match
     * @param list La liste d'Integer originale
     * @param match le predicat à respecter
     * @return une liste contenant les integer qui respectent match
     */
    public static <T> List<T> allMatches(List<T> list, Predicate<T> match) {
        List<T> list1=new ArrayList<>();
        for (T i : list) {
            if(match.test(i)){
                list1.add(i);
            }
        }
        return list1;
    }

    /**
     * Retourne une liste contenant tous les éléments de la liste originale, transformés
     * par la fonction transform
     * @param list La liste d'Integer originale
     * @param transform la fonction à appliquer aux éléments
     * @return une liste contenant les integer transformés par transform
     */
    public static <T, R> List<R> transformAll(List<T> list, Function<T, R> transform) {
        List<R>list1=new ArrayList<>();

        for (T i : list) {
            R nbEntier=transform.apply(i);
            list1.add(nbEntier);

        }
        return list1;
    }



    public static <T> List<T> filter(List<T> list, Predicate<T> match) {

        var list1= list.stream()
                .filter(match);


        return  list1.toList();


    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> transform) {

        var list1= list.stream()
                .map(transform);
        return  list1.toList();


    }


}
