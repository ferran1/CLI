import org.apache.commons.cli.*;

/**
 * @author Ferran
 * Command Line Interface to do random stuff
 */
public class Main {

    public static void main(String[] args){

        //Create all the CLI options
        Options options = createOptions();

        try {
            //Parse the commands
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            CommandHandler.handleCommand(cmd, args);

        } catch (ParseException e) {
            System.out.println("Command " + args[0] + " is not recognized as an internal or external command, type -help to see a list" +
                    " of all the available commands");
        }
    }

    /**
     * This method creates and returns all the CLI options
     * Also saves all the options in the TreeMap of the CommandHandler class to print it in the help command
     * @return CLI Options
     */
    public static Options createOptions(){
        Options options = new Options();

        // A command would look like this: -octtohex 50
        options.addOption("help",  false, "Help command to see a list of all commands");

        options.addOption("octtohex",  true, "Will convert an octal number to a hexadecimal number");
        CommandHandler.options.put("-octtohex", "Converts an octal number to a hexadecimal number, example: -octtohex 100");

        options.addOption("dectohex",  true, "Will convert a decimal number to a hexadecimal number");
        CommandHandler.options.put("-dectohex", "Converts a decimal number to a hexadecimal number, example: -dectohex 100");

        options.addOption("dectooct",  true, "Will convert a decimal number to an octal number");
        CommandHandler.options.put("-dectooct", "Converts a decimal number to an octal number, example: -dectooct 100");

        options.addOption("dectobin",  true, "Will convert a decimal number to a binary number");
        CommandHandler.options.put("-dectobin", "Converts a decimal number to a binary number, example -dectobin 100");

        options.addOption("fahtocel",  true, "Will convert fahrenheit to celsius");
        CommandHandler.options.put("-fahtocel", "Converts fahrenheit to celsius, example -fahtocel 100");

        options.addOption("poutokil",  true, "Will convert lbs to kg");
        CommandHandler.options.put("-poutokil", "Converts lbs to kg, example -poutokil 100");

        options.addOption("miltokil",  true, "Will convert miles to kilometers");
        CommandHandler.options.put("-miltokil", "Converts miles to kilometers, example -miltokil 100");

        options.addOption("feetomet",  true, "Will convert feet to meters");
        CommandHandler.options.put("-feetomet", "Converts feet to meters, example -feetomet 100");

        return options;
    }

}
