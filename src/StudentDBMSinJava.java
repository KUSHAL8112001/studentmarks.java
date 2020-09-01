import java.io.*;
import java.util.*;

public class StudentDBMSinJava
{
    public static void main(String[] args)
    {
        boolean ProgramActive = true;
        while(ProgramActive)
        {
            Scanner sc =new Scanner(System.in);
            System.out.println("|---------------------------------------------|");
            System.out.println("|-------Welcome to Program Incorporated-------|");
            System.out.println("|---------------------------------------------|");
            System.out.println("|<<=      PRESS 1 TO ADD DATA              =>>|");
            System.out.println("|<<=      PRESS 2 TO READ DATA             =>>|");
            System.out.println("|<<=      PRESS 3 TO SEARCH DATA           =>>|");
            System.out.println("|<<=      PRESS 4 TO DELETE DATA           =>>|");
            System.out.println("|<<=      PRESS 5 TO Exit                  =>>|");
            System.out.println("|---------------------------------------------|");
            System.out.print("ENTER YOUR CHOICE : ");
            int k=sc.nextInt();
            switch (k) {
                case 1 -> add();
                case 2 -> read();
                case 3 -> search();
                case 4 -> delete();
                case 5 -> ProgramActive = false;
                default -> {System.out.println("Please Enter the Correct choice");main(null);}
            }
            if (ProgramActive){
            System.out.println("\nWant to Continue (Y/N) : ");
            String option = sc.next();
            if (option.equals("Y") || option.equals("y") || option.equals("YES") || option.equals("yes") || option.equals("Yes")){
                System.out.println("Here we go Again");
            }
            else if(option.equals("N") || option.equals("n") || option.equals("NO") || option.equals("no") || option.equals("No")){
                ProgramActive = false;
            }
            else System.out.println("Please Enter the Correct Option from Y/N");}
        }
    }

    public static void add()
    {
        File base = new File("DataBase.txt");
        boolean exists = base.exists();
        if (!exists){
            createFile();
        }
        float percentage;
        Scanner s1=new Scanner(System.in);
        try
        {
//            Reading the Inputs from the User

            System.out.print("Enter Your Name : ");
            String name=s1.nextLine();
            System.out.print("Enter Your Roll Number : ");
            String rollNumber=s1.nextLine();
            System.out.print("Enter Your Marks in English : ");
            String englishMarks=s1.nextLine();
            int en1=Integer.parseInt(englishMarks);
            System.out.print("Enter Your Hindi Marks : ");
            String hindiMarks=s1.nextLine();
            int hn1=Integer.parseInt(hindiMarks);
            System.out.print("Enter Your Maths Marks : ");
            String mathsMarks=s1.nextLine();
            int mt1=Integer.parseInt(mathsMarks);
            System.out.print("Enter Your Science Marks : ");
            String scienceMarks=s1.nextLine();
            int sc1=Integer.parseInt(scienceMarks);
            int maximumMarks=100;
            System.out.print("Maximum Marks is set as 100. Want to Change it (Y/N) : ");
            String option=s1.next();
            if (option.equals("Y") || option.equals("y") || option.equals("yes") || option.equals("Yes") || option.equals("YES"))
                maximumMarks = s1.nextInt();

//            Read the Inputs from the User

//            Finding out the Percentage

            percentage=(float)((en1+hn1+mt1+sc1)*100/(4*maximumMarks));
            String percentageFinal=Float.toString(percentage);

//            found the Percentage

//            For Space between inputs

            String afterRoll = space(rollNumber,13);
            String afterName = space(name, 32);
            String afterEnglish = space(englishMarks, 9);
            String afterHindi = space(hindiMarks, 7);
            String afterMaths = space(mathsMarks, 7);
            String afterScience = space(scienceMarks, 9);

//            Got the Spaces and now writing the data in the DataBase with the spaces acquired

//            Creating the DataBase File and writing the Data within in DataBase file

            FileWriter Obj = new FileWriter("DataBase.txt",true);

            String data = rollNumber+afterRoll+name+afterName+englishMarks+afterEnglish+hindiMarks+afterHindi+mathsMarks+afterMaths+scienceMarks+afterScience+percentageFinal+"\n";
            Obj.write(data);
            Obj.flush();
            Obj.close();
        }
        catch(IOException e)
        {
            System.out.println("DataBase not found Try Restarting the Program");
            e.printStackTrace();
        }
    }

    public static String space(String label, int noOfSpace){
        int len = label.length();
        int space = noOfSpace - len;
        return " ".repeat(Math.max(0, space));
    }

    public static void createFile(){
        try{
                FileWriter obj = new FileWriter("DataBase.txt",true);
                obj.close();
        } catch (IOException e) {
            System.out.println("Error Creating DataBase File Please Restart the Program");
        }
    }


    public static void read()
    {
        File fileObj=new File("DataBase.txt");
        try
        {
            Scanner s2=new Scanner(fileObj);
            System.out.println("Roll Number  Name                            English  Hindi  Maths  Science  Percentage");
            while(s2.hasNextLine())
            {
                String str=s2.nextLine();
                System.out.println(str);
            }
        }
        catch(IOException e )
        {
            System.out.println("FILE NOT FOUND ");
        }
    }


    public static void search()
    {
        Scanner sc =new Scanner(System.in);
        System.out.print("Want to Search by Name or Roll Number??\n" +
                "1. Roll Number\n" +
                "2. Name\n" +
                "Enter Your Choice : ");
        int opt=sc.nextInt();
        if(opt==1)
        {
            File f=new File("DataBase.txt");
            System.out.print("Enter the Roll Number : ");
            int rollNumber=sc.nextInt();
            try
            {
                Scanner scc=new Scanner(f);
                while(scc.hasNext())
                {
                    String data = scc.nextLine();
                    for (int i = 0; i<1;i++){
                        String[] arr = data.split(" ",2);
                        if(rollNumber == Integer.parseInt(arr[0])){
                            System.out.print("Roll Number  Name                            English  Hindi  Maths  Science  Percentage\n"+data);
                        }
                    }
                }
                scc.close();
            }
            catch(IOException e)
            {
                System.out.println("SORRY NOT FOUND ");
            }
        }

        else if(opt==2)
        {
            File f=new File("DataBase.txt");
            System.out.print("Enter the First Name of the Student : ");
            String firstName=sc.next();
            System.out.print("Enter the Last Name of the Student : ");
            String SecondName=sc.next();
            String nameOfStudent = firstName + " " + SecondName;
            try
            {
                boolean toDisplay = true;
                Scanner st=new Scanner(f);
                while(st.hasNext())
                {
                    String data = st.nextLine();
                    String[] arr = data.split(" ",15);
                    for (int i = 0;i<15;i++){
                        String name = arr[12]+" "+arr[13];
                        if (nameOfStudent.equals(name) && toDisplay){
                            System.out.print("Roll Number  Name                            English  Hindi  Maths  Science  Percentage\n"+data);
                            toDisplay = false;
                        }
                    }
                }
                st.close();
            }
            catch(IOException e)
            {
                System.out.println("SORRY NOT FOUND ");
            }
        }
        else
        {
            System.out.println("RECORD NOT FOUND ");
        }
    }


    public static void delete() {
        Scanner sc =new Scanner(System.in);
        System.out.print("Want to Delete by Name or Roll Number??\n1. Roll Number\n2. Name\nEnter Your Choice : ");
        int opt=sc.nextInt();
        if(opt==1)
        {
            System.out.println("Enter the Roll Number : ");
            int rollNumber = sc.nextInt();
            String main_data = "";
            File main = new File("DataBase.txt");
            try
            {
                Scanner scc=new Scanner(main);
                while(scc.hasNext())
                {
                    String data = scc.nextLine();
                    for (int i = 0; i<1;i++){
                        String[] arr = data.split(" ",2);
                        if(rollNumber == Integer.parseInt(arr[0])){
                            main_data = data;
                        }
                    }
                }
                scc.close();
            }
            catch(IOException e)
            {
                System.out.println("catch block");
            }

            try{
                File inputFile = new File("DataBase.txt");
                File tempFile = new File("DataBase_temp.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String currentLine;

                while((currentLine = reader.readLine()) != null) {
                    String trimmedLine = currentLine.trim();
                    if(trimmedLine.equals(main_data)) continue;
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
                writer.close();
                reader.close();
                boolean successful = tempFile.renameTo(inputFile);
                System.out.println(successful);
            } catch (IOException e){
                System.out.println("Hello");
            }
        }

        else if(opt==2) {
            System.out.print("Enter the First Name : ");
            String firstName = sc.next();
            System.out.print("Enter the Last Name : ");
            String lastName = sc.next();
            String mainName = firstName + " " + lastName;
            String main_data = "";
            File main = new File("DataBase.txt");
            try {
                Scanner scc = new Scanner(main);
                while (scc.hasNext()) {
                    String data = scc.nextLine();
                    String[] arr = data.split(" ",15);
                    for (int i = 0;i<15;i++){
                        String name = arr[12]+" "+arr[13];
                        if (mainName.equals(name)) {
                            main_data = data;
                            break;
                        }
                    }
                }
                scc.close();
            } catch (IOException e) {
                System.out.println("catch block");
            }

            try {
                File inputFile = new File("DataBase.txt");
                File tempFile = new File("DataBase_temp.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String currentLine;

                while ((currentLine = reader.readLine()) != null) {
                    String trimmedLine = currentLine.trim();
                    if (trimmedLine.equals(main_data)) continue;
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
                writer.close();
                reader.close();
                boolean successful = tempFile.renameTo(inputFile);
                System.out.println(successful);
            } catch (IOException e) {
                System.out.println("Hello");
            }
        }
    }
}