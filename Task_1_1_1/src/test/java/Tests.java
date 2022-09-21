import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Tests {
    @Test
    void test_1() {
        int[] a = {1, 2, 3};
        int[] b = {2, 1, 3};
        Heapsort.heapsort(b);
        assertArrayEquals(a,b);
    }

    @Test
    void test_2() {
        int[] a = {-1, 0, 46, 255};
        int[] b = {255, -1, 0, 46};
        Heapsort.heapsort(b);
        assertArrayEquals(a,b);
    }

    @Test
    void test_3() {
        int[] a = {0};
        int[] b = {0};
        Heapsort.heapsort(b);
        assertArrayEquals(a,b);
    }

    @Test
    void test_4() {
        int[] a = {};
        int[] b = {};
        Heapsort.heapsort(b);
        assertArrayEquals(a,b);
    }

    @Test
    void test_5(){
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        Heapsort.heapsort(b);
        assertArrayEquals(a,b);
    }
}