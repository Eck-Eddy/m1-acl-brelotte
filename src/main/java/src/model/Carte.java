package src.model;

/**
 * Classe Carte qui représente une carte de jeu
 */
public class Carte {

    /**
     * nom que la carte porte
     */
    private String nom;

    /**
     * Couleur de la carte
     */
    private final Couleur color;

    /**
     * Valeur de la carte
     */
    private final Valeur valeur;

    /**
     * Catégorie de la carte
     */
    private final Categorie categorie;

    /**
     * Nombre de point de la carte
     */
    private final int nbPoint;

    /**
     * Constructeur d'une carte
     * @param name nom de la carte
     * @param color couleur de la carte
     * @param cat catégorie de la carte
     * @param val valeur de la carte
     */
    public Carte (String name,final Couleur color,final Categorie cat, final Valeur val)
    {
        setNom(name);
        this.color = color;
        this.valeur = val;
        this.nbPoint = val.getValeur();
        this.categorie = cat;

    }


    /**
     * Permet de modifier le nom de la carte
     * @param name nom de la carte
     * @throws IllegalArgumentException si le nom donné n'est pas valide
     */
    public void setNom(String name) {
        if (name == null || name.trim().isEmpty())
        {
            System.err.println("Erreur le nom de la carte n'est pas conforme");
            throw new IllegalArgumentException("Erreur le nom de la carte n'est pas conforme");
        }
        else
        {
            nom = name;
        }
    }

    /**
     * donne le nom de la carte
     * @return le nom de la carte
     */
    public String getNom(){return nom;}

    /**
     * Donne la couleur de la carte
     * @return la couleur de la carte
     */
    public Couleur getColor()
    {
        return color;
    }

    /**
     * Donne la valeur de la carte
     * @return la valeur de la carte
     */
    public Valeur getValeur()
    {
        return valeur;
    }

    /**
     * Donne le nombre de point de la carte
     * @return le nombre de point de la carte
     */
    public int getNbPoint()
    {
        return nbPoint;
    }

    /**
     * Donne la catégorie de la carte
     * @return le catégorie de la carte
     */
    public Categorie getCategorie(){return  categorie;}

    /**
     * Permet de mettre une carte en chaine de caractère
     * @return couleur+valeur+catégorie+nbPoints
     */
    @Override
    public String toString() {
        return "Carte{ Nom = "+nom +
                "color=" + color +
                ", valeur=" + valeur +
                ", categorie=" + categorie+
                ", nbPoint= "+ nbPoint+
                '}';
    }
}
