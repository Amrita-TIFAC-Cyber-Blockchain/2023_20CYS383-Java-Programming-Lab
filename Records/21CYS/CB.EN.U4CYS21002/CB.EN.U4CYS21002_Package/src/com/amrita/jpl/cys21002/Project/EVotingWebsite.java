import java.io.FileWriter;
import java.io.IOException;

public class EVotingWebsite {

    public static void main(String[] args) {
        generateVotingPage();
    }

    private static void generateVotingPage() {
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>E-Voting Website</title>\n" +
                "    <style>\n" +
                "        /* Add your custom styles here */\n" +
                "    </style>\n" +
                "    <script>\n" +
                "        function showPrompt() {\n" +
                "            alert('Vote submitted!');\n" +
                "        }\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Welcome to E-Voting</h1>\n" +
                "    <h3>Please cast your vote:</h3>\n" +
                "    <form id=\"votingForm\" action=\"submit_vote\" method=\"post\">\n" +
                "        <input type=\"radio\" name=\"candidate\" value=\"candidate1\">\n" +
                "        <label for=\"candidate1\">Candidate 1</label><br>\n" +
                "        <input type=\"radio\" name=\"candidate\" value=\"candidate2\">\n" +
                "        <label for=\"candidate2\">Candidate 2</label><br>\n" +
                "        <input type=\"radio\" name=\"candidate\" value=\"candidate3\">\n" +
                "        <label for=\"candidate3\">Candidate 3</label><br>\n" +
                "        <button type=\"submit\" onclick=\"showPrompt()\">Submit Vote</button>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";

        try {
            FileWriter fileWriter = new FileWriter("voting_page.html");
            fileWriter.write(htmlContent);
            fileWriter.close();
            System.out.println("Voting page generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
