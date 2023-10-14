package Main.town;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Test {
    public void Run(double u, double i, double o, double p,OutputStream out, InputStream in)throws IOException;

    public void Run2(double u, double i, double o, double p,OutputStream out, InputStream in)throws IOException;

    public void Run3(double u, double i, double o, double p, OutputStream out, InputStream in)throws IOException;

    public void Run4(double u, double i, double o, double p,OutputStream out, InputStream in)throws IOException;
}
