
import java.io.FileNotFoundException;
import java.io.IOException;


public class ClassRosterController {

    private ClassRoster roster = new ClassRoster();
    private ConsoleIO con = new ConsoleIO();

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            roster.loadRoster();
            while (keepGoing) {
                printMenu();
                menuSelection = con.readInt("please select fromt the above choices.", 1, 5);

                switch (menuSelection) {
                    case 1:
                        con.print("Listing student IDs...");
                        listStudents();
                        break;
                    case 2:
                        con.print("Create new student...");
                        createStudent();
                        break;
                    case 3:
                        con.print("View student information...");
                        viewStudent();
                        break;
                    case 4:
                        con.print("Removing student...");
                        removeStudent();
                        break;

                    case 5:
                        con.print("Exit");
                        keepGoing = false;
                        break;

                    default:
                        con.print("Unknown input");
                }

            }
            con.print("Thank you for playing...");
            roster.writeRoster();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading roster");
        }catch(IOException e){
            System.out.println("Error writing the file");
        }

    }

    private void printMenu() {
        con.print("Main Menu");
        con.print("1.List student Ids");
        con.print("2.Create a new student");
        con.print("3.View a student");
        con.print("4.Remove a student");
        con.print("5.Exit");

    }

    public void listStudents() {
        String[] studentIds = roster.getAllStudentIds();
        for (int i = 0; i < studentIds.length; i++) 
        
        {
            Student currentStudent = roster.getStudent(studentIds[i]);
            con.print(studentIds[i] + ": " + currentStudent.getFirstName() + " " + currentStudent.getLastName());
        }

        con.readString("Please hit enter to continue");

    }

    public void createStudent() {
        String studentId = con.readString("Please enter student ID");
        String firstName = con.readString("Please enter first name");
        String lastName = con.readString("Pleas enter last name");
        String cohort = con.readString("Please enter cohort");
        Student currentStudent = new Student(studentId);

        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);

        roster.addStudent(studentId, currentStudent);
        con.readString("Student successfully created. Please hit enter to continue");

    }

    public void viewStudent() {
        String studentId = con.readString("Please enter the ID of the student you wish to view");
        Student currentStudent = roster.getStudent(studentId);
        if (currentStudent != null) {
            con.print(currentStudent.getStudentId());
            //currentStudent.setFirstName(firstName);
            con.print(currentStudent.getFirstName());
            con.print(currentStudent.getCohort());
            con.print("");
        }else{
        con.print("No student with ID: " +studentId);
        
        }
    }

    public void removeStudent() {
        String studentId = con.readString("Please enter the ID of the student to be removed");
        roster.removeStudent(studentId);
        con.readString("Student successfully removed. Please hit to continue.");
        
    }

    public void exit() {

    }
}
