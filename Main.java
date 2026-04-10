import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Document {
    int id;
    String name;
    String type;
    String path;
    String date;

    Document(int id, String name, String type, String path, String date) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.path = path;
        this.date = date;
    }
}

public class Main {

    static ArrayList<Document> docs = new ArrayList<>();
    static int idCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Document Management System =====");
            System.out.println("1. Add Document");
            System.out.println("2. View Documents");
            System.out.println("3. Search Document");
            System.out.println("4. Delete Document");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addDocument(sc);
                    break;
                case 2:
                    viewDocuments();
                    break;
                case 3:
                    searchDocument(sc);
                    break;
                case 4:
                    deleteDocument(sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addDocument(Scanner sc) {
        System.out.print("Enter Document Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Document Type: ");
        String type = sc.nextLine();

        System.out.print("Enter File Path: ");
        String path = sc.nextLine();

        String date = new Date().toString();

        docs.add(new Document(idCounter++, name, type, path, date));

        System.out.println("Document Added!");
    }

    public static void viewDocuments() {
        if (docs.isEmpty()) {
            System.out.println("No documents found!");
            return;
        }

        for (Document d : docs) {
            System.out.println("\nID: " + d.id);
            System.out.println("Name: " + d.name);
            System.out.println("Type: " + d.type);
            System.out.println("Path: " + d.path);
            System.out.println("Date: " + d.date);
        }
    }

    public static void searchDocument(Scanner sc) {
        System.out.print("Enter name to search: ");
        String search = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Document d : docs) {
            if (d.name.toLowerCase().contains(search)) {
                System.out.println("\nID: " + d.id);
                System.out.println("Name: " + d.name);
                System.out.println("Type: " + d.type);
                System.out.println("Path: " + d.path);
                System.out.println("Date: " + d.date);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching document found!");
        }
    }

    public static void deleteDocument(Scanner sc) {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        boolean removed = false;

        for (int i = 0; i < docs.size(); i++) {
            if (docs.get(i).id == id) {
                docs.remove(i);
                removed = true;
                break;
            }
        }

        if (removed)
            System.out.println("Document Deleted!");
        else
            System.out.println("Document Not Found!");
    }
}