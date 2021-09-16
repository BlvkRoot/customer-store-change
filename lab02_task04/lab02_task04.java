import java.util.Scanner;
import java.text.DecimalFormat;

public class lab02_task04 {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // Instantiating scanner variable
        DecimalFormat df = new DecimalFormat("#.##"); // Instantiating Decimal formatter to 2 Decimal places

        int amountTendered = 50;
        String currencyFormat = "N$";
        int[] notes = {200, 100, 50, 20, 10};
        double[] coins = {5.0, 1.0, 0.5, 0.1, 0.05};

        System.out.print("Enter item name: ");
        String itemName = userInput.nextLine();

        System.out.print("Enter QTY of " + itemName + ":");
        int quantity = userInput.nextInt();

        System.out.print("Enter price per item "+currencyFormat+": ");
        double itemPrice = Double.parseDouble(userInput.next());

        System.out.println("Amount tendered "+currencyFormat+": " + amountTendered);

        double calculateChange = amountTendered - (quantity * itemPrice);

        System.out.println("Your change is: "+calculateChange+"");

        int NotesOf20Divisor = (int)(calculateChange / notes[3]);
        double NotesOf20Remainder = calculateChange % notes[3];
        double NotesOf20RemainderFormatted = Double.parseDouble(df.format(NotesOf20Remainder).replace(",", ".")); // Format remainder result and replace comma with a dot

        int NotesOf10Divisor = (int)(NotesOf20RemainderFormatted / notes[4]);
        double NotesOf10Remainder = (double)(NotesOf20RemainderFormatted % notes[4]);
        double NotesOf10RemainderFormatted = Double.parseDouble(df.format(NotesOf10Remainder).replace(",", ".")); // Format remainder result and replace comma with a dot

        int FiveDollarsCoinDivisor = (int)(NotesOf10RemainderFormatted / coins[0]);
        double FiveDollarsRemainder = (double)(NotesOf10RemainderFormatted % coins[0]);
        double FiveDollarsRemainderFormatted = Double.parseDouble(df.format(FiveDollarsRemainder).replace(",", ".")); // Format remainder result and replace comma with a dot

        int OneDollarDivisor = (int)(FiveDollarsRemainderFormatted / coins[1]);
        double OneDollarRemainder = (double)(FiveDollarsRemainderFormatted % coins[1]);
        double OneDollarRemainderFormatted = Double.parseDouble(df.format(OneDollarRemainder).replace(",", ".")); // Format remainder result and replace comma with a dot

        int FiftyCentsDivisor = (int)(OneDollarRemainderFormatted / coins[2]);
        double FiftyCentsRemainder = (double)(OneDollarRemainderFormatted % coins[2]);
        double FiftyCentsRemainderFormatted = Double.parseDouble(df.format(FiftyCentsRemainder).replace(",", ".")); // Format remainder result and replace comma with a dot

        int TenCentsDivisor = (int)( FiftyCentsRemainderFormatted / coins[3]);
        double TenCentsRemainder = (double)(FiftyCentsRemainderFormatted % coins[3]);
        double TenCentsRemainderFormatted = Double.parseDouble(df.format(TenCentsRemainder).replace(",", ".")); // Format remainder result and replace comma with a dot
        
        int FiveCentsDivisor = (int)(TenCentsRemainderFormatted / coins[4]);
        double FiveCentsRemainder = (double)(TenCentsRemainderFormatted % coins[4]);

        System.out.println("Disbursed as follows: " + NotesOf20Divisor + " x " + currencyFormat + notes[3] +"; "
                            + NotesOf10Divisor + " x " + currencyFormat + notes[4] +"; " 
                            + FiveDollarsCoinDivisor + " x " + currencyFormat  +"5; "
                            + OneDollarDivisor + " x " + currencyFormat +"1; "
                            + FiftyCentsDivisor + " x " + "50c; "
                            + TenCentsDivisor + " x " + "10c; "
                            + FiveCentsDivisor + " x " + "5c; ");


    }

}