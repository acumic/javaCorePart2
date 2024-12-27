import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {

        String log = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3";
        part1(log);
        part2(log);
        String text = "test 2667843 (test_email@griddynamics.com) test 67483 some string";
        part3(text);
        String input = "app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 poiFileName=Integration_test_Contract INFO  LogUtils - POI file name: [Integration_test_Contract], total number of orders successfully processed: [2]";
        part4(input);
    }

    static void part1(String log){

        System.out.println("\n1.");

        String regex = "orderUUID=[a-fA-F0-9\\-]{36}";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(log);

        boolean contains = matcher.find();

        System.out.println("Contains: orderUUID: " + contains);

    }

    static void part2(String log){

        System.out.println("\n2.");

        String regex = "orderUUID=[a-fA-F0-9\\-]{36}";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(log);

        if(matcher.find()){
            String orderUUID = matcher.group(0);
            System.out.println("orderUUID: " + orderUUID.split("=")[1]);
        } else {
            System.out.println("orderUUID doesn't exist");
        }

    }

    static void part3(String test){

        System.out.println("\n3.");

        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(test);

        if(matcher.find()){
            String email = matcher.group();
            System.out.println("Extracted email: " + email);
        } else {
            System.out.println("There is no mail in the log.");
        }

    }

    static void part4(String input){

        System.out.println("\n4.");

        String regex = "total number of orders successfully processed: \\[(\\d+)\\]";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            String noOfOrders = matcher.group(1);
            System.out.println("Number of orders: " + noOfOrders);
        } else {
            System.out.println("No orders were found.");
        }

    }

}
