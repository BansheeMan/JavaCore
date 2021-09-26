import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Task1Test {

    @ParameterizedTest
    @MethodSource("copyArrPastFour")
    void shouldCopyArrPastFour(int[] expected, int[] value){
        Assertions.assertArrayEquals(expected, Task1.copyArrPastFour(value));
    }

    static Stream<Arguments> copyArrPastFour(){
        return Stream.of(
                Arguments.arguments(new int[]{3,2,8,8},new int[]{4,3,2,8,8}),
                Arguments.arguments(new int[]{8,8},new int[]{1,2,3,4,8,8}),
                Arguments.arguments(new int[]{8},new int[]{1,4,3,3,4,8})
        );
    }

    @Test
    void shouldCopyArrPastFourExceptionOne() {
        Assertions.assertThrows(ExceptionFromFour.class, ()-> Task1.copyArrPastFour(new int[]{1,8,3,3,5,8}));
    }
}