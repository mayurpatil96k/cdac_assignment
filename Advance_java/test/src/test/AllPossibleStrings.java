package test;
public class AllPossibleStrings {
    public static void main(String[] args) {
        char[] characters = {'a', 'e', 'i', 'o', 'u'};
        generateStrings(characters, 0);
        generateStrings(characters, 1);
        generateStrings(characters, 2);
        generateStrings(characters, 3);
        generateStrings(characters, 4);
    }

    private static void generateStrings(char[] characters, int index) {
        if (index == characters.length - 1) {
            // If we have reached the last character, print the current string
            System.out.println(new String(characters));
        } else {
            // Iterate through the remaining characters and swap each with the current index
            for (int i = index; i < characters.length; i++) {
                swap(characters, index, i);
                // Recursively generate strings for the remaining characters
                generateStrings(characters, index + 1);
                // Backtrack by swapping back to the original arrangement
                swap(characters, index, i);
            }
        }
    }

    private static void swap(char[] characters, int i, int j) {
        char temp = characters[i];
        characters[i] = characters[j];
        characters[j] = temp;
    }
}
