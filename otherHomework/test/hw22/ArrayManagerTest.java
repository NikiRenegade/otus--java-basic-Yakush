package hw22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayManagerTest {
    @ParameterizedTest
    @MethodSource("provideTestElementsAfterLastOneNormal")
    public void elementsAfterLastOneNormal(int[] input, int[] expected) {
        int[] actual = ArrayManager.elementsAfterLastOne(input);
        Assertions.assertArrayEquals(expected, actual);
    }
    private static Stream<Arguments> provideTestElementsAfterLastOneNormal() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 2, 2}, new int[]{2, 2}),
                Arguments.of(new int[]{1, 2, 1, 2, 2, 1, 4, 2, 2}, new int[]{4, 2, 2}),
                Arguments.of(new int[]{6, 3, 2, 2, 2, 6, 1, 3, 5}, new int[]{3, 5})
        );
    }


    @ParameterizedTest
    @MethodSource("provideTestElementsAfterLastOneException")
    void elementsAfterLastOneException(int[] input) {
        Assertions.assertThrows(RuntimeException.class, () -> ArrayManager.elementsAfterLastOne(input));
    }

    private static Stream<Arguments> provideTestElementsAfterLastOneException() {
        return Stream.of(
                Arguments.of((Object) new int[]{2, 2, 2, 2, 2}),
                Arguments.of((Object) new int[]{11, 22, 33, 44, 55})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCheckArrayForOnlyOneAndTwoIsTrue")
    public void checkArrayForOnlyOneAndTwoIsTrue(int[] input) {
        Assertions.assertTrue(ArrayManager.checkArrayForOnlyOneAndTwo(input));
    }
    private static Stream<Arguments> provideTestCheckArrayForOnlyOneAndTwoIsTrue() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 1, 2, 2}),
                Arguments.of((Object) new int[]{1, 2, 1, 2, 2, 1, 1, 2, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCheckArrayForOnlyOneAndTwoIsFalse")
    public void checkArrayForOnlyOneAndTwoIsFalse(int[] input) {
        Assertions.assertFalse(ArrayManager.checkArrayForOnlyOneAndTwo(input));
    }

    private static Stream<Arguments> provideTestCheckArrayForOnlyOneAndTwoIsFalse() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 1, 2, 6}),
                Arguments.of((Object) new int[]{1, 2, 1, 2, 2, 5, 1, 2, 2})
        );
    }
}
