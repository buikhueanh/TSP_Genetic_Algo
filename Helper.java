import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Helper {
    private Map<Integer, String> getDictionary() {
        Map<Integer, String> dic = new HashMap<Integer, String>();
        dic.put(1, "test/indiana.txt");
        dic.put(2, "test/tsp.txt");
        dic.put(3, "test/tsp9.txt");
        dic.put(4, "test/tsp21.txt");
        dic.put(5, "test/tsp99.txt");
        dic.put(6, "test/us.txt");

        return dic;
    }
    private int chooseFile() {
        int fileMode;
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("There are 6 different files:");
            System.out.println("1. Indiana");
            System.out.println("2. TSP");
            System.out.println("3. TSP9");
            System.out.println("4. TSP21");
            System.out.println("5. TSP99");
            System.out.println("6. US");
            System.out.println("Please input the corresponding number to choose your file:");
            try {
                fileMode = s.nextInt();
                switch (fileMode) {
                    case 1:
                        System.out.println("You chose Indiana.");
                        return 1;

                    case 2:
                        System.out.println("You chose TSP");
                        return 2;

                    case 3:
                        System.out.println("You chose TSP9");
                        return 3;

                    case 4:
                        System.out.println("You chose TSP21");
                        return 4;

                    case 5:
                        System.out.println("You chose TSP99");
                        return 5;
                    case 6:
                        System.out.println("You chose US");
                        return 6;
                    default:
                        System.out.println("Incorrect Input.");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please re-enter a valid number");
                continue;
            }
        }
    }
    public String getInput() {
        Map<Integer, String> dic = getDictionary();
        int fileMode = chooseFile();
        String fileName = dic.get(fileMode);
        try {
            File file = new File (fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Cannot find the file");
        }
        return fileName;
    }

    public int getNumCities(String fileName) {
        try {
            String numCitiesString = Files.readAllLines(Paths.get(fileName)).get(0);
            int numCities = Integer.parseInt(numCitiesString);
            return numCities;
        } catch (Exception e) {
            System.out.println("Cannot find the file");
        }
        return 0;
    }

    public ArrayList<String> getCitiesList(String fileName, int numCities) {
        ArrayList<String> citiesList = new ArrayList<String>();
        String cityName;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            for (int i = 1; i < numCities + 1; i++) {
                cityName = Files.readAllLines(Paths.get(fileName)).get(i);
                citiesList.add(cityName);
            }
        } catch (Exception e) {
            System.out.println("Cannot find the file");
        }
        return citiesList;
    }

    public int[][] getWeights(String fileName, int numCities) {
        int[][] weights = new int[numCities][numCities];
        int skippedLine = numCities + 1;
        try {
            for (int row = 0; row < numCities; row++) {
                String line = Files.readAllLines(Paths.get(fileName)).get(skippedLine);
                for (int i = 0; i < numCities; i++) {
                    String[] line1 = line.trim().split(" ");
                    weights[row][i] = Integer.parseInt(line1[i]);
                }
                skippedLine++;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return weights;
    }
}
