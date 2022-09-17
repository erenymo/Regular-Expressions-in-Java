import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranscriptParser {
    public static void main(String[] args) {
       String transcript = """
               Student Number:	1234598872			Grade:		11
               Birthdate:		01/02/2000			Gender:	M
               State ID:		8923827123
                              
               Cumulative GPA (Weighted)		3.82
               Cumulative GPA (Unweighted)	3.46
               """;

        String regex = """
                Student\\sNumber:\\s(?<studentNum>\\d{10}).* # Grab student number
                Grade:\\s+(?<grade>\\d{1,2}).* # Grab the grade
                Birthdate:\\s+(?<birthMonth>\\d{2})/(?<birthDay>\\d{2})/(?<birthYear>\\d{4}).* # Grab birthdate
                Gender:\\s+(?<gender>\\w+)\\b.* # Grab the grade
                State\\sID:\\s+(?<stateID>\\d+)\\b.* # Grab state ID
                Weighted[)]\\s+(?<weightedGPA>[\\d\\.]+)\\b.* # Grab cumulative gpa weighted
                Unweighted[)]\\s+(?<unweightedGPA>[\\d\\.]+)\\b.* # Grab cumulative gpa unweighted

                """;
        Pattern pat = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS);
       Matcher mat = pat.matcher(transcript);
       if (mat.matches()) {
           System.out.println("Student Number : "+mat.group("studentNum"));
           System.out.println("Gra : "+mat.group("grade"));
           System.out.println("Birth Mont : "+mat.group("birthMonth"));
           System.out.println("Birth Day : "+mat.group("birthDay"));
           System.out.println("Birth Year : "+mat.group("birthYear"));
           System.out.println("Gender : "+mat.group("gender"));
           System.out.println("State : "+mat.group("stateID"));
           System.out.println("Cumulative GPA (Weighted) : "+mat.group("weightedGPA"));
           System.out.println("Cumulative GPA (Unweighted) : "+mat.group("unweightedGPA"));
       }
    }
}
