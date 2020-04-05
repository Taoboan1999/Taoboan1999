import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class TestBubbleSort {
    
    @Test
    public void test1() {

        int a[] = new int[]{1,8,2,2,5};
        int a1[] = new int[]{1,2,2,5,8};
        assertEquals(Arrays.toString(a1), Arrays.toString(BubbleSort.BubbleSort(a)));

    }

}