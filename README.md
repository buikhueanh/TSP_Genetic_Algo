# 🧬 Traveling Salesman Problem (TSP) Solver using Genetic Algorithm

A Java-based implementation of a **Genetic Algorithm** to approximate the optimal route in the classic **Traveling Salesman Problem (TSP)**. This project showcases algorithmic problem-solving, object-oriented programming, and evolutionary computing techniques to tackle NP-hard path optimization challenges.

---

## 🧠 Project Summary

This program simulates biological evolution (selection, mutation, and reproduction) to minimize the total travel cost of visiting a list of cities exactly once and returning to the start. It efficiently explores the solution space and converges toward an optimal or near-optimal route.

> Ideal for problems where brute-force is computationally expensive and heuristic solutions are preferred.

---

## ⚙️ Key Features

- ✅ Input parser for multiple TSP datasets (e.g., `indiana.txt`, `tsp21.txt`, `us.txt`)
- 🧬 Genetic Algorithm with:
  - Custom **gnome encoding** of city paths
  - Fitness-based selection and mutation
  - Population evolution over multiple generations
- 📈 Dynamic fitness tracking and result output
- 🧪 Modular object-oriented design with:
  - `GeneticAlgo.java` – Main logic and evolution loop
  - `Helper.java` – Input parsing and preprocessing
  - `Individual.java` – Genetic representation
  - `IndividualComparator.java` – Fitness-based sorting
  - `Driver.java` – Program entry point

---

## 🧬 How It Works

1. **Initialization**: Load city and distance matrix from a file.
2. **Population Construction**: Create an initial pool of randomized paths ("gnomes").
3. **Fitness Evaluation**: Lower travel cost = higher fitness.
4. **Selection & Mutation**: Keep better solutions, mutate them slightly to generate new offspring.
5. **Evolution**: Repeat for `n` generations, tracking the best route.

---

## 📂 Project Structure

TSP_Genetic_Algorithm/
│
├── test/ # Contains input files like indiana.txt, tsp21.txt
├── Driver.java # Main program entry
├── GeneticAlgo.java # Core logic for GA-based optimization
├── Helper.java # Input file selection & preprocessing
├── Individual.java # Encapsulation of a candidate solution
├── IndividualComparator.java # Sorting population by fitness

