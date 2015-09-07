import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by bruno on 9/6/15.
 * Problem 12 in Chapter 2 of the second edition
 * of Information Security by Mark Stamp
 */
public class Problem12Ch2 {
  private HashMap<Character,Integer> freq = null;
  private String cipherText;
  /**
   * This creates an empty dictionary with empty
   * frequency counts
   */
  public Problem12Ch2(){
    this.cipherText = null;
    this.freq = new HashMap<>(  );
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    for(Character c: alphabet){
      freq.put( c , 0 );
    }
  }

  public static void main(String[] args)throws FileNotFoundException{
    Scanner in = new Scanner( System.in );
    String cipherText = in.nextLine();
    System.out.println( "Ciphertext: " + cipherText );
    Problem12Ch2 obj = new Problem12Ch2();
    try {
      obj.addCipherText( cipherText );
    }catch ( Exception e ){
      e.printStackTrace();
    }
    obj.printMap();
    System.out.print( "Guess: " );
    Integer guess = in.nextInt();
    System.out.println( "Plaintext: " + obj.decryptWith( guess ) );
  }

  public void addCipherText(String cipherText) throws Exception{
    this.cipherText = cipherText.toUpperCase();
    for( Character c: this.cipherText.toCharArray()){
      if(this.freq.containsKey( c )){
        this.freq.put( c, this.freq.get( c ) + 1 );
      }else{
        throw new Exception( "unknown character " + c );
      }
    }
  }

  public void printMap(){
    System.out.format( "%-10s%s\n", "character", "frequency" );
    for( Map.Entry<Character,Integer> c: this.freq.entrySet()){
      System.out.format( "%-10s%d\n", c.getKey(),c.getValue() );
    }
  }

  public String decryptWith(int key){
    StringBuilder plainTextBuilder = new StringBuilder(  );
    char tmp;
    System.out.println( this.cipherText );
    for(Character c : this.cipherText.toCharArray()){
      tmp =(char)( c - key);
      if(tmp < 'A'){
        tmp += 26;
      }
      plainTextBuilder.append( tmp );
    }
    return plainTextBuilder.toString().toLowerCase();
  }
}
