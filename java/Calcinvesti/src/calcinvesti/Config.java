package calcinvesti;

public class Config {
    public String getOS() {
        return System.getProperty("os.name").toLowerCase();
    }
    public String getArquiteturaOS() {
        return System.getProperty("os.arch").toLowerCase();
    }
    public String getVersaoOS() {
        return System.getProperty("os.version").toLowerCase();
    }
}
