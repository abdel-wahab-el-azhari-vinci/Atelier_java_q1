package main;

import domaine.Employe;

import java.util.Collection;
import java.util.function.Consumer;

public class FuctionForeach implements Consumer<Employe> {

    @Override
    public void accept(Employe employe) {
         System.out.println(employe);
    }
}