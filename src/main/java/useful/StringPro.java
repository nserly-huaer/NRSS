package useful;

public class StringPro {
    private StringBuffer str = new StringBuffer();

    public void append(Object object) {
        str.append(object);
    }

    public void appendLn(Object object) {
        str.append(object + "\n");
    }

    public String toString() {
        return str.toString();
    }

    public StringBuffer toStringBuffer() {
        return str;
    }

    public int hashCode() {
        return str.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof StringBuffer) {
            StringBuffer str = (StringBuffer) object;
            return str.equals(str);
        }
        return false;
    }
}
