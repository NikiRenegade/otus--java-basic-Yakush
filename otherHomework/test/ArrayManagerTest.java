import hw22.ArrayManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ArrayManagerTest {
    @Test
    public void elementsAfterLastOneNormal() {
        Assertions.assertArrayEquals(new int[]{2,2},
                ArrayManager.elementsAfterLastOne(new int[] {1,2,1,2,2}));
        Assertions.assertArrayEquals(new int[]{4,2,2},
                ArrayManager.elementsAfterLastOne(new int[] {1,2,1,2,2,1,4,2,2}));
        Assertions.assertArrayEquals(new int[]{3,5},
                ArrayManager.elementsAfterLastOne(new int[] {6,3,2,2,2,6,1,3,5}));
    }
    @Test
    public void elementsAfterLastOneException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ArrayManager.elementsAfterLastOne(new int[] {2,2,2,2,2});
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ArrayManager.elementsAfterLastOne(new int[] {11,22,33,44,55});
        });
    }
    @Test
    public void checkArrayForOnlyOneAndTwoIsTrue() {
        Assertions.assertTrue(ArrayManager.checkArrayForOnlyOneAndTwo(new int[] {1,2,1,2,2}));
        Assertions.assertTrue(ArrayManager.checkArrayForOnlyOneAndTwo(new int[] {1,2,1,2,2,1,1,2,2}));
    }
    @Test
    public void checkArrayForOnlyOneAndTwoIsFalse() {
        Assertions.assertFalse(ArrayManager.checkArrayForOnlyOneAndTwo(new int[] {1,2,1,2,6}));
        Assertions.assertFalse(ArrayManager.checkArrayForOnlyOneAndTwo(new int[] {1,2,1,2,2,5,1,2,2}));
    }
}
