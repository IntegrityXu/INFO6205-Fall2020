public class Main {

    public static void main(String[] args) {

        String [] coins = {"5", "10", "25"};

        combineCoins(coins, 5);
//        System.out.println("Hello World!");
    }

    private static void combineCoins(String[] coins, int num) {
        if (coins.length <= 0 || num <= 0) return ;
        int [] result = new int[num];
        combineCoins(result, num, coins, 0);
    }

    private static void combineCoins(int[] result, int size, String[] coins, int current) {
        if (current == size) {
            printArray(result);
            return;
        }
        for (int i = 0 ; i < coins.length; i++) {
            result[current] = Integer.parseInt(coins[i]);
            combineCoins(result, size, coins, current + 1);

        }
    }

    private static void printArray (int[] array) {
        System.out.print("[" + array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print("," + array[i]);
        }
        System.out.println("]");
    }
}
