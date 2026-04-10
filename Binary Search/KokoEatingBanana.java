import java.util.*;

public class KokoEatingBanana {

    public int minEatingSpeed(int[] piles, int h) {

        // 🔍 Intuition:
        // We are searching for the MINIMUM eating speed (k).
        //
        // Key observation (Monotonic behavior):
        // If Koko can finish all bananas at speed = k,
        // then she can also finish at any speed > k.
        //
        // So we can apply Binary Search on "answer space":
        // Range of speed → [1, max(piles)]
        //
        // For a given speed (mid):
        //  - If Koko CAN finish within h hours → try smaller speed
        //  - If Koko CANNOT finish → increase speed
        //
        // Goal: Find the minimum valid speed

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canFinish(piles, h, mid)) {
                r = mid; // try smaller speed
            } else {
                l = mid + 1; // need more speed
            }
        }

        return l;
    }

    public boolean canFinish(int[] piles, int h, int speed) {

        // 🧠 Logic:
        // For each pile, hours required = ceil(pile / speed)
        // Sum all hours and check if <= h

        int hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // optimized ceil
        }

        return hours <= h;
    }
}