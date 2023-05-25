import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String address;

    public Contact(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
}

class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phone book is empty.");
            return;
        }

        System.out.println("Phone book contacts:");
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone number: " + contact.getPhoneNumber());
            System.out.println("Address: " + contact.getAddress());
            System.out.println();
        }
    }
}

public class PhoneBookApplication {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Phone Book Application");
            System.out.println("----------------------");
            System.out.println("1. Add a contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. Display all contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter contact address: ");
                    String address = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber, address);
                    phoneBook.addContact(contact);
                    break;
                case 2:
                    System.out.print("Enter contact name to search: ");
                    String searchName = scanner.nextLine();
                    Contact searchedContact = phoneBook.searchContact(searchName);
                    if (searchedContact != null) {
                        System.out.println("Contact found:");
                        System.out.println("Name: " + searchedContact.getName());
                        System.out.println("Phone number: " + searchedContact.getPhoneNumber());
                        System.out.println("Address: " + searchedContact.getAddress());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    phoneBook.displayAllContacts();
                    break;
                case 4:
                    System.out.println("Exiting phone book application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                    break;
            }

            System.out.println(); // Add a blank line for better readability
        }
    }
}
