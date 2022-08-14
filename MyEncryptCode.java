import java.util.Scanner;

public class MyEncryptCode{

    //modified key
    public static String createKey(String key, String message){
        String newKey = "";
        for(int i=0;i<message.length()/key.length();i++){
            newKey += key;
        }
        for(int i=0;i<message.length()%key.length();i++){
            newKey += key.charAt(i);
        }
        return newKey;
    }
   

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        //encode or decode
        System.out.println("Press 0 to encode your message or Press 1 to decode your decrypted text");
        int EncodeDecode = input.nextInt();

        //encode
        if(EncodeDecode == 0){
            //enter key
            System.out.print("Enter your key here : ");
            String key = input.next();
            input.nextLine();

            //enter message
            System.out.print("Enter your message here : ");
            String message = input.nextLine();

            //get modified key
            String newKey = createKey(key,message);

            String code = "";
            
            for(int j=0;j<message.length();j++){
                if(j%2 == 0){
                    int ch1 = newKey.charAt(j) + message.charAt(j) + 22 ;

                        ch1 = ch1 - 138 ; 
                    
                    code += Character.toString(ch1);
                }
                else {
                    int ch1 = newKey.charAt(j) + message.charAt(j) + 20 ;
                        ch1 = ch1 - 138 ;

                    code += Character.toString(ch1);
                }
            }
            //print
            System.out.print(code);
        }

        //decode
        else if(EncodeDecode == 1){
            //enter key
            System.out.print("Enter your key here : ");
            String key = input.next();
            input.nextLine();

            //enter decrypted text
            System.out.print("Enter your decrypted text here : ");
            String message = input.nextLine();

            //get modified key
            String newKey = createKey(key,message);

            String code = "";

            for(int j=0;j<message.length();j++){
                if(j%2 == 0){
                    int ch1 = message.charAt(j);
                        
                        ch1 = ch1 + 138;
                    
                    ch1 = ch1 - newKey.charAt(j) - 22 ;
                   
                    code += Character.toString(ch1);
                }
                else {
                    int ch1 = message.charAt(j);
                    
                        ch1 = ch1 + 138;
                    
                    ch1 = ch1 - newKey.charAt(j) - 20 ;
                    
                    code += Character.toString(ch1);
                }
            }
            //print
            System.out.print(code);  
        }
    }
}
