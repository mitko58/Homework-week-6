import java.util.Random;
import java.util.Scanner;

public class HomeworkWeek6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainMenu();
        commands(scanner);
    }

    private static void commands(Scanner scanner) {
        String command = scanner.nextLine();
        if (command.equals("1")){
            workWithNumbers(scanner);
        }else if (command.equals("2")){
            workWithStrings(scanner);
        }else if (command.equals("3")){
            System.out.println("Приключихте работа с програмата");
        }else {
            System.out.println("Грешка! Изберете правилна опция от 1 до 3!");
            mainMenu();
            commands(scanner);
        }
    }

    private static void workWithStrings(Scanner scanner) {
        System.out.println("Колко на брой думи ще въвеждате?");
        int numberOfWords = Integer.parseInt(scanner.nextLine());
        String[] arrayOfWords = new String[numberOfWords];
        System.out.println("Въведете думите");
        for (int i = 1; i <= numberOfWords ; i++) {
            String words = scanner.nextLine();
            if (words.length() <= 20){
                arrayOfWords[i - 1] = words;
            }else{
                System.out.println("Броят на символите е повече от 20! Въведете друга дума!");
                i--;
            }
        }
        optionsForString();
        boolean isSystemOn = true;
        while (isSystemOn){
            String numberOfOption = scanner.nextLine();
            if (numberOfOption.equals("1")){
                reverseSymbolsOfWords(arrayOfWords);
                optionsForString();
            }else if (numberOfOption.equals("2")){
                numberOfDuplicatedLetterForEveryWord(arrayOfWords);
                optionsForString();
            }else if (numberOfOption.equals("3")){
                numberOfSymbolsForEveryWord(arrayOfWords);
                optionsForString();
            }else if (numberOfOption.equals("4")){
                numberOfRepeatedWord(arrayOfWords);
                optionsForString();
            }else if (numberOfOption.equals("5")){
                mainMenu();
                commands(scanner);
                isSystemOn = false;
            }else{
                System.out.println("Грешка! Изберете правилна опция от 1 до 5!");
                optionsForString();
            }
        }
    }

    private static void numberOfRepeatedWord(String[] arrayOfWords) {
        for (int i = 0; i < arrayOfWords.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arrayOfWords.length; j++) {
                if (arrayOfWords[i].equalsIgnoreCase(arrayOfWords[j])) {
                            count++;
                            arrayOfWords[j] = "0";
                }
            }
            if (count > 1 && !arrayOfWords[i].equals("0")) {
                System.out.printf("String-a %s се повтаря %d пъти\n", arrayOfWords[i], count);
            }
        }
    }

    private static void numberOfSymbolsForEveryWord(String[] arrayOfWords) {
        for (String arrayOfWord : arrayOfWords) {
            System.out.printf("String-a %s има на брой %s символа\n", arrayOfWord, arrayOfWord.length());
        }
    }

    private static void numberOfDuplicatedLetterForEveryWord(String[] arrayOfWords) {
        char duplicateLetter;
        int counter = 1;
        for (String arrayOfWord : arrayOfWords) {
            for (int i = 0; i < arrayOfWord.length(); i++) {
                for (int j = i + 1; j < arrayOfWord.length(); j++) {
                    if (arrayOfWord.charAt(i) == arrayOfWord.charAt(j)) {
                        counter++;
                        duplicateLetter = arrayOfWord.charAt(i);
                        System.out.printf("В думата %s има %d повтраящи се символа, и те са при буква: %c\n", arrayOfWord, counter, duplicateLetter);
                    }
                }
                counter = 1;
            }
        }
    }

    private static void reverseSymbolsOfWords(String[] arrayOfWords) {
        System.out.print("Думите с обърнати букви са: ");
        String[] reverse = new String[arrayOfWords.length];
        for (int i = 0; i < arrayOfWords.length; i++) {
            reverse[i] = new StringBuffer(arrayOfWords[i]).reverse().toString();
        }
        for (String elements:reverse) {
            System.out.print(elements + " ");
        }
    }

    private static void optionsForString() {
        System.out.println();
        System.out.println("Изберете опция:");
        System.out.println("1. Обърнете буквите на думите от масива наобратно и ги визуализирайте в конзолата");
        System.out.println("2. Изведете броя на повтарящите се символи за всяка една от думите в масива");
        System.out.println("3. Изведете броя на символите за всяка една от думите в масива");
        System.out.println("4. Изведете броя на повтарящите се думи от масива");
        System.out.println("5. Връщане назад към основното меню");
    }

    private static void workWithNumbers(Scanner scanner) {
        System.out.println("Колко на брой числа ще въвеждате?");
        int numbers = Integer.parseInt(scanner.nextLine());
        int[] arrayOfNumbers = new int[numbers];
        System.out.println("Числата трябва да са между 0 и 10 000");
        int countNumber = 1;
        for (int i = 0; i < numbers; ) {
            arrayOfNumbers[i] = Integer.parseInt(scanner.nextLine());
            if (arrayOfNumbers[i] > 0 && arrayOfNumbers[i] < 10000) {
                i++;
                countNumber++;
            } else {
                System.out.println("Числото не е между 0 и 10000");
            }
        }
        options();
        boolean isSystemOn = true;
        while (isSystemOn) {
            String numberOfOption = scanner.nextLine();
            if (numberOfOption.equals("1")) {
                printPrimeNumbers(arrayOfNumbers);
                options();
            }else if (numberOfOption.equals("2")) {
                mostFrequentlyNumber(arrayOfNumbers);
                options();
            }else if (numberOfOption.equals("3")) {
                maxSequenceOfIncreasingElement(arrayOfNumbers);
                options();
            }else if (numberOfOption.equals("4")) {
                maxSequenceOfDecreasingElement(arrayOfNumbers);
                options();
            }else if (numberOfOption.equals("5")) {
                maxSequenceOfEqualElement(arrayOfNumbers);
                options();
            }else if (numberOfOption.equals("6")) {
                findSequenceSumOfRandomNumber(arrayOfNumbers);
                options();
            }else if (numberOfOption.equals("7")){
                mainMenu();
                commands(scanner);
                isSystemOn = false;
            }else{
                System.out.println("Грешка! Изберете правилна опция от 1 до 7!");
                options();
            }
        }
    }

    private static void findSequenceSumOfRandomNumber(int[] arrayOfNumbers) {
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        System.out.printf("Случайното число е: %d", randomNumber);
        System.out.println();
        int sum = 0;
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            sum += arrayOfNumbers[i];
            if (sum == randomNumber) {
                System.out.print("Последователността от числа, които имат сума равна на случайното са: " + arrayOfNumbers[i] + " ");
                break;
            }
        }
        if (sum != randomNumber) {
            System.out.print("Не е открита последователност");
        }
    }

    private static void maxSequenceOfEqualElement(int[] arrayOfNumbers) {
        System.out.print("Максималната редица от еднакви елементи е: ");
        int firstCounter = 0;
        int secondCounter = 0;
        int number = arrayOfNumbers[0];
        for (int i = 0; i < arrayOfNumbers.length - 1; i++) {
            if (arrayOfNumbers[i] == arrayOfNumbers[i + 1]) {
                firstCounter++;
                if (firstCounter > secondCounter) {
                    secondCounter = firstCounter;
                    number = arrayOfNumbers[i];
                }
            }else{
                firstCounter = 0;
            }
        }
        for (int i = 0; i <= secondCounter; i++) {
            System.out.print(number + " ");
        }
    }

    private static void maxSequenceOfDecreasingElement(int[] arrayOfNumbers) {
        int maxLength = 0;
        int currentIndex = 0;
        int maxEndIndex = 0;
        System.out.print("Максималната редица от намаляващи елементи е: ");
        for (int i = 1; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i - 1] > arrayOfNumbers[i]) {
                currentIndex++;
            } else {
                if (currentIndex > maxLength) {
                    maxLength = currentIndex;
                    maxEndIndex = i - 1;
                }
                currentIndex = 0;
            }
            if (i == arrayOfNumbers.length - 1) {
                if (currentIndex > maxLength) {
                    maxLength = currentIndex;
                    maxEndIndex = i;
                }
            }
        }
        for (int i = maxEndIndex - maxLength; i <= maxEndIndex; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
    }

    private static void maxSequenceOfIncreasingElement(int[] arrayOfNumbers) {
        int currentIndex = 0;
        int currentLength = 1;
        int maxEndIndex = 0;
        int maxLength = 1;
        System.out.print("Максималната редица от нарастващи елементи е: ");
        for (int i = 1; i < arrayOfNumbers.length; i++) {
            if ((arrayOfNumbers[i-1]) < (arrayOfNumbers[i])) {
                currentIndex = i;
                currentLength++;
            }else{
                currentIndex = i;
                currentLength = 1;
            }if (currentLength > maxLength) {
                maxEndIndex = i;
                maxLength = currentLength;
            }
        }
        for (int i = maxEndIndex - maxLength + 1; i <= maxEndIndex; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
    }

    private static void mostFrequentlyNumber(int[] arrayOfNumbers) {
        int tempCount = 0;
        int temp = 0;
        int count = 1;
        int mostFrequent = arrayOfNumbers[0];
        for (int i = 0; i < arrayOfNumbers.length - 1; i++) {
            temp = arrayOfNumbers[i];
            tempCount = 0;
            for (int j = 1; j < arrayOfNumbers.length; j++) {
                if (temp == arrayOfNumbers[j]) {
                    tempCount++;
                }
            }
            if (tempCount > count) {
                mostFrequent = temp;
                count = tempCount;
            }
        }
        System.out.print("Най-често срещан елемент в масива е: " + mostFrequent);
    }

    private static void printPrimeNumbers(int[] arrayOfNumbers) {
        System.out.print("Простите числа са(Може и да няма такива): ");
        for (int arrayOfNumber : arrayOfNumbers) {
            boolean isPrime = true;
            for (int j = 2; j < arrayOfNumber; j++) {
                if (arrayOfNumber % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(arrayOfNumber + " ");
            }
        }
    }

    private static void options() {
        System.out.println();
        System.out.println("Изберете опция:");
        System.out.println("1. Извеждане само на простите числа от масива");
        System.out.println("2. Извеждане на най-често срещан елемент в масива");
        System.out.println("3. Извеждане на максимална редица от нарастващи елементи в масива");
        System.out.println("4. Извеждане на максимална редица от намаляващи елементи в масива");
        System.out.println("5. Извеждане на максимална редица от еднакви елементи в масива");
        System.out.println("6. Извеждане на последователност от числа от масива, които имат сума\n" +
                "равна на число, генерирано на случаен принцип");
        System.out.println("7. Връщане назад към основното меню");
    }

    private static void mainMenu() {
        System.out.println("ГЛАВНО МЕНЮ - Изберете опция");
        System.out.println("1. Работа с числа");
        System.out.println("2. Работа с думи");
        System.out.println("3. Изход от програмата");
    }
}