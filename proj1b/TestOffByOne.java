import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
    @Test
    public void testOffByOne() {
        boolean test1 = offByOne.equalChars('a','b');
        assertEquals(true,test1);
        boolean test2 = offByOne.equalChars('c','b');
        assertEquals(true,test2);
        boolean test3 = offByOne.equalChars('a','B');
        assertEquals(false,test3);
    }

    @Test
    public void testOffByN() {
        CharacterComparator cc = new OffByN(5);
        boolean test1 = cc.equalChars('a','f');
        assertEquals(true,test1);
        boolean test2 = cc.equalChars('f','h');
        assertEquals(false,test2);
    }
}
