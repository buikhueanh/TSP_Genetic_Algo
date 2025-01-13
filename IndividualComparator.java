import java.util.Comparator;

public class IndividualComparator implements Comparator<Individual> {
    // Comparator sort in Ascending order
    @Override
    public int compare(Individual t1, Individual t2) {
        if (t1.getFitness() < t2.getFitness()) {
            return -1;
        }
        else if (t1.getFitness() > t2.getFitness()) {
            return +1;
        }
        else {
            return 0;
        }
    }
}
