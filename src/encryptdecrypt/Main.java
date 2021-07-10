package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            map.put(args[i], args[i + 1]);
        }

        String mode = map.getOrDefault("-mode", "enc");
        String key = map.getOrDefault("-key", "0");
        String data = map.getOrDefault("-data", "");
        String in = map.getOrDefault("-in", "default");
        String out = map.getOrDefault("-out", "default");
        String alg = map.getOrDefault("-alg", ConvertorType.SHIFT.toString());

        ConvertorFactory convertorFactory = new ConvertorFactory();

        Convertor convertorAlg = convertorFactory.getConvertor(alg);

        MessageConvertor messageConvertor = new MessageConvertor();
        messageConvertor.setMethod(convertorAlg);


        if (!data.equals("")) {

            ConvertMessage msg = new ConvertMessage(data,Integer.parseInt(key));

            if (!out.equals("default")) {
                File file = new File(out);
                FileWriter writer = new FileWriter(file);

                if (mode.equals("enc"))
                    writer.write(messageConvertor.encode(msg));
                if (mode.equals("dec"))
                    writer.write(messageConvertor.decode(msg));

                writer.close();
            } else {
                if (mode.equals("enc"))
                    System.out.println(messageConvertor.encode(msg));
                if (mode.equals("dec"))
                    System.out.println(messageConvertor.decode(msg));
            }
        } else if (!in.equals("default")) {

            File fileIn = new File(in);
            Scanner scanner = new Scanner(fileIn);

            if (!out.equals("default")) {
                File fileOut = new File(out);
                FileWriter writer = new FileWriter(fileOut);

                while (scanner.hasNext()) {
                    ConvertMessage msg = new ConvertMessage(scanner.nextLine(),Integer.parseInt(key));
                    if (mode.equals("enc"))
                        writer.write(messageConvertor.encode(msg));
                    if (mode.equals("dec"))
                        writer.write(messageConvertor.decode(msg));
                }

                writer.close();
                scanner.close();
            } else {
                ConvertMessage msg = new ConvertMessage(scanner.nextLine(),Integer.parseInt(key));
                if (mode.equals("enc"))
                    System.out.println(messageConvertor.encode(msg));
                if (mode.equals("dec"))
                    System.out.println(messageConvertor.decode(msg));
            }

        }
    }

}
