package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "./app/build/install/app/bin/app",
        version = "2.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {
    @CommandLine.Parameters(
            paramLabel = "filepath1",
            description = "path to first file"
    )
    private static String filePath1;

    @CommandLine.Parameters(
            paramLabel = "filepath2",
            description = "path of second file"
    )
    private static String filePath2;

    @CommandLine.Option(
            names = {"-v", "--version"},
            versionHelp = true,
            description = "Print version information and exit"
    )
    private static boolean versionInfoRequested;

    @CommandLine.Option(
            names = {"-h", "--help"},
            usageHelp = true,
            description = "Show this help message and exit")
    private static boolean usageHelpRequested;

    @CommandLine.Option(
            names = {"-f", "--format"},
            defaultValue = "stylish",
            description = "output format [default: stylish]")
    private static String format;


    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public Object call() throws Exception {
        if (format.isEmpty()) {
            System.out.println(Differ.generate(filePath1, filePath2));
        } else {
            System.out.println(Differ.generate(filePath1, filePath2, format));
        }
        return null;
    }
}
