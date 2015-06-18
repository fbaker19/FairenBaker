
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ClassRoster {

    public static final String ROSTER_FILE = "roster.txt";

    public static final String DELIMITER = "::";

    private HashMap<String, Student> students = new HashMap<String, Student>();

    public void loadRoster() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        String currentLine;
        String[] currentTokens;//string array----> String []

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Student currentStudent = new Student(currentTokens[0]);

            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);

            students.put(currentStudent.getStudentId(), currentStudent);

        }
        sc.close();
    }

    public void writeRoster() throws IOException {//saves to file
        PrintWriter out = new PrintWriter(new FileWriter(ROSTER_FILE));
        
        String[] keys = this.getAllStudentIds();
        
        for (int i = 0; i < keys.length; i++) {
            Student currentStudent = this.getStudent(keys[i]);
            out.println(currentStudent.getStudentId() + DELIMITER + currentStudent.getFirstName() + DELIMITER
                    + currentStudent.getLastName() + DELIMITER + currentStudent.getCohort());

            out.flush();

        }
                out.close();
    }

    public String[] getAllStudentIds() {
        Set<String> keySet = students.keySet();
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }

    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    public void addStudent(String studentId, Student student) {
        students.put(studentId, student);
    }

    public Student removeStudent(String studentId) {

        return students.remove(studentId);
//       con.readString("Student");
//       return 
    }
}
