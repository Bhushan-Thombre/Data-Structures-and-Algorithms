// Fractional Knapsack Problem
// Given some items, such that each item has some weight and value associated to it and a knapsack bag with some
// given capacity.
// Put the items in the knapsack bag such that the value of the bag is maximum. While doing so we can take an item
// partially.



package fractionalKnapsack;

import java.util.Arrays;

class Item implements Comparable<Item> {

    int weight;
    int value;

    public Item (int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Item item) {
        return this.weight * item.value - this.value * item.weight;
    }
}

public class FractionalKnapsackProblem {

    // Time Complexity = O(n * Log(n))
    // Space Complexity = O(1)
    public static double fractionalKnapsack(Item[] arr, int W) {
        double res = 0.0;
        Arrays.sort(arr);
        for (Item item : arr) {
            if (item.weight <= W) {
                res += item.value;
                W -= item.weight;
            } else {
                res += item.value * ((double) W / item.weight);
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Item[] arr = {new Item(10, 60),
                new Item(40, 40),
                new Item(20, 100),
                new Item(30, 120)};
        int W = 50;

        double ans = fractionalKnapsack(arr, W);
        System.out.println("Maximum value of knapsack is: ");
        System.out.println(ans);
    }
}
