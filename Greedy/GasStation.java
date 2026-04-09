import java.util.*;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        // 🔹 Step 1: Check feasibility
        // If total gas < total cost → impossible to complete circuit
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();

        if(totalCost > totalGas) return -1;

        // 🔹 Step 2: Greedy traversal
        int startIdx = 0; // candidate starting point
        int tank = 0;     // current fuel in tank

        for(int i = 0; i < gas.length; i++)
        {
            // Add current station gas and subtract travel cost
            tank += gas[i] - cost[i];

            // ❌ If tank becomes negative:
            // Means we CANNOT reach next station from current startIdx
            if(tank < 0)
            {
                // 🔥 Key intuition:
                // Any index between startIdx → i is ALSO invalid
                // (because they would have even less fuel)

                // So, skip all of them and try next index
                startIdx = i + 1;

                // Reset tank for new start
                tank = 0;
            }
        }

        // ✅ If solution exists, greedy guarantees this is the answer
        return startIdx;
    }

    // 👉 MAIN METHOD FOR TESTING IN INTELLIJ
    public static void main(String[] args) {
        GasStation sol = new GasStation();

        // Test Case 1
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Start Index: " + sol.canCompleteCircuit(gas1, cost1));
        // Expected: 3

        // Test Case 2
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Start Index: " + sol.canCompleteCircuit(gas2, cost2));
        // Expected: -1

        // Test Case 3 (single valid start)
        int[] gas3 = {5, 1, 2, 3, 4};
        int[] cost3 = {4, 4, 1, 5, 1};
        System.out.println("Start Index: " + sol.canCompleteCircuit(gas3, cost3));
        // Expected: 4

        // Edge Case
        int[] gas4 = {3};
        int[] cost4 = {2};
        System.out.println("Start Index: " + sol.canCompleteCircuit(gas4, cost4));
        // Expected: 0
    }
}