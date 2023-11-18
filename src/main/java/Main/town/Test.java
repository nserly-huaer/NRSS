package Main.town;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Test {
    void Run(double u, double i, double o, double p, OutputStream out, InputStream in)throws IOException;

    void Run2(double u, double i, double o, double p, OutputStream out, InputStream in)throws IOException;

    void Run3(double u, double i, double o, double p, OutputStream out, InputStream in)throws IOException;

    void Run4(double u, double i, double o, double p, OutputStream out, InputStream in)throws IOException;
}
