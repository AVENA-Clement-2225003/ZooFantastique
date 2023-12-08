package includes.creatures;

import java.util.ArrayList;

public class Colonie {

    private ArrayList<Meute> meutes;

    public Colonie(ArrayList<Meute> meutes) {
        this.meutes = meutes;
    }

    public ArrayList<Meute> getMeutes() {
        return meutes;
    }

    public void setMeutes(ArrayList<Meute> meutes) {
        this.meutes = meutes;
    }
}
