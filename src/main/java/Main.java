import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //   createObservableUsingJust();
        //  createObservableUsingIterable();
        createObservableUsingCreate();

    }

    private static void createObservableUsingJust() {
        Observable.just(1, 2, 3, 4, 5, 6).subscribe(System.out::println);

    }

    private static void createObservableUsingIterable() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Observable.fromIterable(integerList)
                .subscribe(System.out::println);
    }

    private static void createObservableUsingCreate() {
        Observable<Integer> createObservables = Observable.
                create(emitter -> {
                            emitter.onNext(1);
                            emitter.onNext(2);
                            emitter.onNext(3);
                            emitter.onNext(4);
                            emitter.onNext(5);
                            emitter.onNext(6);
                            emitter.onComplete();
                        }
                );
        createObservables.subscribe(System.out::println,
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed"));
    }


}
