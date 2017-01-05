package test;

public class RabinKrap {
  private static int NO_OF_CHARCTERS = 256;
    public static void main(String[] args) {
	RabinKrap obj = new RabinKrap();
	char[] chars = {'B','A', 'C'};
	obj.getPatternHashValue(chars, 33);

    }
    
    public void search(char[] text, char[] pattern, int prime){
	
	
    }
    
    public void getPatternHashValue(char[] pattern, int prime){
	int patternHash = 0;
	for(char c:pattern){
	    patternHash = (NO_OF_CHARCTERS * patternHash + c) % prime;  
	}
	System.out.println(">>> "+patternHash);
    }

}
