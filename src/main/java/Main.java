import org.apache.commons.cli.*;

/**
 * @author Ferran <ferrantl@live.nl)
 * Command Line Interface to do random stuff
 */
public class Main {

    //Main method (start of the application)
    public static void main(String[] args){

        //Create all the CLI options
        Options options = createOptions();

        try {
            //Parse the commands
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            //Call handleCommand() to check which command the user has typed in and execute certain code
            CommandHandler.handleCommand(cmd, args);

        } catch (ParseException e) {
            System.out.println("Unhandled exception: " + e.getMessage());
        }
    }

    /**
     * This method creates and returns all the CLI options
     * @return CLI Options
     */
    private static Options createOptions(){
        Options options = new Options();

        //A command would look like this: -octtohex 50
        //First parameter is the command the user has to type in, second parameter is if the command requires any arguments, the third parameter is a description of the command
        options.addOption("octtohex",  true, "Will convert an octal number to an hexadecimal number");
        options.addOption("dectohex",  true, "Will convert a decimal number to a hexadecimal number");
        options.addOption("dectooct",  true, "Will convert a decimal number to an octal number");
        options.addOption("dectobin",  true, "Will convert a decimal number to a binary number");
        options.addOption("fahtocel",  true, "Will convert fahrenheit to celsius");

        return options;
    }

}
