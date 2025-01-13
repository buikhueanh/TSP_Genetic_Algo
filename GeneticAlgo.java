import java.util.*;

public class GeneticAlgo {
    private int popSize = 10;
    private Random r = new Random();
    private int numCities;
    private ArrayList<String> citiesList;
    private int[][] weights;
    public GeneticAlgo() {
        Helper h = new Helper();
        String input = h.getInput();
        this.numCities = h.getNumCities(input);
        this.citiesList = h.getCitiesList(input, numCities);
        this.weights = h.getWeights(input, numCities);
    }
    // genRandom function generate a random number between 1 and (numCities - 1)
    private int genRandom() {
        int num = r.nextInt(numCities - 1) + 1;
        return num;
    }

    private ArrayList<Integer> createGnome() {
        int newGnome;
        ArrayList<Integer> gnomes = new ArrayList<Integer>();
        // Add the initial cities
        gnomes.add(0);
        while (true) {
            if (gnomes.size() == numCities) {
                gnomes.add(0);
                break;
            }
            newGnome = genRandom();
            if (!gnomes.contains(newGnome)) {
                gnomes.add(newGnome);
            }
        }
        return gnomes;
    }

    // shuffle the gnome to create the population
    private ArrayList<Integer> mutatedGene(ArrayList<Integer> gnome) {
        while (true) {
            int r1 = genRandom();
            int r2 = genRandom();
            if (r1 != r2) {
                int temp = gnome.get(r1);
                gnome.set(r1, gnome.get(r2));
                gnome.set(r2, temp);
                break;
            }
        }
        return gnome;
    }

    private int calculateFitness(ArrayList<Integer> gnome) {
        int f = 0;
        for (int i = 0; i < gnome.size() - 1; i++) {
            f += weights[gnome.get(i)][gnome.get(i+1)];
        }
        return f;
    }

    // Population consists of Individual
    private ArrayList<Individual> constructPop() {
        ArrayList<Individual> pop = new ArrayList<Individual>();
        Individual individual = new Individual();
        for (int i = 0; i < popSize; i++) {
            ArrayList<Integer> currGnome = createGnome();
            int currGnomeFitness = calculateFitness(currGnome);
            individual.setGnome(currGnome);
            individual.setFitness(currGnomeFitness);
            Individual temp = individual.clone();
            pop.add(temp);
        }
        return pop;
    }

    public void print(ArrayList<Integer> gnomes) {
        System.out.print("[ ");
        for (int i = 0; i < gnomes.size(); i ++ ) {
            System.out.print( gnomes.get(i) + " ");
        }
        System.out.println("]");
    }

    public void getTSPSolution() {
        // Generation number
        int gen = 0;
        // Number of Gene Iterations
        int genThres = 10;

        // Construct the population
        List<Individual> pop = constructPop();

        // Iteration to perform population crossing and gene mutation
        while (gen < genThres) {
            Collections.sort(pop, new IndividualComparator());
            System.out.println("Generation " + (gen + 1) + " of population " + popSize);
            print(pop.get(0).getGnome());
            System.out.println("Fitness: " + pop.get(0).getFitness());
            List<Individual> newPop = new ArrayList<Individual>();

            for (int i = 0; i < popSize; i++) {
                Individual parent = pop.get(i);

                while (true) {
                    ArrayList<Integer> newG = mutatedGene(parent.getGnome());
                    Individual newGnome = new Individual();
                    newGnome.setGnome((ArrayList<Integer>) newG.clone());
                    newGnome.setFitness(calculateFitness(newGnome.getGnome()));
                    if (newGnome.getFitness() <= parent.getFitness()) {
                        newPop.add(newGnome);
                        break;
                    }
                }
            }
            pop = newPop;
            gen++;
        }
        Collections.sort(pop, new IndividualComparator());
        // After sort, the individual with the smallest f will be the first element in pop
        System.out.println("The Solution to the Traveling Salesperson Problem: ");
        Individual smallestFitness = pop.get(0);
        ArrayList<Integer> smallestFitnessGnome = smallestFitness.getGnome();
        for (int i = 0; i < smallestFitnessGnome.size(); i++) {
            int cityIndex = smallestFitnessGnome.get(i);
            System.out.println(citiesList.get(cityIndex));
        }
        System.out.println("Cost of the travel: " +  smallestFitness.getFitness());
    }
}
