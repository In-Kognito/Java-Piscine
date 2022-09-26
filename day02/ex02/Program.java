import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("/");
        if (args[0].startsWith("--current-folder=")) {
            start = Paths.get(args[0].substring(17));
        }
        if (!Files.isDirectory(start)) {
            System.out.println("Wrong argument");
            System.exit(0);
        }
        Scanner scan = new Scanner(System.in);
        String line;
        while((line = scan.nextLine()) != null) {
            String[] command = line.split(" ");
            if (command[0].equals("ls")) {
                List<Path> listFile;
                Stream<Path> pathStream = Files.walk(start, 1);
                listFile = pathStream.collect(Collectors.toList());

                for (Path p : listFile) {
                    if (!p.equals(start) && !p.getFileName().toString().startsWith(".")) {
                        System.out.println(p.getFileName() + " " + Files.size(p) + " KB");
                    }
                }
            }
            else if (command[0].equals("cd")) {
                start = Paths.get(start.toString() + "/" + command[1]);
                if (Files.exists(start) && Files.isDirectory(start)) {
                    start = start.normalize();
                    System.out.println(start.toString());
                }
                else {
                    System.out.println("Wrong Path");
                }
            }
            else if (command[0].equals("mv")) {
                Path source = Paths.get(start + "/" + command[1]).normalize();
                Path target = Paths.get(start + "/" + command[2]).normalize();
                try {
                    if (Files.isRegularFile(source)){
                        if (Files.isDirectory(target)) {
                            target = Paths.get(target + "/" + source.getFileName());
                        }
                        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                    }
                    else {
                        System.out.println("Can't find source file");
                    }

                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (command[0].equals("exit")) {
                System.exit(0);
            }
        }
    }
}

