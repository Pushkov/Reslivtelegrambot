package nicomed.resliv.telegrambot.bootstrap;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestingClass {

    public static void main(String[] args) {


        Supplier<Stream<Integer>> streamSupplier =
                () -> Stream.of(1, 3, 5, 7, 9)
                        .filter(x -> x > 4);

        streamSupplier.get().forEach(x -> System.out.println(x));   // ok
        streamSupplier.get().forEach(x -> System.out.println(x));


    }
}
