import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class.
    @Test
    public void  testIsPalindrome(){
        assertEquals(true, palindrome.isPalindrome("oooo"));
        assertEquals(false, palindrome.isPalindrome("ABa"));
        assertEquals(true, palindrome.isPalindrome("ABA"));

        CharacterComparator cc = new OffByOne();
        assertEquals(true, palindrome.isPalindrome("flake",cc));
        assertEquals(false, palindrome.isPalindrome("abA",cc));

    }
}
