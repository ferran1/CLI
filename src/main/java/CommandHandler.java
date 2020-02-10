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
        if (cmd.hasOption("help")) {
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
            int octalAsInt;
            try {
                octalAsInt = Integer.parseInt(args[1]);
                String result = NumberConverter.convertOctalToHexadecimal(octalAsInt);
                System.out.println(result);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        } else if (cmd.hasOption("dectohex")) {
            int decAsInt;
            try {
                decAsInt = Integer.parseInt(args[1]);
                String result = NumberConverter.convertDecimalTohexdecimal(decAsInt);
                System.out.println(result);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        } else if (cmd.hasOption("dectooct")) {
            int decAsInt;
            try {
                decAsInt = Integer.parseInt(args[1]);
                NumberConverter.convertDecimalToOctal(decAsInt);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        } else if (cmd.hasOption("dectobin")) {
            int decAsInt;
            try {
                decAsInt = Integer.parseInt(args[1]);
                NumberConverter.convertDecimalToBinary(decAsInt);
            }catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        } else if (cmd.hasOption("fahtocel")) {
            try {
                double fahAsDouble = Double.parseDouble(args[1]);
                NumberConverter.convertFahrenheitToCelsius(fahAsDouble);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        }
        /**
         * Other converters
         */
        else if (cmd.hasOption("poutokil")) {
            try {
                int lbsAsInt = Integer.parseInt(args[1]);
                System.out.println(lbsAsInt / 2.2046);
            } catch(NumberFormatException e){
                System.out.println("Argument is not a number");
            }
        }
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
