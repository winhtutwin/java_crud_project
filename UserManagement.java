import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement {

    static ArrayList<User> users = new ArrayList<>();
    static int userIdCounter = 1; // Starting user ID

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Create User");
            System.out.println("2. Read Users");
            System.out.println("3. Update User by ID");
            System.out.println("4. Delete User by ID");
            System.out.println("0. Exit");
            System.out.print("Program Start Run ==> Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    readUsers();
                    break;
                case 3:
                    updateUserById(scanner);
                    break;
                case 4:
                    deleteUserById(scanner);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void createUser(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        User user = new User(userIdCounter++, name, email, address);
        users.add(user);

        System.out.println("User created successfully!");
    }

    private static void readUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of Users:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    private static void updateUserById(Scanner scanner) {
        System.out.print("Enter the User ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        User userToUpdate = null;
        for (User user : users) {
            if (user.id == id) {
                userToUpdate = user;
                break;
            }
        }

        if (userToUpdate == null) {
            System.out.println("User with ID " + id + " not found.");
        } else {
            System.out.print("Enter new name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                userToUpdate.name = newName;
            }

            System.out.print("Enter new email (leave blank to keep current): ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) {
                userToUpdate.email = newEmail;
            }

            System.out.print("Enter new address (leave blank to keep current): ");
            String newAddress = scanner.nextLine();
            if (!newAddress.isEmpty()) {
                userToUpdate.address = newAddress;
            }

            System.out.println("User updated successfully!");
        }
    }

    private static void deleteUserById(Scanner scanner) {
        System.out.print("Enter the User ID to delete: ");
        int id = scanner.nextInt();

        User userToDelete = null;
        for (User user : users) {
            if (user.id == id) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete == null) {
            System.out.println("User with ID " + id + " not found.");
        } else {
            users.remove(userToDelete);
            System.out.println("User deleted successfully!");
        }
    }
}
