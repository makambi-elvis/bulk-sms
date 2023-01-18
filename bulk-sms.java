import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SMS {

    private static final String ACCOUNT_SID = "your_account_sid";
    private static final String AUTH_TOKEN 

= "your_auth_token";
    private static List<String> phoneNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add phone number");
            System.out.println("2. Delete phone number");
            System.out.println("3. Send bulk SMS");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    phoneNumbers.add(phoneNumber);
                    System.out.println("Phone number added successfully");
                    break;
                case 2:
                    System.out.println("Enter phone number:");
                    phoneNumber = scanner.nextLine();
                    phoneNumbers.remove(phoneNumber);
                    System.out.println("Phone 

number deleted successfully");
                    break;
                case 3:
                    System.out.println("Enter message:");
                    String message = scanner.nextLine();
                    sendSMS(message);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void sendSMS(String 

message) {
        for (String phoneNumber : phoneNumbers) {
            Message sms = Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber("your_twilio_phone_number"), message).create();
            System.out.println(sms.getSid());
        }
    }
}
