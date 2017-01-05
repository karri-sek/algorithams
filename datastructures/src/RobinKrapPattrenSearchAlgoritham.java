import java.util.ArrayList;
import java.util.List;

/**
 * Created by sekhar on 5/1/17.
 */
public class RobinKrapPattrenSearchAlgoritham  {

    private int pattrenHash;

    private int textHash;

    private String text;
    private String pattren;

    public RobinKrapPattrenSearchAlgoritham(String text, String pattren){
        this.text = text;
        this.pattren = pattren;
    }

    public static  void main(String[] args){
        RobinKrapPattrenSearchAlgoritham obj = new RobinKrapPattrenSearchAlgoritham("AABAACAADAABAABA","AABA");
        obj.initializePatterns();
        obj.findPattrenIndex();


    }

    public List<Integer> findPattrenIndex(){
        List<Integer> listOfIndexes = new ArrayList<>();
        for(int i=0; i<text.length() - pattren.length();i++){
            if(pattrenHash == textHash){
                int j = 0;
                for(j=0;j<pattren.length();j++){
                    if(pattren.charAt(j) != text.charAt(j)){
                        break;
                    }
                }
                if(j == pattren.length()){
                    listOfIndexes.add(i);
                }
            }
            Double d = Math.pow(33,pattren.length()-1);
            textHash = ((textHash - text.charAt(i) * d.intValue()) + text.charAt(i+pattren.length()))  % 101;
            System.out.println("text hash "+textHash);
        }

        return listOfIndexes;
    }

    public int initializePatterns(){

        pattrenHash = getHashvalue(pattren);

        textHash = getHashvalue(text.substring(0,pattren.length()));
       System.out.print(" pattren "+pattrenHash);
        System.out.print(" firstSubstringPattren "+textHash);
        return 0;

    }

    public int getHashvalue(String pattren){
        System.out.print(" pattren "+pattren);
        int h = 0;
        int powIndex = pattren.length();
       char[] pattrenCharArray = pattren.toCharArray();
        for(char c:pattrenCharArray){
           Double d=  Math.pow(33,powIndex-1);
            h = (c * d.intValue()) % 101;
        }
        return h;
    }
}
