import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) throws IOException {

        Map<String, String> mapSignature = new HashMap<>();
        FileInputStream signat = null;

        int len = parsingFile(mapSignature, signat);

        String path = null;
        Scanner scan = new Scanner(System.in);
        while (!(path = scan.nextLine()).equals("42")) {
            FileOutputStream result = null;
            try {
                signat = new FileInputStream(path);
                result = new FileOutputStream("result.txt", true);
                int a, i = 0;
                boolean undefined = false;
                StringBuilder str = new StringBuilder();
                String str_res = null;

                while((a = signat.read()) != -1 && i < len) {
                    str.append(String.format("%02X ", a));
                    i++;
                }
                str_res = str.toString().substring(0, str.length() - 1);
                for (String key : mapSignature.keySet()) {
                    if (str_res.startsWith(key))
                    {
                        String value = mapSignature.get(key);
                        result.write(value.getBytes());
                        result.write('\n');
                        System.out.println("PROCESSED");
                        undefined = true;
                        break;
                    }
                }
                if (undefined == false) {
                    System.out.println("UNDEFINED");
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("UNDEFINED");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        signat.close();


    }

    private static int parsingFile(Map<String, String> mapSignature, FileInputStream signat) {
        int len = 0;
        try {
            signat = new FileInputStream("signatures.txt");
            int c;
            while((c = signat.read()) != -1) {
                StringBuilder str = new StringBuilder();
                while ((char)c != '\n' || signat.available() == 0) {
                    str.append((char)c);
                    c = signat.read();
                    if (c == -1) {
                        break;
                    }
                }
                String[] split = str.toString().split(", ");
                mapSignature.put(split[1], split[0]);

                String str2 = split[1].replaceAll("\\s", "");
                if (str2.length() > len)
                    len = str2.length();

            }
            signat.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return len/2;
    }
}
