import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class Main {
    private static Logger loggerInfo;
    private static Logger loggerError;
    private static Logger loggerQueries;
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        loggerInfo = LogManager.getRootLogger();
        loggerQueries = LogManager.getLogger(Main.class);
        loggerError = LogManager.getLogger(Main.class);
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        for (;;){
            try {

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            loggerQueries.info("Info");

            switch (tokens[0]) {
                case "add":
                    executor.addCustomer(tokens[1]);
                    break;
                case "list":
                    executor.listCustomers();
                    break;
                case "remove":
                    executor.removeCustomer(tokens[1]);
                    break;
                case "count":
                    System.out.println("There are " + executor.getCount() + " customers");
                    break;
                case "help":
                    System.out.println(helpText);
                    break;
                default:
                    throw new IllegalArgumentException(COMMAND_ERROR);
            }
        }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(COMMAND_ERROR);
                loggerError.error("Error");
            }
        }
    }
}
