import org.junit.Test;
import static org.junit.Assert.*;

public class TestBackPack {
	private BackPack backpack;
	@Test
	public void testSolution() {
		int result[][] = new int[][]{
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,4,4,4,4,4,4,4,4},
		    {0,0,0,4,5,5,5,9,9,9,9},
			{0,0,0,4,5,6,6,9,10,11,11}
		};
		int m = 10;
        int n = 3;

        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        assertEquals(result, backpack.BackPack_Solution(m, n, w, p));
	}
}