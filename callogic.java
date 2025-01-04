public class callogic {
    static double convert(String s)
    {   String op1="";
    String op2="";
    char op='\0';
    double res=0;
    int i=0;
    for( i=0;i<s.length();i++)
    {   char a=s.charAt(i);
        if(a=='x'||a=='+'||a=='-'||a=='/'){
        op=a;
            break;
        }
        op1+=a;
    }
    i++;
  op2=s.substring(i);
    double a1=Double.parseDouble(op1);
    double a2=Double.parseDouble(op2);
    switch (op) {
        case '+':
            res=a1+a2;
            break;
        case '-':
        res=a1-a2;
        break;
        case 'x':
        res=a1*a2;
        break;
        case '/':
        try{
res=a1/a2;
        }
        catch(ArithmeticException e)
        {
            System.out.println("e");
        res=Double.MAX_VALUE;
        }
        break;
        default:
            break;
    }

    return res;

    }
  
    
}
