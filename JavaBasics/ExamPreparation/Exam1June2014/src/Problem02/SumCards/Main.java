package Problem02.SumCards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cards = scanner.nextLine().split("\\s");
        int length = cards.length;
        int [] cardValues = new int[ length];
        for(int i = 0; i < length; i++) {
            String face = cards[i].substring(0, cards[i].length() - 1);
            int value = 0;
            switch(face) {
                case "2" :{
                    value = 2;
                }

                break;

                case "3" :{
                    value = 3;
                }

                break;

                case "4" :{
                    value = 4;
                }

                break;

                case "5" :{
                    value = 5;
                }

                break;

                case "6" :{
                    value = 6;
                }

                break;

                case "7" :{
                    value = 7;
                }

                break;

                case "8" :{
                    value = 8;
                }

                break;

                case "9" :{
                    value = 9;
                }

                break;

                case "10" :{
                    value = 10;
                }

                break;

                case "J" :{
                    value = 12;
                }

                break;

                case "Q" :{
                    value = 13;
                }

                break;

                case "K" :{
                    value = 14;
                }

                break;

                case "A" :{
                    value = 15;
                }

                break;
            }

            cardValues[i] = value;
        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            int count = 1;
            while(i < length - 1 && cardValues[i] == cardValues[i + 1]) {
                count ++;
                i ++;
            }
            if(count >= 2) {
                sum += count * cardValues[i] * 2;
                if(i == length - 1) {
                    break;
                }
            } else {
                sum += cardValues[i];
            }
        }

        System.out.println(sum);
    }
}
