import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Task2Test {

    @ParameterizedTest
    @MethodSource("arrWithOneAndFour")
    void shouldArrWithOneAndFour(boolean expected, int[] value){
        Assertions.assertEquals(expected, Task2.arrWithOneAndFour(value));
    }

    static Stream<Arguments> arrWithOneAndFour(){
        return Stream.of(
                Arguments.arguments(true,new int[]{1,4,4,1,1}),
                Arguments.arguments(false,new int[]{1,1,1,1,1}),
                Arguments.arguments(false,new int[]{4,4,4,4,4,4}),
                Arguments.arguments(false,new int[]{1,4,5,1,1})
        );
    }
}
