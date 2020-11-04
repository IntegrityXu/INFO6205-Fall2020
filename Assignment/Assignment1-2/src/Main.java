import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] coins = {1,1,1,1,1,5,5,5,10,10,10,10,25,25};
        int aim = 73;
        getAimCoins(coins, aim);

        //System.out.println("Hello World!");
    }

    private static void getAimCoins(int[] coins, int aim) {
        List <String> frequent = new ArrayList<>();
        int [] result = new int [coins.length];
        getAimCoins(coins, aim, result, 0, frequent);
    }

    private static void getAimCoins(int[] coins, int aim, int [] result, int current, List<String> frequent) {
        if (current == result.length) {
            if (totalValue(result, coins) == aim) {
                printResult(result, coins,frequent);
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            result[current] = i;
            getAimCoins(coins, aim, result, current + 1,frequent);
        }
    }

    private static int totalValue(int[] result, int[] coins) {
        if (result.length <= 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 1) {
                total += coins[i];
            }
        }
        return total;
    }

    private static void printResult(int [] result, int[] coins, List<String> frequent) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for ( int i = 0; i < result.length; i ++) {
            if (result[i] == 1) {
                sb.append(String.valueOf(coins[i]) + ",");
            }
        }
        if (frequent.contains(sb.toString())) {
            return;
        }
        frequent.add(sb.toString());
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }


}
