package encryptdecrypt;

public class UnicodeConvertor implements Convertor{

    @Override
    public String encode(ConvertMessage msg) {
            char[] tab = msg.text.toCharArray();
            char[] newTab = new char[msg.text.length()];
            for (int i = 0; i < tab.length; i++) {
                int ascii = tab[i];
                ascii += msg.key;
                if (ascii > 255) {
                    ascii -= 255;
                }
                newTab[i] = (char) ascii;
            }
            return String.valueOf(newTab);
    }

    @Override
    public String decode(ConvertMessage msg) {
        char[] tab = msg.text.toCharArray();
        char[] newTab = new char[msg.text.length()];

        for (int i = 0; i < tab.length; i++) {
            int ascii = tab[i];
            ascii -= msg.key;
            if (ascii < 0) {
                ascii += 255;
            }
            newTab[i] = (char) ascii;

        }
        return String.valueOf(newTab);
    }

    @Override
    public String toString() {
        return "UnicodeConvertor";
    }
}
