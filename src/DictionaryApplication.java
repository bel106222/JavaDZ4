import java.util.*;

public class DictionaryApplication {
    private static Map<String, WordEntry> dictionary = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    static class WordEntry {
        private String translate;    // перевод слова
        private int counter;         // счётчик обращений

        public WordEntry() {
            this.translate = null;
            this.counter = 0;
        }
        public WordEntry(String translate) {
            this.translate = translate;
            this.counter = 0;
        }
        public String getTranslate() {
            return translate;
        }
        public void setTranslate(String translate) {
            this.translate = translate;
        }
        public int getCounter() {
            return counter;
        }
        public void incrementCounter() {
            this.counter++;
        }
    }

    public static void start(){
        factory();
        int choise = -1;
        while (choise != 0){
            choise = menu();
            if (choise < 0 || choise > 6) {
                System.out.println("Некорректный ввод!");
            }
            switch (choise) {
                case 1:
                    showWordAndTranslation();
                    break;
                case 2:
                    addWordAndTranslation();
                    break;
                case 3:
                    //replaceTranslation();
                    break;
                case 4:
                    //removeWord();
                    break;
                case 5:
                    //showTop();
                    break;
                case 6:
                    showAll();
                    break;
            }
        }
        System.out.println("Выход...");
    }

    private static void addWordAndTranslation() {
        String word = getStringInput("Введите новое слово:>").toLowerCase();
        // Проверяем, не существует ли уже такое слово
        if (dictionary.containsKey(word)) {
            System.out.println("Слово уже существует в словаре.");
            return;
        }
        String translate = getStringInput("Теперь введите его перевод:>").toLowerCase();
        dictionary.put(word, new WordEntry(translate));
    }
    private static void showWordAndTranslation() {
        String word = getStringInput("Введите слово:>").toLowerCase();
        WordEntry entry = dictionary.get(word);
        if (entry != null) {
            entry.incrementCounter(); // Увеличиваем счётчик популярности при просмотре слова
            System.out.print("Слово: " + word);
            System.out.print(", перевод: " + entry.translate);
            System.out.print(", популярность (количество обращений): " + entry.getCounter() + "\n");
        } else {
            System.out.println("Слово не найдено в словаре.");
        }
    }
    private static void addWord(String word, String translate) {
        dictionary.put(word.toLowerCase(), new WordEntry(translate));
    }
    private static void showAll() {
        System.out.println("\n=== ВСЕ СЛОВА В СЛОВАРЕ ===");
        if (dictionary.isEmpty()) {
            System.out.println("Словарь пуст.");
            return;
        }
        dictionary.forEach((word, entry) -> {
            System.out.print("Слово: " + word);
            System.out.print(", перевод: " + entry.translate);
            System.out.print(", популярность: " + entry.getCounter());
            System.out.println();
        });
    }
    private static void factory() {
        addWord("car", "машина");
        addWord("house", "дом");
        addWord("book", "книга");
        addWord("dog", "собака");
        addWord("cat", "кот");
        addWord("big", "большой");
        addWord("small", "маленький");
    }
    private static int menu() {
        System.out.println("\t\t===Англо-русский словарь===");
        System.out.println("Меню:");
        System.out.println("1. Просмотр слова и его перевода");
        System.out.println("2. Добавление слова и его перевода");
        System.out.println("3. Замена перевода");
        System.out.println("4. Удаление слова и перевода");
        System.out.println("5. ТОП популярных слов");
        System.out.println("6. Вывод всего словаря");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор:>");
        int inputInt = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        return inputInt;
    }
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
