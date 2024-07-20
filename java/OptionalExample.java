import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        // 값이 있는 Optional 생성
        Optional<String> hasValue = Optional.of("Hello, World!");

        // 값이 없는 Optional 생성
        Optional<String> noValue = Optional.empty();

        // Optional에서 값을 가져오는 방법 예시

        // 1. isPresent()로 확인 후 get() 사용
        if (hasValue.isPresent()) {
            System.out.println(hasValue.get()); // "Hello, World!" 출력
        }

        // 1.1 ifPresent와 Java 8에서 도입된 메소드 레퍼런스(method reference)를 사용
        hasValue.ifPresent(System.out::println);// "Hello, World!" 출력

        // 2. ifPresent()를 사용하여 값이 있을 때만 람다 함수로 다음 작업 실행
        noValue.ifPresent(value -> System.out.println(value)); // 아무것도 출력되지 않음

        // 위의 1.1과 2는 모두 값이 있을때만 이후 작업이 진행되어 효율적이다.
        // 전자는 간결하다는 장점이 있고, 후자는 람다 표현식으로 좀 더 복잡한 로직을 포함할 수 있다는 장점이 있음

        // 3. orElse()로 값이 없을 때 대체값 제공
        System.out.println(noValue.orElse("Default Value")); // "Default Value" 출력

        // 4. orElseGet()으로 값이 없을 때 대체값을 제공하는 Supplier 함수 사용
        System.out.println(noValue.orElseGet(() -> "Generated Value")); // "Generated Value" 출력

        // 위에서 3,4번이 결과가 같아보이지만 3번은 ofElse안의 내용이 항상 실행되고, 4번은 noValue가 비어있을때만 실행된다.
        /*
        // orElse() 사용 - 값이 있든 없든 항상 기본 User 객체를 생성합니다.
           User user1 = userFromDatabase.orElse(createExpensiveDefaultUser()); // 항상 createExpensiveDefaultUser() 호출
        // orElseGet() 사용 - 값이 없을 경우에만 기본 User 객체를 생성합니다.
           User user2 = userFromDatabase.orElseGet(() -> createExpensiveDefaultUser()); // userFromDatabase가 비어있을 때만 createExpensiveDefaultUser() 호출
         */

        // 5. orElseThrow()로 값이 없을 때 예외 던지기
        try {
            System.out.println(noValue.orElseThrow(() -> new IllegalStateException("Value is missing")));
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage()); // "Value is missing" 예외 메시지 출력
        }
    }
}
