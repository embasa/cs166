/**
 * This is to solve problem 10 in chapter 2 of Information Security edition 2 by Mark Stamp
 * Created by bruno on 9/7/15.
 */
public class AliceCipher {
  public static void main(String[] args){
    String string ="MXDXBVTZWVMXNSPBQXLIMSCCSGXSCJXBOVQXCJZMOJZCVCTVWJCZAAXZBCSSCJXBQCJZCOJZCNSPOXBXSBTVWJCJZDXGXXMOZQMSCSCJXBOVQXCJZMOJZCNSPJZHGXXMOSPLHJZDXZAAXZBXHCSCJXTCSGXSCJXBOVQX";

    string = string.replace( "X", "e" );//1
    string = string.replace( "M", "n" );//2
    string = string.replace( "B", "r" );
    string = string.replace( "D", "v" );
    string = string.replace( "V", "i" );
    string = string.replace( "T", "m" );
    string = string.replace( "Z", "a" );
    string = string.replace( "W", "g" );
    string = string.replace( "N", "y" );
    string = string.replace( "S", "o" );
    string = string.replace( "P", "u" );
    string = string.replace( "Q", "s" );
    string = string.replace( "L", "l" );
    string = string.replace( "I", "f" );
    string = string.replace( "C", "t" );
    string = string.replace( "G", "b" );
    string = string.replace( "J", "h" );
    string = string.replace( "O", "w" );
    string = string.replace( "A", "p" );
    string = string.replace( "H", "d" );

    System.out.print( string  + "\n");
  }
}
