// lav file object
// iterere over filens bogstaver
// optæl forekomster for hvert bogstav
// udregn samlet antal bogstaver
// udregn procentvis fordeling af bogstaver
// udskriv


import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Alice {
    static String path = System.getProperty("user.dir") + "/";
    public static void main(String[]args){
        try{
            File file = new File(path + "AliceInWonderland.txt");
            if(file.isFile()){
                Scanner scanner = new Scanner(file);
                // iterer filen én gang
                Map<Character,Integer> map = new TreeMap<>();
                for(int i = 97; i < 123 ; i++){
                    map.put((char)i,0);// initialiserer vi map med ASCII alfabetet
                }
                String line = "";
                double counter = 0.0;
                while(scanner.hasNextLine()){
                    line = scanner.nextLine().toLowerCase();
                    for (Character c : line.toCharArray()){
                        if(Character.isLetter(c)) {
                            map.put(c, map.get(c) + 1);
                            counter++;
                        }
                        }
                    }
                    System.out.println("count: " + counter );
                    for(Map.Entry<Character,Integer> entry: map.entrySet()){
                        double d = (entry.getValue() / counter) * 100.0; // procentfordelingen af bogstaver
                        System.out.println("Letter " + entry.getKey()+ " occurence: " + d);
                    }
                System.out.println("42");
                String words = "";
                int wordCounter = 0;
                while (scanner.hasNextLine()){
                        words = scanner.next();
                        for( wordCounter = 0 ; scanner.hasNext(); wordCounter++){


                        }
                        System.out.println(wordCounter);

                }


            }
            else{
                System.out.println("file not found");
            }


        }catch (Exception e){

        }

    }
}
