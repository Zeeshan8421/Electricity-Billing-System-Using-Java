import java.util.Scanner;

public class ElectricityBillingSystem {
    private static final double BASE_UNIT_COST = 2.5; // Cost per unit for the first tier
    private static final double ADDITIONAL_UNIT_COST = 3.0; // Cost per unit for additional consumption
    private static final double MINIMUM_CHARGE = 10.0; // Minimum charge if consumption is too low
    private static final int TIER_THRESHOLD = 100; // Threshold for the first tier


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the units consumed: ");
        int unitsConsumed = scanner.nextInt();

        double bill = calculateBill(unitsConsumed);
        System.out.println("Electricity Bill: $" + bill);

        scanner.close();
    }

    public static double calculateBill(int units) {
        if (units <= TIER_THRESHOLD) {
            return Math.max(MINIMUM_CHARGE, units * BASE_UNIT_COST);
        } else {
            double firstTierCost = TIER_THRESHOLD * BASE_UNIT_COST;
            double additionalUnits = units - TIER_THRESHOLD;
            double additionalCost = additionalUnits * ADDITIONAL_UNIT_COST;
            return Math.max(MINIMUM_CHARGE, firstTierCost + additionalCost);
        }
    }
}
