package Problem02.MagicCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        countCards();
    }

    private static void countCards() {
        Scanner scanner = new Scanner(System.in);
        List<String> messages = new ArrayList<>();
        String cardSequence = scanner.nextLine();
        String cardOrder = scanner.nextLine();
        String magicCard = scanner.nextLine();
        int sumCards = countSumOfCards(cardSequence, cardOrder, magicCard);

        System.out.println(sumCards);
    }

    private static int countSumOfCards(String cardsSequence, String cardOrder, String magicCard) {
        String[] cards = cardsSequence.split(" ");
        int length = cards.length;
        int sumCards = 0;
        int index = 0;
        char magicCardSuit = magicCard.charAt(magicCard.length() - 1);
        String magicCardFace = magicCard.substring(0, magicCard.length() - 1);
        if (cardOrder.equals("odd")) {
            index = 1;
        }
        for (int i = index; i < length; i = i + 2) {
            char cardSuit = cards[i].charAt(cards[i].length() - 1);
            String cardFace = cards[i].substring(0, cards[i].length() - 1);
            int factor = 1;
            if (cardFace.equals(magicCardFace)) {
                factor *= 3;
            }

            if (cardSuit == magicCardSuit) {
                factor *= 2;
            }

            int cardValue = 0;
            switch (cardFace) {
                case "2": {
                    cardValue = 20;
                }

                break;

                case "3": {
                    cardValue = 30;
                }

                break;

                case "4": {
                    cardValue = 40;
                }

                break;

                case "5": {
                    cardValue = 50;
                }

                break;

                case "6": {
                    cardValue = 60;
                }

                break;

                case "7": {
                    cardValue = 70;
                }

                break;

                case "8": {
                    cardValue = 80;
                }

                break;

                case "9": {
                    cardValue = 90;
                }

                break;
                case "10": {
                    cardValue = 100;
                }

                break;

                case "J": {
                    cardValue = 120;
                }

                break;

                case "Q": {
                    cardValue = 130;
                }

                break;

                case "K": {
                    cardValue = 140;
                }

                break;

                case "A": {
                    cardValue = 150;
                }

                break;
                default:
                    break;
            }

            cardValue *= factor;
            sumCards += cardValue;
        }
        return sumCards;
    }
}