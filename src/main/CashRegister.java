
public class CashRegister {

    // to build C:\gradle-7.5\bin\gradle.bat build
    // to run java -cp .\build\libs\cash_register.jar CashRegister 5 6

    static public String renderDollarAmount(int v)
    {
        String ret = "$";
        if(v < 0)
        {
            ret += "-";
            v*=-1;
        }
        ret += "" + (v/100) + ".";
        v%=100;
        ret+="" + (v/10);
        ret+="" + (v%10);
        return ret;
    }

    static private String help = "To execute command type java -cp .\\build\\libs\\cash_register.jar CashRegister <total_due> <cash_received>\n"
            +"Substitute in the total due, cash received and correct directory for the jar file.";
    static private String invalid_input_help = "Invalid Input Detected\n"+help;

    public static boolean isDollarAmount(String s)
    {
        return s.matches("\\d+") || s.matches("\\d+\\.\\d\\d");
    }

    public static String processPayment(int due, int received)
    {
        if(due < 0 || received < 0)
            throw new IllegalArgumentException("Negative numbers not allowed.");
        if(due == received)
            return renderDollarAmount(0);
        if(due > received)
            return renderDollarAmount(received - due) + " Due";
        return "";
    }

    public static String processInput(String[] input)
    {
        if(input.length == 0 || input.length==1 && input[0].equals("--help"))
        {
            return help;
        }
        if(input.length == 2 && isDollarAmount(input[0]) && isDollarAmount(input[1]))
        {
            String v1 = input[0];
            String v2 = input[1];
            if(!v1.contains(".")) {
                v1 = v1 + ".00";
            }
            if(!v2.contains(".")) {
                v2 = v2 + ".00";
            }

            // length requirement is to prevent overflow

            if(v1.matches("\\d+\\.\\d\\d") && v2.matches("\\d+\\.\\d\\d") && v2.length() < 11 && v1.length() < 11)
            {
                v1 = v1.replace(".","");
                v2 = v2.replace(".","");
                int amt1 = Integer.parseInt(v1);
                int amt2 = Integer.parseInt(v2);
                return processPayment(amt1, amt2);
            }
        }
        return invalid_input_help;
    }

    public static void main(String[] args)
    {
        System.out.println(processInput(args));
    }
}
