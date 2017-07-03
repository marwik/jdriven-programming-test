package nl.marwik.jdriventest;

public class BetterProgrammerTask1 {

    /** Return the word count in a given String.
     *
     * @param s The String to count the words in, can only contain spaces and alphanumeric characters.
     * @return the number of words in the string
     */
    public static int countWords(String s) {
        /*
          Please implement this method to
          return the word count in a given String.
          Assume that the parameter String can only contain spaces and alphanumeric characters.
         */
        s = s.replaceAll("[a-zA-Z0-9]+", ".");
        s = s.replaceAll("[\\s]+", "");
        return s.length();
    }

    /** test */
    public static void main(String[] args) {
        System.out.println( countWords("   This0 is an  example string  2  ") );
    }

}
