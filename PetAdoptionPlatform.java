import java.util.ArrayList;
import java.util.Scanner;

// Pet class
class Pet {
    private String name;
    private String type;
    private int age;

    // Constructor
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be more than 0.");
        }
    }

    // toString method
    public String toString() {
        return "Pet{name='" + name + "', type='" + type + "', age=" + age + "}";
    }
}

// Shelter class
class Shelter {
    private String name;
    private ArrayList<Pet> pets;

    // Constructor
    public Shelter(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

    // Add a pet to the shelter
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    // Display all pets in the shelter
    public void displayPets() {
        if (pets.isEmpty()) {
            System.out.println("No pets available for adoption.");
        } else {
            System.out.println("Pets in " + name + ":");
            for (int i = 0; i < pets.size(); i++) {
                System.out.println((i + 1) + ". " + pets.get(i));
            }
        }
    }

    // Compare pets by age
    public void comparePets() {
        if (pets.size() < 2) {
            System.out.println("Not enough pets to compare.");
            return;
        }

        Pet oldestPet = pets.get(0);
        Pet youngestPet = pets.get(0);

        for (Pet pet : pets) {
            if (pet.getAge() > oldestPet.getAge()) {
                oldestPet = pet;
            }
            if (pet.getAge() < youngestPet.getAge()) {
                youngestPet = pet;
            }
        }

        System.out.println("Oldest Pet: " + oldestPet);
        System.out.println("Youngest Pet: " + youngestPet);
    }

    // Adopt a pet from the shelter
    public void adoptPet(int index, String adopterName) {
        if (index >= 0 && index < pets.size()) {
            Pet adoptedPet = pets.remove(index);
            System.out.println("Congratulations " + adopterName + "! You have adopted " + adoptedPet.getName() + " the " + adoptedPet.getType() + ".");
        } else {
            System.out.println("Invalid choice. Try again.");
        }
    }
}

// Main class
public class PetAdoptionPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shelter shelter = new Shelter("Happy Tails Shelter");

        // Adding sample pets
        shelter.addPet(new Pet("Bobik", "Dog", 3));
        shelter.addPet(new Pet("Barsik", "Cat", 2));
        shelter.addPet(new Pet("Bugz Bunny", "Rabbit", 1));

        System.out.println("Welcome to the Pet Adoption Platform!");

        System.out.print("Enter your name: ");
        String adopterName = scanner.nextLine();

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View all pets");
            System.out.println("2. Compare pets by age");
            System.out.println("3. Adopt a pet");
            System.out.println("4. Add a new pet");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    shelter.displayPets();
                    break;

                case 2:
                    shelter.comparePets();
                    break;

                case 3:
                    shelter.displayPets();
                    System.out.print("Enter the number of the pet you want to adopt: ");
                    int petChoice = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume the newline
                    shelter.adoptPet(petChoice, adopterName);
                    break;

                case 4:
                    System.out.print("Enter pet name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter pet type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter pet age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    shelter.addPet(new Pet(name, type, age));
                    System.out.println("Pet added successfully.");
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}



