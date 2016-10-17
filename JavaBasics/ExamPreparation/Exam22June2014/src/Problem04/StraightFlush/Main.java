package Problem04.StraightFlush;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int SUITS_IN_FACE = 13;
    private static final int FLUSH_LENGTH = 5;
    public static void main(String[] args) {
        checkForStraightFlushes();
    }

    private static void checkForStraightFlushes() {
        Scanner scanner = new Scanner(System.in);
        String[] cards = scanner.nextLine().split("(,\\s+)|(\\s+)");
        int length = cards.length;
        List<String> hs = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        List<String> cs = new ArrayList<>();
        List<String> ss = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            char face = cards[i].charAt(cards[i].length() - 1);
            switch(face) {
                case 'D': {
                    ds.add(cards[i]);
                }

                break;

                case 'H': {
                    hs.add(cards[i]);
                }

                break;

                case 'C': {
                    cs.add(cards[i]);
                }

                break;

                case 'S': {
                    ss.add(cards[i]);
                }

                break;
                default:break;
            }
        }

        List<String[]> flushes = new ArrayList<>();
        if(hs.size() >= 5) {
            String[] hearts = sortCardsInFace(hs);
            for(int i = 0; i <= SUITS_IN_FACE - FLUSH_LENGTH; i++) {
                String[] flush = checkForFlush(hearts, i);
                if(!(null==flush)) {
                    flushes.add(flush);
                }
            }
        }

        if(cs.size() >= 5) {
            String[] clubs = sortCardsInFace(cs);
            for(int i = 0; i <= SUITS_IN_FACE - FLUSH_LENGTH; i++) {
                String[] flush = checkForFlush(clubs, i);
                if(!(null==flush)) {
                    flushes.add(flush);
                }
            }
        }

        if(ss.size() >= 5) {
            String[] spades = sortCardsInFace(ss);
            for(int i = 0; i <= SUITS_IN_FACE - FLUSH_LENGTH; i++) {
                String[] flush = checkForFlush(spades, i);
                if(!(null==flush)) {
                    flushes.add(flush);
                }
            }
        }

        if(ds.size() >= 5) {
            String[] diamonds = sortCardsInFace(ds);
            for(int i = 0; i <= SUITS_IN_FACE - FLUSH_LENGTH; i++) {
                String[] flush = checkForFlush(diamonds, i);
                if(!(null==flush)) {
                    flushes.add(flush);
                }
            }
        }

        printFlushes(flushes);
    }


    private static void printFlushes(List<String[]> flushes) {

        if(flushes.size() == 0) {
            System.out.println("No Straight Flushes");
            return;
        }
        int length = flushes.size();
        for(int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(flushes.get(i)));
        }

    }

    private static String[] checkForFlush(String[] cards, int index) {
        int count = 0;
        int cardIndex = index;
        while(!(null == cards[cardIndex])) {
            count++;
            cardIndex++;
            if(count == FLUSH_LENGTH) {
                String[] flush = Arrays.copyOfRange(cards, index, index + FLUSH_LENGTH);
                return flush;
            }
        }

        return null;
    }

    private static String[] sortCardsInFace(List<String> cards) {
        int length = cards.size();
        String[] sorted = new String[SUITS_IN_FACE];
        for(int i = 0; i < length; i++) {
            String suit = cards.get(i).substring(0, cards.get(i).length() - 1);
            switch(suit) {
                case "2": {
                    sorted[0] = cards.get(i);
                }

                break;
                case "3": {
                    sorted[1] = cards.get(i);
                }

                break;
                case "4": {
                    sorted[2] = cards.get(i);
                }

                break;
                case "5": {
                    sorted[3] = cards.get(i);
                }

                break;
                case "6": {
                    sorted[4] = cards.get(i);
                }

                break;
                case "7": {
                    sorted[5] = cards.get(i);
                }

                break;
                case "8": {
                    sorted[6] = cards.get(i);
                }

                break;

                case "9": {
                    sorted[7] = cards.get(i);
                }

                break;
                case "10": {
                    sorted[8] = cards.get(i);
                }

                break;
                case "J": {
                    sorted[9] = cards.get(i);
                }

                break;
                case "Q": {
                    sorted[10] = cards.get(i);
                }

                break;
                case "K": {
                    sorted[11] = cards.get(i);
                }

                break;
                case "A": {
                    sorted[12] = cards.get(i);
                }

                break;
                default : break;
            }
        }

        return sorted;
    }
}
