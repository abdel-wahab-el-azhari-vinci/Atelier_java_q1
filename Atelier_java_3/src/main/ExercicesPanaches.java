
package main;

import domaine.Trader;
import domaine.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExercicesPanaches {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        ExercicesPanaches main = new ExercicesPanaches(transactions);
        main.run();
    }

    private List<Transaction> transactions;

    public ExercicesPanaches(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void run() {
        // Complete the methods below based on the exercise descriptions
        exercice1();
        exercice2();
        exercice3();
        exercice4();
        exercice5();
        exercice6();
    }

    private void exercice1() {
        System.out.println("exercise 1 :");

                Integer max=transactions
                .stream()
                .filter(t->t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce((t1,t2)-> t1>t2 ? t1 : t2)
                        .orElse(-1);

        System.out.println(max);
        // TODO: Filter transactions of Cambridge, map to their values, and find max.
    }

    private void exercice2() {
        System.out.println("exercise 2 :");

        Map<Trader,Long> listeTrader=transactions
                .stream()
                .filter(t->t.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.groupingBy(Transaction::getTrader,Collectors.counting()));
        System.out.println(listeTrader);

        // TODO: Filter transactions for traders in Cambridge, group by trader, and count their transactions.
    }

    private void exercice3() {
        System.out.println("exercise 3:");
        var list=transactions
                .stream()
                .filter(t->t.getValue()>500)
                .map(t->t.getTrader().getName())
                .sorted(Comparator.comparing(String::length))
                .reduce("re",(t1,t2)->t1.length()>t2.length() ?t1 :t2);
        System.out.println(list);

        // TODO: Filter transactions over 500, map trader names, sort by name length, find the longest.
    }

    private void exercice4() {
        var list=transactions
                .stream()
                .collect(Collectors.groupingBy( t->t.getTrader().getCity(),Collectors.averagingDouble(Transaction::getValue)));


        System.out.println(list);
        // TODO: Group transactions by city, map to transaction values, and compute the average.
    }

    private void exercice5() {
        System.out.println("exersice 5");
        var list=transactions
                .stream()
                .filter(t->t.getTrader().getCity().equals("Milan"))
                .map(Transaction::getValue)
                .reduce(Integer.MAX_VALUE,(t1,t2)-> t1<t2 ?t1:t2);
        System.out.println(list);
        // TODO: Filter transactions in Milan, map to values, find the min, and handle empty results.
    }
    private void exercice6() {
        System.out.println("exercise 6:");
        var list=transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getYear));
        System.out.println(list);
        // TODO: group transaction by year 
    }
}
