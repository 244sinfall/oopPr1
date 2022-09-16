import java.util.Arrays;
import java.util.Scanner;

/*
    Работу выполнил студент ЗКИ21-16Б
    Филин Дмитрий Алексеевич
 */

/**
 * Входные данные: текст и строка. Результат работы алгоритма: массив слов входного текста, которые в качестве
 * подстроки содержат входную строку. Например, если пользователь введет "рек" для строки "Ехал Грека через реку",
 * результат будет "Грека, реку".
 */
public class Main {
    private static String resultText = "Поиск не выполнялся.";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringSearcher s = new StringSearcher();
        System.out.println("Поиск по строке");
        while(true) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Внести данные.");
            System.out.println("2. Выполнить поиск.");
            System.out.println("3. Вывести результат.");
            System.out.println("0. Выйти");
            String choice = input.nextLine();
            int selectedMenuItem;
            try {
                 selectedMenuItem = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректный пункт меню!");
                continue;
            }
            switch (selectedMenuItem) {
                case 0:
                    return;
                case 1:
                    String inputStr;
                    String matcher;
                    System.out.println("Введите исходную строку, по которой нужно произвести поиск:");
                    inputStr = input.nextLine();
                    System.out.println("Введите искомую последовательность букв, по которой будут искаться слова:");
                    matcher = input.nextLine();
                    s.setData(matcher, inputStr);
                    System.out.println("Новые значения: ");
                    System.out.println("Строка для поиска: " + inputStr);
                    System.out.println("Последовательность для поиска: " + matcher);
                    resultText = "Поиск не выполнялся.";
                    break;
                case 2:
                    try {
                        String[] result = s.findMatches();
                        resultText = result.length != 0 ? Arrays.toString(result) : "Вхождений не найдено.";
                    } catch (Exception e) {
                        System.out.println("Ошибка при поиске вхождений: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Результат: " + resultText);
                    break;
                default:
                    System.out.println("Вы ввели некорректный пункт меню!");
                    break;
            }
        }
    }
}