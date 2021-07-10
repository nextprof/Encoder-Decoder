package encryptdecrypt;

public class ConvertorFactory {

    public Convertor getConvertor(String type) {
        if(type.equalsIgnoreCase(ConvertorType.SHIFT.toString()))
            return new ShiftConvertor();
        else if(type.equalsIgnoreCase(ConvertorType.UNICODE.toString()))
            return new UnicodeConvertor();
        else return null;
    }
}
