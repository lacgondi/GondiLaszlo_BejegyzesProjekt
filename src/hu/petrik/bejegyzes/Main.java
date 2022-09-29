package hu.petrik.bejegyzes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static <T> void main(String[] args) {
        List<Bejegyzes> bejegyzesList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Mennyi bejegyzést szeretne hozzáadni a listához: ");
        int inNum = 0;
        try {
            inNum = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(e);
            return;
        }

        for (int i = 0; i < inNum; i++) {
            bejegyzesList.add(new Bejegyzes("author" + i, "content" + i));
        }

        File fileName = new File("bejegyzesek.csv");
        Scanner scR = null;
        try {
            scR = new Scanner(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scR.hasNextLine()) {
            String[] temp = scR.nextLine().split(";");
            bejegyzesList.add(new Bejegyzes(temp[0], temp[1]));
        }

        for (int i = 0; i < bejegyzesList.size(); i++) {
            for (int j = 0; j < 20; j++) {
                bejegyzesList.get((int) (Math.random() * bejegyzesList.size())).like();
            }
        }

        System.out.print("Adja meg a nevét: ");
        String nameIn=sc.nextLine();
        System.out.print("Adjon meg egy szöveget: ");
        String contentIn = sc.nextLine();
        bejegyzesList.get(1).setAuthor(nameIn);
        bejegyzesList.get(1).setContent(contentIn);

        for (int i = 0; i < bejegyzesList.size(); i++) {
            System.out.println(bejegyzesList.get(i).toString());
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < bejegyzesList.size(); i++) {
            if (bejegyzesList.get(i).getLikes() > max) {
                max = bejegyzesList.get(i).getLikes();
                maxIndex = i;
            }
        }
        System.out.println("A legnépszerűbb bejegyzés: " + bejegyzesList.get(maxIndex).toString());

        boolean _35OrMore = false;
        for (int j = 0; j < bejegyzesList.size(); j++) {
            if (bejegyzesList.get(j).getLikes() > 35) {
                _35OrMore = true;
            }
        }
        if (_35OrMore == true) {
            System.out.println("Van olyan poszt aminek 35-nél több likeja van");
        } else {
            System.out.println("Nincs olyan poszt aminek 35-nél több likeja van");
        }

        int counter = 0;
        for (int j = 0; j < bejegyzesList.size(); j++) {
            if (bejegyzesList.get(j).getLikes() > 15) {
                counter++;
            }
        }
        System.out.printf("%d darab olyan bejegyzés van ami 15 like-nál többet kapott", counter);

        Collections.reverse(bejegyzesList);
        for (int i = 0; i < bejegyzesList.size(); i++) {
            System.out.println(bejegyzesList.get(i));
        }
    }
}
