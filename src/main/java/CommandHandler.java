import converters.NumberConverter;
import org.apache.commons.cli.CommandLine;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class handles all the CLI commands
 */
public class CommandHandler {

    static Map<String, String> options = new TreeMap<>(String::compareTo);

    /**
     * This method handles all the CLI commands in the application
     * @param cmd is the passed in parsed commandline
     * @param args is the passed in argument of a command
     */
    public static void handleCommand(CommandLine cmd, String[] args) {

        //Check which command (option) the user has typed in to execute the command
        if (cmd.hasOption("help")) {
            //Help command to a see a list of all commands
//            System.out.println("For more information on a specific command, type HELP command-name");
            System.out.println("List of all the available commands");

            //Iterate through the TreeMap to print all the commands with a description
            Iterator it = options.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry pair = (Map.Entry)it.next();
                System.out.println(pair.getKey() + "\t" + pair.getValue());
                it.remove(); // avoids a ConcurrentModificationException
            }
            System.out.println("\n Github: https://github.com/ferran1/CLI");
        }
        /**
         * Number converting commands
         */
        else if (cmd.hasOption("octtohex")) {
            //Get the passed in arg and parse it to an integer
            int octalAsInt;
            try {
                octalAsInt = Integer.parseInt(args[1]);
                //Convert oct to hex
                String result = NumberConverter.convertOctalToHexadecimal(octalAsInt);
                System.out.println(result);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        } else if (cmd.hasOption("dectohex")) {
            int decAsInt;
            try {
                decAsInt = Integer.parseInt(args[1]);
                //Convert dec to hex
                String result = NumberConverter.convertDecimalTohexdecimal(decAsInt);
                System.out.println(result);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        } else if (cmd.hasOption("dectooct")) {
            int decAsInt;
            try {
                decAsInt = Integer.parseInt(args[1]);
                //Convert dec to oct
                NumberConverter.convertDecimalToOctal(decAsInt);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        } else if (cmd.hasOption("dectobin")) {
            int decAsInt;
            try {
                decAsInt = Integer.parseInt(args[1]);
                //Convert dec to bin
                NumberConverter.convertDecimalToBinary(decAsInt);
            }catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        } else if (cmd.hasOption("fahtocel")) {
            try {
                double fahAsDouble = Double.parseDouble(args[1]);
                //Convert fahrenheit to celsius
                NumberConverter.convertFahrenheitToCelsius(fahAsDouble);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        }
        /**
         * Other converters
         */
        //convert lbs to kg
        else if (cmd.hasOption("poutokil")) {
            try {
                int lbsAsInt = Integer.parseInt(args[1]);
                System.out.println(lbsAsInt / 2.2046);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        }
        //convert miles to km
        else if (cmd.hasOption("miltokil")) {
            try {
                int milAsInt = Integer.parseInt(args[1]);
                double result = milAsInt * 1.6;
                //Remove .0 from the double
                DecimalFormat format = new DecimalFormat("0.#");
                System.out.println(format.format(result));
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        }
        //convert feet to meters
        else if (cmd.hasOption("feetomet")) {
            try {
                int feetAsInt = Integer.parseInt(args[1]);
                double result = feetAsInt / 3.28;
                //Remove .0 from the double
                DecimalFormat format = new DecimalFormat("0.#");
                System.out.println(format.format(result));
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        }
    }
}
