package accept;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetIPv6 {
    public static String getIPv6() {
        Logger logger = LogManager.getLogger(GetIPv6.class);

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (inetAddress instanceof Inet6Address && !inetAddress.isLinkLocalAddress()) {
                        String cache = ("\nIPv6地址：" + inetAddress.getHostAddress() + "  ipv6端口：" + Acess.ServerPort);
                        logger.info(cache);
                        return cache;
                    }
                }
            }

        } catch (SocketException e) {
            logger.error(e);
        }
        logger.error("服务器没有可用的IPv6地址。");
        return "服务器没有可用的IPv6地址。";
    }
}
