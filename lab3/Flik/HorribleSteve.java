import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }

    @Test
    public void test(){
        assertTrue(Flik.isSameNumber(0,0));
        assertTrue(Flik.isSameNumber(1,500));
    }
}
