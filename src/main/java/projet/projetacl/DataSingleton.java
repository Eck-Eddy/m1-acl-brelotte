package projet.projetacl;

public class DataSingleton {

    private static final DataSingleton instance = new DataSingleton();

    private String scoreFinal;

    private DataSingleton(){}

    public static DataSingleton getInstance()
    {
        return instance;
    }

    public String getScoreFinal()
    {
        return scoreFinal;
    }

    public void setScoreFinal(String score)
    {
        this.scoreFinal=score;
    }
}
