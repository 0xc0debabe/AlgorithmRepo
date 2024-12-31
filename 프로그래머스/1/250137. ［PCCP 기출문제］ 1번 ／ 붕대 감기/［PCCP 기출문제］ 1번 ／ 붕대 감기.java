
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {3, 2, 7};
        int b = 20;
        int[][] c = {{1, 15}, {5, 16}, {8, 6}};

        System.out.println(solution.solution(a, b, c));
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;

        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int attackDamage = attacks[i][1];

            health -= attackDamage;
            if (health <= 0) return -1;
            
            if (i < attacks.length - 1) {
                health = (health + recovery(attackTime, attacks[i + 1][0], bandage));
                if (health > maxHealth) health = maxHealth;
            }

        }

        return health;
    }

    private int recovery(int now, int next, int[] bandage) {
        int timeGap = next - now;
        if (timeGap == 1) return 0;

        int castTime = bandage[0];
        int recoveryPerSec = bandage[1];
        int extraRecovery = bandage[2];

        int totalRecoveryPerSec = recoveryPerSec * (timeGap - 1);
        if (timeGap > castTime) {
            return totalRecoveryPerSec + extraRecovery * ((timeGap - 1) / castTime);
        } else {
            return totalRecoveryPerSec;
        }

    }

}
