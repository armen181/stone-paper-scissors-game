package armen.springbootfirstprogram.console;

import armen.springbootfirstprogram.Game;
import armen.springbootfirstprogram.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
@Component
public class ConsoleGamePlay {

    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;

    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Start() --> Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(messageGenerator.getMainMessage());
//            stone = 1;
//            paper = 2;
//            scissors = 3

            System.out.println("Please enter number from 1 to 3, where 1 = stone, 2 = paper and 3 = scissors. ");

            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                if(value>=1&&value<=3) {
                    game.randomValueGenerator();
                    game.setValue(value);

                    System.out.println(messageGenerator.getResultMessage());


                    if (game.isGameWon() == 1) {
                        System.out.println("Play again y/n?");

                        String playAgainString = scanner.nextLine().trim();
                        if (!playAgainString.equalsIgnoreCase("y")) {
                            break;
                        }

                        //game.reset();
                    }
                } else {
                    System.out.println("invalid input");
                }

            } catch (InputMismatchException e) {
                System.out.println("invalid input");
                scanner.nextLine();


            }




            }
        }
    }
