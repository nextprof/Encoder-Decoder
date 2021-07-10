package encryptdecrypt;

public interface Convertor {
    String encode(ConvertMessage msg);
    String decode(ConvertMessage msg);
}
