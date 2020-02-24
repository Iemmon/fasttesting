package quizsystem;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class QuizSystem {
    public static void main(String[] args) throws LifecycleException, ServletException {
        int port = 8080;

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        tomcat.setPort(port);

        String docBase = new File("web").getAbsolutePath();

        Context context = tomcat.addWebapp("", docBase);

        tomcat.start();
        tomcat.getServer().await();
    }
}
