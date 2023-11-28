package org.example;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int cyclesCount = 1000; // счётчик, собираем статистику на основе 1000 игр
        int positiveResults = 0;
        int negativeResults = 0;

        HashMap<Integer, Boolean> results = new HashMap<>();

        // Моделируем игру в угадай дверь
        for (int step = 1; step <= cyclesCount; step++) {
            boolean result = playMontyHall();
            results.put(step, result);

            if (result) {
                positiveResults++;
            } else {
                negativeResults++;
            }
        }

        // Выводим статистику
        System.out.println("Wins: " + positiveResults);
        System.out.println("Looses: " + negativeResults);
        System.out.println("Win percent: " + ((double) positiveResults / cyclesCount) * 100 + "%");
    }

    private static boolean playMontyHall() {
        Random random = new Random();
        int prizeDoor = random.nextInt(3) + 1; // Дверь с призом
        int initialChoice = random.nextInt(3) + 1; // Первоначальный выбор двери


        int revealedDoor; // подбираем дверь, за которой нету приза и которую не выбрал игрок
        do {
            revealedDoor = random.nextInt(3) + 1;
        } while (revealedDoor == prizeDoor || revealedDoor == initialChoice);


        int secondChoice; // второй выбор игрока
        do {
            secondChoice = random.nextInt(3) + 1;
        } while (secondChoice == initialChoice || secondChoice == revealedDoor);

        return secondChoice == prizeDoor; // true, если за выбранной дверью приз.
    }
}
