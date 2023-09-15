package hexlet.code;

import picocli.CommandLine;

@CommandLine.Command(
        name = "./app/build/install/app/bin/app",
        version = "2.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
