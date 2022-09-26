import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStreamA = null;
        FileInputStream fileInputStreamB = null;
        Scanner fileA = null;
        Scanner fileB = null;
        if (args.length != 2) {
            System.out.println("Needs only two arguments!");
            System.exit(0);
        }
        try {
            fileInputStreamA = new FileInputStream(args[0]);
            fileA = new Scanner(fileInputStreamA);
            fileInputStreamB = new FileInputStream(args[1]);
            fileB = new Scanner(fileInputStreamB);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> textA = new ArrayList<>();
        ArrayList<String> textB = new ArrayList<>();
        TreeSet<String> dicA = new TreeSet<>();
        TreeSet<String> dicB = new TreeSet<>();

        FileOutputStream dictinary = new FileOutputStream("dictinary.txt", false);

        for (int i = 0; fileA.hasNext(); i++) {
            String str = fileA.next();
            dicA.add(str);
            dicB.add(str);
            textA.add(str);
        }
        for (int i = 0; fileB.hasNext(); i++) {
            String str = fileB.next();
            dicA.add(str);
            dicB.add(str);
            textB.add(str);
        }
        dictinary.write(dicA.toString().getBytes(StandardCharsets.UTF_8));

        if (textA.size() == 0 || textB.size() == 0) {
            System.out.printf("Similarity = 0.00");
            System.exit(0);
        }

        int[] arrayA = new int[dicA.size()];
        int[] arrayB = new int[dicB.size()];
        for (int i = 0; 0 < dicA.size(); i++) {
            for (int j = 0; j < textA.size(); j++) {
                if (dicA.first().equals(textA.get(j))) {
                    arrayA[i]++;
                }
            }
            dicA.remove(dicA.first());
        }

        for (int i = 0; 0 < dicB.size(); i++) {
            for (int j = 0; j < textB.size(); j++) {
                if (dicB.first().equals(textB.get(j))) {
                    arrayB[i]++;
                }
            }
            dicB.remove(dicB.first());
        }

        double numerator = 0;
        for (int i = 0; i < arrayA.length; i++) {
            numerator += arrayA[i] * arrayB[i];
        }
        double denominator = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < arrayA.length; i++) {
            a += Math.pow(arrayA[i], 2);
            b += Math.pow(arrayB[i], 2);
        }
        denominator = Math.sqrt(a) * Math.sqrt(b);

        Double similarity = (numerator / denominator);
        String numeric = String.format("%.3f", similarity);


        System.out.printf("Similarity = %.4s", numeric);
        System.out.println();
    }
}
