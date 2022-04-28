package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  /**
   * Main method.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    ArrayList<Integer> ages = new ArrayList<Integer>();

    short chosenOption = 1;

    do {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n" + "2 - Finalizar sistema e mostrar relatório");
      chosenOption = scan.nextShort();

      if (chosenOption == 1) {
        System.out.println("Entre com a idade:");
        int age = scan.nextInt();

        if (age < 18) {
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (age >= 18 && age <= 49) {
          System.out.println("Pessoa adulta, catraca liberada!");
        } else {
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }

        ages.add(age);

      } else if (chosenOption != 1 && chosenOption != 2) {
        System.out.println("Entre com uma opção válida!");
        chosenOption = 1;
      }
    } while (chosenOption == 1);

    scan.close();

    double totalVisits = ages.size();
    double totalMinors = 0;
    double totalAdults = 0;
    double totalSeniors = 0;

    for (int i = 0; i < totalVisits; i += 1) {
      int currAge = ages.get(i);

      if (currAge < 18) {
        totalMinors += 1;
      } else if (currAge >= 18 && currAge <= 49) {
        totalAdults += 1;
      } else if (currAge > 49) {
        totalSeniors += 1;
      }
    }

    DecimalFormat decimalFormat = new DecimalFormat("##.##%");

    String minorPercentage = decimalFormat.format((double) (totalMinors) / (totalVisits));

    String adultPercentage = decimalFormat.format((double) (totalAdults) / (totalVisits));

    String seniorPercentage = decimalFormat.format((double) (totalSeniors) / (totalVisits));

    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + totalMinors);
    System.out.println("adultas: " + totalAdults);
    System.out.println("a partir de 50: " + totalSeniors + "\n");

    System.out.println("----- Percentual -----");
    System.out.println("menores: " + minorPercentage + "%");
    System.out.println("adultas: " + adultPercentage + "%");
    System.out.println("a partir de 50: " + seniorPercentage + "%" + "\n");

    System.out.println("TOTAL: " + totalVisits);
  }
}
