package hu.petrik.bejegyzes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Bejegyzes> bejegyzesList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Mennyi bejegyzést szeretne hozzáadni a listához: ");
        int inNum = 0;
        try {
            inNum=sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println(e);
            return;
        }

        for (int i = 0; i < inNum; i++) {
            bejegyzesList.add(new Bejegyzes("author"+i, "content"+i));
        }

        File fileName = new File("bejegyzesek.csv");
        Scanner scR = null;
        try {
            scR=new Scanner(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scR.hasNextLine()){
            String[] temp = scR.nextLine().split(";");
            bejegyzesList.add(new Bejegyzes(temp[0],temp[1]));
        }

        for (int i = 0; i < bejegyzesList.size()*20; i++) {
            if ((Math.random()*1)==1){
                bejegyzesList.get(i).like();
            }
        }
    }
}
