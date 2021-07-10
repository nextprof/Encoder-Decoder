package encryptdecrypt;

public class ShiftConvertor implements Convertor {
    @Override
    public String encode(ConvertMessage msg) {
        char[] tab = msg.text.toCharArray();
        char[] newTab = new char[msg.text.length()];
        for (int i = 0; i < tab.length; i++) {
            int ascii = tab[i];
            if (ascii >= 65 && ascii <= 90) {
                ascii += msg.key;
                if (ascii > 90) {
                    ascii -= 26;
                }
            } else if (ascii >= 97 && ascii <= 122) {
                ascii += msg.key;
                if (ascii > 122) {
                    ascii -= 26;
                }
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
            if (ascii >= 65 && ascii <= 90) {
                ascii -= msg.key;
                if (ascii < 65) {
                    ascii += 26;
                }
            } else if (ascii >= 97 && ascii <= 122) {
                ascii -= msg.key;
                if (ascii < 97) {
                    ascii += 26;
                }
            }

            newTab[i] = (char) ascii;

        }
        return String.valueOf(newTab);
    }

    @Override
    public String toString() {
        return "ShiftConvertor";
    }

}
