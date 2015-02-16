/* Assignment 2 - Datastructuren
 * Authors: Cornelis Boon - 10561145, Tim Groot - 10165673
 * Emails: cornelis.boon@student.uva.nl, tim.groot@student.uva.nl
 * Date: 16-02-2015
 * File: Spellchecker.java
 * 
 * Class description: Main class of this assignment. 
 * Provided class for benchmarking the hashtable implementations.
 */



import java.util.*; 
import java.io.*; 

class SpellChecker {
    public static void main(String[] args) {
        int hash_size;
        int count = 0, typo = 0;
        long start = 0, end = 0;
        String wordfile, textfile;
        HashTable table;
        String table_type;

        /* Shared token to store for every word in the hash table. */
        String placeholder = "a";

        if (!(args.length == 4) ) {
            System.out.println("Usage: java SpellChecker <wordfile> <text> <size> ([chained]|[linear])");
            System.exit(0);
        }
        wordfile = args[0];
        textfile = args[1];
        hash_size = Integer.parseInt(args[2]);
        table_type = args[3];
        System.out.printf("Selected table size: %d\n", hash_size);
        
        Compressable function = new Division (hash_size);
        if(table_type.equals("chained")) {
			table = new HashTableChained(hash_size, function);
		} else if( table_type.equals("linear")) {
			table = new HashTableOpen(hash_size, function);
		} else{
			table = null;
			System.out.println("Usage: java SpellChecker <wordfile> <text> <size> ([chained]| [linear])");
			System.exit(0);
		}
        /* Read wordfile, and insert every word into the hash table. */
        try {
            BufferedReader in = new BufferedReader(new FileReader(wordfile));
            start = System.currentTimeMillis();
            String str, copy;
            while ((str = in.readLine()) != null) {
                copy = str.toLowerCase();
                table.put(copy, placeholder);
            }
            end = System.currentTimeMillis();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("java opbouwen Hashtable in " + (end - start) + " ms");

        // Read text file, and lookup every word in the hash table.
        try {
            BufferedReader src = new BufferedReader(new FileReader(textfile));
            start = System.currentTimeMillis();
            String str = src.readLine();
            while (str != null) {
                String copy = str.toLowerCase();

                StringTokenizer st = new StringTokenizer(copy, " ,.:;\"-_(){}[]?!*^&'\n\t");
                while(st.hasMoreTokens()) {
                    String word = st.nextToken();
                    if (!contains_numbers(word) && table.get(word) == null) {
                        //System.out.printf("Not found: [%s]\n", word);
                        typo++;
                    }
                    count++;
                }
                str = src.readLine();
            }
            end = System.currentTimeMillis();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Hash table contains %d words\n", table.size());
        System.out.printf("Hash table load factor %f\n",
               (double) table.size()/table.length());

        System.out.printf("Text contains %d words\n", count);
        System.out.printf("typo's %d\n", typo);

        System.out.println("zoeken woorden in " + (end - start) + " ms");
    }
    
    /* Checks is word contains digits. So it can be ignored for spell
     * checking. */
    static boolean contains_numbers(String str) {
        for (int i = 0 ; i < str.length() ; i++) 
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') 
                return true;

        return false;
    }
}
