package converters;

import java.text.DecimalFormat;

/**
 * @author Ferran
 * This class is responsible for calculating and converting numbers
 */
public class NumberConverter {

    private static int i = 1;

    // converts oct to hex
    public static String convertOctalToHexadecimal(int oct) {
        int dec = 0, i = 0;
        while (oct != 0) {
            dec = dec + (oct % 10) * (int) Math.pow(8, i);
            i++;
            oct = oct / 10;
        }
        String hex = convertDecimalTohexdecimal(dec);
        return hex;
    }

    // converts a decimal number to a hexadecimal number
    public static String convertDecimalTohexdecimal(int q) {
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

    // converts a decimal number to an octal number
    public static void convertDecimalToOctal(int dec){
        int[] oct = octal(dec);

        for(int c=i-1;c>0;c--)
        {
            System.out.print(oct[c]);
        }
    }

    // converts decimal to octal
    private static int[] octal(int q)
    {
        int a[] = new int[50];
        while(q != 0)
        {
            a[i++] = q%8;
            q= q/8;
        }
        return a;
    }

    // converts a decimal number to binary number
    public static void convertDecimalToBinary(int dec) {
        int  bin[]=new int[100];
        int i = 0;
        while(dec > 0)
        {
            bin[i++] = dec%2;
            dec = dec/2;
        }
        for(int j = i-1;j >= 0;j--)
        {
            System.out.print(bin[j]);
        }
    }

    // converts fahrenheit to celsius
    public static void convertFahrenheitToCelsius(double fah){
        double celsius = (fah-32)*5/9;
        //Format the double to remove .0
        DecimalFormat format = new DecimalFormat("0.#");
        System.out.println(format.format(celsius));
    }

}
