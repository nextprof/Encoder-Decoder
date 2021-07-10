package encryptdecrypt;

public class MessageConvertor
{
    private Convertor method;

    public void setMethod(Convertor method) {
        this.method = method;
    }

    public String encode(ConvertMessage msg) {
        return this.method.encode(msg);
    }
    public String decode(ConvertMessage msg) {
        return this.method.decode(msg);
    }

}
