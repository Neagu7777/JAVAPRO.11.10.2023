import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfacesExample {

    public static void main(String[] args) {
        // Реализация функционального интерфейса для поиска самого часто встречаемого
        // символа
        Function<String, Character> mostFrequentCharacterFinder = input -> {
            HashMap<Character, Integer> charCount = new HashMap<>();
            char mostFrequentChar = '\0';
            int maxCount = 0;

            for (char c : input.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                if (charCount.get(c) > maxCount) {
                    mostFrequentChar = c;
                    maxCount = charCount.get(c);
                }
            }

            return mostFrequentChar;
        };

        // Реализация поставщика для генерации случайной строки
        Supplier<String> randomStringSupplier = () -> {
            int length = (int) (Math.random() * 101); // Генерация длины от 0 до 100
            StringBuilder randomString = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int randomCharNumber = (int) (Math.random() * 26); // Генерация числа от 0 до 25
                char randomChar = (char) ('A' + randomCharNumber); // Преобразование числа в букву
                randomString.append(randomChar);
            }

            return randomString.toString();
        };

        // Примеры использования
        String inputString = "Hello, World!";
        char mostFrequentChar = mostFrequentCharacterFinder.apply(inputString);
        System.out.println("Самый часто встречаемый символ: " + mostFrequentChar);

        String randomGeneratedString = randomStringSupplier.get();
        System.out.println("Случайно сгенерированная строка: " + randomGeneratedString);
    }
}
