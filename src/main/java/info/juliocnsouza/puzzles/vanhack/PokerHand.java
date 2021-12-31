package info.juliocnsouza.puzzles.vanhack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHand
{
    public enum Result { TIE, WIN, LOSS }

    private final String hand;

    PokerHand(String hand)
    {
        this.hand = hand;
    }

    private Result compareValues(List<Integer> left, List<Integer> right, boolean sorted ){
        if (left == null || right == null || left.size() != right.size()){
            throw new IllegalArgumentException("invalid list of values");
        }

        if (!sorted){
            Collections.sort(left, Comparator.reverseOrder());
            Collections.sort(right, Comparator.reverseOrder());
        }

        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) > right.get(i)){
                return Result.WIN;
            }
            if (left.get(i) < right.get(i)){
                return Result.LOSS;
            }
        }
        return Result.TIE;
    }

    public Result compareWith(PokerHand opponent) {
        final HandData currentPlayerData = resolveHand();
        final HandData opponentHandData = opponent.resolveHand();

        System.out.println("Player " + currentPlayerData.hand + " -> " + currentPlayerData.values);
        System.out.println("Opponent " + opponentHandData.hand + " -> " + opponentHandData.values);

        if (currentPlayerData.hand.priority  == opponentHandData.hand.priority) {
            return compareValues(currentPlayerData.values, opponentHandData.values, true);
        }
        else{
            return currentPlayerData.hand.priority > opponentHandData.hand.priority ? Result.WIN : Result.LOSS;
        }

    }

    private HandData resolveHand(){
        final List<Pair> pairs = Arrays.asList(this.hand.split(" "))
                .stream()
                .map(handText -> new Pair(handText))
                .collect(Collectors.toList());

        final List<Integer> sortedPairs = pairs.stream().map(pair -> pair.realValue)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        final Map<String, List<Pair>> pairsGroupedByValue = pairs.stream().collect(Collectors.groupingBy(pair -> pair.value));
        final Map<Suit, List<Pair>> pairsGroupedBySuit = pairs.stream().collect(Collectors.groupingBy(pair -> pair.suit));

        //STRAIGHT_FLUSH
        final boolean sameSuit = pairs.stream().map( pair ->  pair.suit).collect(Collectors.toSet()).size() == 1;
        final boolean canBeSortedSequentially = canBeSortedSequentially(sortedPairs);

        if (sameSuit && canBeSortedSequentially){
            return HandData.of(Hand.STRAIGHT_FLUSH, sortedPairs);
        }

        //FOUR_OF_A_KIND
        final List<Map.Entry<String, List<Pair>>> fourOfAKind = pairsGroupedByValue
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() == 4).collect(Collectors.toList());

        if (fourOfAKind.size() > 0){
            return HandData.of(Hand.FOUR_OF_A_KIND, List.of( fourOfAKind.get(0).getValue().get(0).realValue) );
        }

        //FULL_HOUSE
        final List<Map.Entry<String, List<Pair>>> threeOfAKind = pairsGroupedByValue
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() == 3)
                .collect(Collectors.toList());

        final List<Map.Entry<String, List<Pair>>> twoOfAKind = pairsGroupedByValue
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() == 2)
                .collect(Collectors.toList());

        if (threeOfAKind.size() > 0 && twoOfAKind.size() > 0) {
            return HandData.of(Hand.FULL_HOUSE,List.of( threeOfAKind.get(0).getValue().get(0).realValue) );
        }

        //FLUSH
        final List<Map.Entry<Suit, List<Pair>>> fiveSameSuit= pairsGroupedBySuit
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() == 5)
                .collect(Collectors.toList());

        if (fiveSameSuit.size() > 0) {
            return HandData.of(
                    Hand.FLUSH,
                    fiveSameSuit.get(0).getValue().stream()
                            .map(pair -> pair.realValue).collect(Collectors.toList())
            );
        }

        //STRAIGHT
        if (canBeSortedSequentially) {
            return HandData.of(Hand.STRAIGHT,sortedPairs );
        }


        //THREE_OF_A_KIND
        if (threeOfAKind.size() > 0 && twoOfAKind.size() == 0) {
            return HandData.of(Hand.THREE_OF_A_KIND, List.of(threeOfAKind.get(0).getValue().get(0).realValue) );
        }


        //TWO_PAIR
        if (twoOfAKind.size() == 2) {
            final int v1 = twoOfAKind.get(0).getValue().get(0).realValue;
            final int v2 = twoOfAKind.get(1).getValue().get(0).realValue;
            return HandData.of(Hand.TWO_PAIR, List.of((v1 < v2 ? v1 : v2), (v1 > v2 ? v1 : v2)));
        }

        //ONE_PAIR
        if (twoOfAKind.size() == 1) {
            final List<Integer> nonTwoOfKindValues = pairsGroupedByValue
                    .entrySet().stream()
                    .filter(entry -> entry.getValue().size() != 2)
                    .flatMap(entry -> entry.getValue().stream())
                    .map(pair -> pair.realValue)
                    .collect(Collectors.toList());

            return HandData.of(Hand.ONE_PAIR, nonTwoOfKindValues);
        }

        return HandData.of(Hand.HIGH_CARD, sortedPairs);
    }

    private boolean canBeSortedSequentially(List<Integer> sortedDescValues) {
        if (sortedDescValues == null || sortedDescValues.isEmpty()){
            return  false;

        }
        int prev = sortedDescValues.get(0);
        for (int i = 1; i < sortedDescValues.size(); i++) {
            int current = sortedDescValues.get(i);
            if (prev != (current  + 1)){
                return false;
            }
            prev = current;
        }
        return true;
    }

    private static class HandData {

        static HandData of(Hand hand, List<Integer> values){
            return  new HandData(hand, values);
        }
        private final Hand hand;
        private final List<Integer> values;

        private HandData(Hand hand, List<Integer> values) {
            this.hand = hand;
            this.values = values;
        }


    }

    private class Pair {
        private String value;
        private Suit suit;
        private int realValue;

        public Pair(String text){
            if (text == null || text.isEmpty() || text.length() != 2){
                throw new IllegalArgumentException(String.format("%s is not a valid pair", text));
            }
            String value = String.valueOf(text.charAt(0)).toUpperCase();
            String suit = String.valueOf(text.charAt(1)).toUpperCase();

            this.value = value;
            this.realValue = resolveRealValue(value);
            this.suit = resolveSuit(suit);
        }

        private Suit resolveSuit(String suit){

            switch (suit){
                case "S":
                    return Suit.SPADES;
                case "C":
                    return Suit.CLUBS;
                case "H":
                    return Suit.HEARTS;
                case "D":
                    return Suit.DIAMONDS;
                default:
                    throw new IllegalArgumentException(String.format("%s is not a valid card suit", suit));
            }
        }

        private int resolveRealValue(String value){
            if("T".equalsIgnoreCase(value)){
                return 10;
            }
            if("J".equalsIgnoreCase(value)){
                return 11;
            }
            if("Q".equalsIgnoreCase(value)){
                return 12;
            }
            if("K".equalsIgnoreCase(value)){
                return 13;
            }
            if("A".equalsIgnoreCase(value)){
                return 14;
            }
            try {
                return Integer.parseInt(value);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException(String.format("%s is not a valid card value", value));
            }
        }
    }

    private enum Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS;
    }

    private enum Hand {
        STRAIGHT_FLUSH(9),
        FOUR_OF_A_KIND(8),
        FULL_HOUSE(7),
        FLUSH(6),
        STRAIGHT(5),
        THREE_OF_A_KIND(4),
        TWO_PAIR(3),
        ONE_PAIR(2),
        HIGH_CARD(1);

        private int priority;
        Hand(int priority) {
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }
    }
}
