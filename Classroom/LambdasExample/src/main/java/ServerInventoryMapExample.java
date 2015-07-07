
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class ServerInventoryMapExample {
    
    public static void main(String[] args) {
       Map<String,Server> serverMap = new HashMap<>();
       
       Server one = new Server();
        one.setName("web01");
        one.setIp("192.168.1.1");
        one.setMake("Dell");
        one.setRam("8GB");
        one.setNumProcessors("9");
        one.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));

        serverMap.put(one.getName(),one);

        one = new Server();
        one.setName("db01");
        one.setIp("192.168.3.45");
        one.setMake("HP");
        one.setRam("16GB");
        one.setNumProcessors("24");
        one.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));

      serverMap.put(one.getName(),one);

        one = new Server();
        one.setName("hr124");
        one.setIp("192.168.32.111");
        one.setMake("IBM");
        one.setRam("16GB");
        one.setNumProcessors("12");
        one.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));

          serverMap.put(one.getName(),one);

        one = new Server();
        one.setName("eng16");
        one.setIp("192.168.32.56");
        one.setMake("HP");
        one.setRam("4GB");
        one.setNumProcessors("8");
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        serverMap.put(one.getName(),one);

        one = new Server();
        one.setName("eng64");
        one.setIp("192.168.34.56");
        one.setMake("HP");
        one.setRam("8GB");
        one.setNumProcessors("16");
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        serverMap.put(one.getName(),one);
        
       String make = "dElL";
         System.out.println("All " + make + " servers in inventory");
         
//LAMBDAS LAMBDAS LAMBDAS LAMBDAS LAMBDAS LAMBDAS LAMBDAS LAMBDAS LAMBDAS LAMBDAS LAMBDAS LAMBDAS
         serverMap.values()
                 .stream()
                 .filter(s-> s.getMake().equalsIgnoreCase(make))
                 .forEach(e-> System.out.println(e.getName()));
         
         int testAge = 3;
         System.out.println("All servers older than "+testAge+ " years in inventory:");
         serverMap.values()
                 .stream()
                 .filter(s-> s.getServerAge()>testAge)
                 .forEach(e-> System.out.println(e.getName()));
         
         
         //collections Extract information(prints them back out/"get")
         Collection<Server> oldServers 
                 =serverMap.values()
                 .stream()
                 .filter(s-> s.getServerAge()>testAge)
                 .collect(Collectors.toList());
         
         System.out.println(oldServers.size());
         oldServers.forEach(s-> System.out.println(s.getName()));
         
         
         double averageAge = serverMap.values()
                 .stream()
                 .mapToLong(Server::getServerAge)
                 .average()
                 .getAsDouble();
         
         System.out.println("average age of servers is "+ averageAge + " years");
                 
    }

    
}
