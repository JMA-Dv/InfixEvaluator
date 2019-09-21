import java.util.Stack;

public class Conversion {

    private Stack s;

    private String input;

    private String output = "";

    public Conversion(String str) {

        input = str;

        s= new Stack();

    }

    public String inToPost() {

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            switch (ch) {

                case '+':

                case '-':

                    gotOperator(ch, 1);

                    break;

                case '*':

                case '/':

                    gotOperator(ch, 2);

                    break;

                case '(':

                    s.push(ch);

                    break;

                case ')':

                    gotParenthesis();

                    break;

                default:

                    output = output + ch;

            }

        }

        while (!s.isEmpty()) {
            output = output + s.pop();
        }

        return output;

    }

    private void gotOperator(char opThis, int gerargicValue) {

        while (!s.isEmpty()) {

            char opTop =(char) s.pop();

            if (opTop == '(') {

                s.push(opTop);

                break;

            } else {

                int prec2;

                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                if (prec2 < gerargicValue) {

                    s.push(opTop);

                    break;

                } else {
                    output = output + opTop;
                }

            }

        }

        s.push(opThis);

    }

    private void gotParenthesis() {

        while (!s.isEmpty()) {

            char ch =(char) s.pop();

            if (ch == '(') {
                break;
            } else {
                output = output + ch;
            }

        }

    }
}
