
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {
        List<Server> servers = new ArrayList<>();
        Server one = new Server();
        one.setName("web01");
        one.setIp("192.168.1.1");
        one.setMake("Dell");
        one.setRam("8GB");
        one.setNumProcessors("9");
        one.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);
       
        one = new Server();

        one.setName("db01");
        one.setIp("192.168.3.45");
        one.setMake("HP");
        one.setRam("16GB");
        one.setNumProcessors("24");
        one.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);
        
        one = new Server();

        one.setName("hr124");
        one.setIp("192.168.32.111");
        one.setMake("IBM");
        one.setRam("16GB");
        one.setNumProcessors("12");
        one.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);
       
        one = new Server();

        one.setName("eng16");
        one.setIp("192.168.32.56");
        one.setMake("HP");
        one.setRam("4GB");
        one.setNumProcessors("8");
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        one = new Server();
       
        one.setName("eng64");
        one.setIp("192.168.34.56");
        one.setMake("HP");
        one.setRam("8GB");
        one.setNumProcessors("16");
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        String make = "dElL";

        System.out.println("All " + make + " servers in inventory: ");

        servers.stream()//stream is an object
                .filter((Server s) -> {
                    return s.getMake().equalsIgnoreCase(make);
                }) //pom file ---> change 1.7 to 1.8 to registure Lambdas
                // Lambdas must return boolean???
                .forEach((Server e) -> System.out.println(e.getName()));

        long testAge = 4;
        System.out.println("All servers older than " + testAge + " years in inventory: ");

        servers
                .stream()
                .filter(s -> s.getServerAge() > testAge)
                .forEach(e -> System.out.println(e.getName()));

        List<Server> oldServers
                = servers
                .stream()
                .filter(s -> s.getServerAge() > testAge)
                .collect(Collectors.toList());//sends data to ArrayList

        System.out.println(oldServers.size());//prints out requested servers

        oldServers.forEach(s -> System.out.println(s.getName()));

    // for (Server q: oldServers)
//        {
//        System.out.println(q:getName());
//        }
        double averageAge
                = servers
                .stream()
                //.mapToLong(Server::getServerAge) //:: >>> calling method w/in that type
                .mapToLong(s -> s.getServerAge())
                .average()
                .getAsDouble();

        System.out.println("Average age of servers is " + averageAge + " years.");
        Map<String, List<Server>> groupServers
                = servers.stream()
                .collect(Collectors.groupingBy(Server::getMake));
            for (String svrMake : groupServers.keySet()) {
            System.out.println("Server make: " + svrMake);
            for (Server s : groupServers.get(svrMake)) {
                System.out.println("Server name: " + s.getName());
            }
        }
    }

}
