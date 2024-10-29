package main;

import domaine.Trader;
import domaine.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ExercicesDeBase {

    /**
     * La liste de base de toutes les transactions.
     */
    private List<Transaction> transactions;

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
        System.out.println("Les transactions " + transactions);
        ExercicesDeBase main = new ExercicesDeBase(transactions);
        main.run();
    }



    /**
     * Crée un objet comprenant toutes les transactions afin de faciliter leur usage pour chaque point de l'énoncé
     *
     * @param transactions la liste des transactions
     */
    public ExercicesDeBase(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Exécute chaque point de l'énoncé
     */
    public void run() {
        this.predicats1();
        this.predicats2();
        this.predicats3();
        this.map1();
        this.map2();
        this.map3();
        this.sort1();
        this.sort2();
        this.reduce1();
        this.reduce2();
    }

    private void predicats1() {
        System.out.println("predicats1");
        Stream<Transaction> s = transactions
                .stream()
                 .filter (t -> t.getYear()==2011 );
                // TODO filtrer
        System.out.println("sout du Stream brut" + s);
        s.forEach(System.out::println);
    }

    private void predicats2() {

        System.out.println("predicats2");
        var s = transactions
                .stream()
                .filter(t -> t.getValue()>600);// TODO filtrer

        s.forEach(System.out::println);
    }


    private void predicats3() {

        System.out.println("predicats3");
        var s = transactions
                .stream()
        .filter( t   -> t.getTrader().getName()=="Raoul");// TODO filtrer
        s.forEach(System.out::println);
    }

    private void map0() {
        System.out.println("map0");
        var s = transactions
        .stream()
                .map(Transaction :: getTrader);
        // TODO transformer

    }
    private void map1() {
        System.out.println("map1");
        var s = transactions
                .stream()
                .map(t -> t.getTrader().getCity());
                 s.forEach(System.out:: println);


    }

    private void map2() {
        System.out.println("map2");
        var s = transactions
                .stream()
                .map(t -> Objects.equals(t.getTrader().getCity(), "Cambridge"));
        s.forEach(System.out:: println);
        // TODO transformer
    }

    private void map3() {

        System.out.println("map3");
        var transcTriees = transactions
                .stream()
                .map(t -> t.getTrader().getName())
                .collect(Collectors.joining(","));
        System.out.println(transcTriees);

    }
    private void sort1() {
        System.out.println("sort1");
        var transcTriees = transactions
                .stream()
                .sorted(Comparator.comparingInt(Transaction::getValue).reversed());// TODO trier
        transcTriees.forEach(System.out::println);
    }

    private void sort2() {
        System.out.println("sort2");
        var nomsTries = transactions
                .stream()
                        .sorted(Comparator.comparing(t ->t.getTrader().getName()));
        // TODO trier
		System.out.println(nomsTries);
    }
    private void reduce1() {
        System.out.println("reduce1");

                var table=transactions
                        .stream()
                        .map(Transaction::getValue)

                        // TODO reduce
                        .reduce(Integer.MIN_VALUE,(v1,v2) -> v1>v2 ? v1 : v2);
        System.out.println(table);
    }

    private void reduce2() {
        System.out.println("reduce2");
        Trader trader=new Trader("har","BB");
        Transaction tr=new Transaction( trader,2000,Integer.MAX_VALUE);
        var tranc=transactions
                .stream()
                .reduce(tr, (t1,t2)-> t1.getValue()<t2.getValue() ? t1 : t2);
        System.out.println(tranc);

        // TODO reduce
    }

}