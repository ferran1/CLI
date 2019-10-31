import converters.NumberConverter;
import org.apache.commons.cli.CommandLine;

/**
 * This class handles all the CLI commands
 */
public class CommandHandler {

    //This method handles all the CLI commands
    public static void handleCommand(CommandLine cmd, String[] args) {
        //Check which command (option) the user has typed in to execute certain code

        /**
         * Number converting commands
         */
        if (cmd.hasOption("octtohex")) {
            //Get the passed in arg and parse it to an integer
            int octalAsInt = Integer.parseInt(args[1]);
            //Convert oct to hex
            String result = NumberConverter.convertOctalToHexadecimal(octalAsInt);
            System.out.println(result);
        } else if (cmd.hasOption("dectohex")) {
            int decAsInt = Integer.parseInt(args[1]);
            //Convert dec to hex
            String result = NumberConverter.convertDecimalTohexdecimal(decAsInt);
            System.out.println(result);
        } else if (cmd.hasOption("dectooct")) {
            int decAsInt = Integer.parseInt(args[1]);
            //Convert dec to oct
            NumberConverter.convertDecimalToOctal(decAsInt);
        } else if (cmd.hasOption("dectobin")) {
            int decAsInt = Integer.parseInt(args[1]);
            //Convert dec to bin
            NumberConverter.convertDecimalToBinary(decAsInt);
        } else if (cmd.hasOption("fahtocel")) {
            double fahAsDouble = Double.parseDouble(args[1]);
            //Convert fahrenheit to celsius
            NumberConverter.convertFahrenheitToCelsius(fahAsDouble);
        }
    }

}
