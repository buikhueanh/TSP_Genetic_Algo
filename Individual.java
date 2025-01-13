import java.util.ArrayList;
import java.util.Comparator;

public class Individual implements Cloneable {
    private ArrayList<Integer> gnome;
    private int fitness;

    public Individual() {
        this.gnome = new ArrayList<Integer>();
        this.fitness = 0;
    }

    // Clone method
    public Individual clone() {
        try {
            Individual copy = (Individual) super.clone();
            copy.gnome = (ArrayList<Integer>) copy.gnome.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public ArrayList<Integer> getGnome() {
        return gnome;
    }

    public void setGnome(ArrayList<Integer> gnome) {
        this.gnome = gnome;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
}
