/**
 * @author Ferran
 * This class is responsible for calculating and converting numbers
 */
public class NumberConverter {

    /**
     * Converts octal number to a hexadecimal number
     * @param oct
     * @return
     */
    public static String convertOctalToHexadecimal(int oct) {
        int dec = 0, i = 0;
        while (oct != 0) {
            dec = dec + (oct % 10) * (int) Math.pow(8, i);
            i++;
            oct = oct / 10;
        }
        String hex = hexdecimal(dec);
        return hex;
    }

    //This method converts a decimal number to a hexadecimal number
    private static String hexdecimal(int q) {
        char a[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int rem;
        String hexdec = "";
        while (q != 0) {
            rem = q % 16;
            hexdec = a[rem] + hexdec;
            q = q / 16;
        }
        return hexdec;
    }

}