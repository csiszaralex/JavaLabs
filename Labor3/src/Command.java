import java.io.File;

public interface Command {
    /**
     * Végrehajtja a parancsot. Ha módosul a paraméterként megkapott mappa (wd), akkor visszatér az új mappával.
     * Ha nem módosul, az eredetit adja vissza.
     * A cmd tömb tartalmazza a parancs paramétereit, a 0. indexű paraméter maga a parancs neve.
     */
    File execute(File wd, String[] cmd);

    /**
     * Visszatér a parancs leírásával.
     */
    String help();

    /**
     * Visszatér a parancs nevével.
     */
    String name();
}
