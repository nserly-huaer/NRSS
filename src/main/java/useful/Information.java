package useful;

public class Information {
    public String userName = "";
    public String userIP = "";
    public String Welcome = "";
    public final String version = Version.GetVersion();

    public Information(String userName, String userIP, String welcome) {
        this.userName = userName;
        this.userIP = userIP;
        this.Welcome = welcome;
    }


}
