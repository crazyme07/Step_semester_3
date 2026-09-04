class Account {

    String regNo;
    double totalFees;

    Account(String regNo, double totalFees) {
        this.regNo = regNo;
        this.totalFees = totalFees;
    }

    final double calculateLateFee(int daysLate) {
        return totalFees * daysLate / 100.0;
    }

    final void printSummary(int daysLate) {
        double lateFee = calculateLateFee(daysLate);

        System.out.println(regNo +
                " | Total Fee: Rs " + totalFees +
                " | Late Fee: Rs " + lateFee);
    }
}

public class Week4_M3 {

    public static void main(String[] args) {

        String[] regNos = {
            "RA001",
            "RA002",
            "RA003",
            "RA004"
        };

        double[] totalFees = {
            200000,
            150000,
            180000,
            220000
        };

        int[] daysLate = {
            10,
            0,
            -2,
            5
        };

        for (int i = 0; i < regNos.length; i++) {

            Account account =
                    new Account(regNos[i], totalFees[i]);

            if (daysLate[i] > 0) {
                account.printSummary(daysLate[i]);
            } else {
                System.out.println(regNos[i] +
                        " - On time, no late fee");
            }
        }
    }
}