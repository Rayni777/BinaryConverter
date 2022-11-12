import java.util.Scanner;
import java.util.Locale;
public class Main {
    //Перевод положительного числа в бинарный вид
    public static String binint(long l, int k) {
        int x;
        long p = l;
        String bin = "";
        while (p != 0) {
            x = (int) (p % 2);
            bin = x + bin;
            p /= 2;
        }
        //Добавление нулей
        if (k == 8) {
            for (int i = k - bin.length(); i != 0; i--) {
                bin = "0" + bin;
            }
        } else if (k == 16) {
            for (int i = k - bin.length(); i != 0; i--) {
                bin = "0" + bin;
            }
        } else if (k == 32) {
            for (int i = k - bin.length(); i != 0; i--) {
                bin = "0" + bin;
            }
        } else if (k == 64) {
            for (int i = k - bin.length(); i != 0; i--) {
                bin = "0" + bin;
            }
        }
        //Добавление пробелов
        String binend = "";
        for(int i = 0; i < bin.length(); i++)
        {
            char c = bin.charAt(i);
            if ((i == 8) || (i == 16) || (i == 24) || (i == 32) || (i == 40) || (i == 48) || (i == 56)) binend += " ";
            binend += c;
        }
        return binend;
    }

    //Перевод отрицательного числа в бинарный вид
    public static String binnegint(long l, int k) {
        int x, g = 0;
        long n;

        if (l >= -128) g = 8;
        else if (l >= -32768) g = 16;
        else if (l >= -2147483648) g = 32;
        else if (l >= -9223372036854775808L) g = 64;
        n = (long) (Math.pow(2,g) - Math.abs(l));
        String binneg = "";

        while (n != 0) {
            x = (int) (n % 2);
            binneg = x + binneg;
            n /= 2;
        }
        //Добовление единиц
        if (k == 8) {
            for (int i = k - binneg.length(); i != 0; i--) {
                binneg = "1" + binneg;
            }
        } else if (k == 16) {
            for (int i = k - binneg.length(); i != 0; i--) {
                binneg = "1" + binneg;
            }
        } else if (k == 32) {
            for (int i = k - binneg.length(); i != 0; i--) {
                binneg = "1" + binneg;
            }
        } else if (k == 64) {
            for (int i = k - binneg.length(); i != 0; i--) {
                binneg = "1" + binneg;
            }
        }
        //Добавление пробелов
        String binnegend = "";
        for(int i = 0; i < binneg.length(); i++)
        {
            char c = binneg.charAt(i);
            if ((i == 8) || (i == 16) || (i == 24) || (i == 32) || (i == 40) || (i == 48) || (i == 56)) binnegend += " ";
            binnegend += c;
        }
        return binnegend;
    }

    //Перевод вещественного числа в бинарный вид, тип Double
    public static String doubin(double d) {
        int x;
        int m1, m3, p, lenmantis1;
        double m2, dou;
        dou = Math.abs(d);
        m1 = (int) dou; //Целая часть вещественного числа
        m2 = dou - m1;  //Дробная часть вещественного числа
        String mantis = ""; //Мантисса и порядок
        String doubin = ""; //Итоговое число в бинарном виде
        //Нахождение мантиссы
        while (m1 != 0) {
            x = (int) (m1 % 2);
            mantis = x + mantis;
            m1 /= 2;
        }
        lenmantis1 = mantis.length();
        for (int i = 0; i < 53 - lenmantis1; i++) {
            m2 *= 2;
            m3 = (int) m2;
            mantis = mantis + m3;
            m2 -= m3;
        }
        mantis = " " + mantis.substring(1);

        p = lenmantis1 + 1022;
        while (p != 0) {
            x = (int) (p % 2);
            mantis = x + mantis;
            p /= 2;
        }
        doubin = " " + mantis;

        if (d < 0) {
            doubin = "1 " + mantis;
        } else {
            doubin = "0 " + mantis;
        }
        return doubin;
    }

    /*private static boolean readFloatNumber(String input, Locale locale) {
        boolean inputChange = false;
        Scanner sc_ca = new Scanner(input).useLocale(locale);
        try {
            input_d = sc_ca.nextDouble();
            inputChange = true;
        } catch (Exception ignored) {
        }
        return inputChange;
    }*/
    //Перевод вещественного числа в бинарный вид, тип Float
    public static String floatbin(float d) {
        int x;
        int m1, m3, p, lenmantis1;
        double m2, dou;
        dou = Math.abs(d);
        m1 = (int) dou;
        m2 = dou - m1;
        String mantis = "";
        String floatbin = "";

        while (m1 != 0) {
            x = (int) (m1 % 2);
            mantis = x + mantis;
            m1 /= 2;
        }
        lenmantis1 = mantis.length();
        for (int i = 0; i < 24 - lenmantis1; i++) {
            m2 *= 2;
            m3 = (int) m2;
            mantis = mantis + m3;
            m2 -= m3;
        }
        mantis = " " + mantis.substring(1);

        p = lenmantis1 + 126;
        while (p != 0) {
            x = (int) (p % 2);
            mantis = x + mantis;
            p /= 2;
        }
        floatbin = " " + mantis;

        if (d < 0.0) {
            floatbin = "1 " + mantis;
        } else {
            floatbin = "0 " + mantis;
        }
        return floatbin;
    }

    private static void scannerInit(Locale locale) {
        Scanner scan = new Scanner(System.in).useLocale(locale);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        scannerInit(Locale.FRANCE);

        int k;
        long l = 0;
        double d = 0;
        String typeint, typevesh, e = "n";
        //Ввод числа и вывод числа
        System.out.println("Вас приветствует Бинарный калькулятор by Rayni");
        while (e.equals("n")) {
            System.out.println("Введите число, которое вы хотите представить в бинарном виде" + "\n"
                    + "Вещественные числа вводятся через запятую ','" + "\n"
                    + "Например: -125,1");
            if (sc.hasNextLong()) {
                l = sc.nextLong();
                System.out.println("Введите в каком типе данных(нужно ввести число) вы хотите получить число в бинарном коде" + "\n"
                        + "1 Byte/2 Short/3 Int/4 Long");
                typeint = sc.next();
                if (typeint.equals("6")) {
                    if (l > 127 || l < -128) {
                        System.out.println("Число " + l + " нельзя представить в типе данных Byte без сокращения"+ "\n"
                                + "Если вы хотите ввести новое число, введите 'n'" + "\n"
                                + "Если вы хотите выйти из программы введите любой символ");
                        e = sc.next();
                        continue;
                    }
                    if (l < 0) {
                        System.out.println("Число " + l + " в бинарном коде, в типе данных Byte будет представленно так " + "\n" + "\n"
                                + binnegint(l, 8) + "\n");
                    } else {
                        System.out.println("Число " + l + " в бинарном коде, в типе данных Byte будет представленно так " + "\n" + "\n"
                                + binint(l, 8) + "\n");
                    }
                } else if (typeint.equals("5")) {
                    if (l > 32767 || l < -32768) {
                        System.out.println("Число " + l + " нельзя представить в типе данных Short без сокращения"+ "\n"
                                + "Если вы хотите ввести новое число, введите 'n'" + "\n"
                                + "Если вы хотите выйти из программы введите любой символ");
                        e = sc.next();
                        continue;
                    }
                    if (l < 0) {
                        System.out.println("Число " + l + " в бинарном коде, в типе данных Short будет представленно так " + "\n" + "\n"
                                + binnegint(l, 16) + "\n");
                    } else {
                        System.out.println("Число " + l + " в бинарном коде, в типе данных Short будет представленно так " + "\n" + "\n"
                                + binint(l, 16) + "\n");
                    }
                } else if (typeint.equals("4")) {
                    if (l > 2147483647 || l < -2147483648) {
                        System.out.println("Число " + l + " нельзя представить в типе данных Int без сокращения"+ "\n"
                                + "Если вы хотите ввести новое число, введите 'n'" + "\n"
                                + "Если вы хотите выйти из программы введите любой символ");
                        e = sc.next();
                        continue;
                    }
                    if (l < 0) {
                        System.out.println("Число " + l + " в бинарном коде, в типе данных Int будет представленно так " + "\n" + "\n"
                                + binnegint(l, 32) + "\n");
                    } else {
                        System.out.println("Число " + l + " в бинарном коде, в типе данных Int будет представленно так " + "\n" + "\n"
                                + binint(l, 32) + "\n");
                    }
                } else if (typeint.equals("3")) {
                    if (l > 9223372036854775807L || l < -9223372036854775808L) {
                        System.out.println("Число " + l + " нельзя представить в типе данных Long без сокращения"+ "\n"
                                + "Если вы хотите ввести новое число, введите 'n'" + "\n"
                                + "Если вы хотите выйти из программы введите любой символ");
                        e = sc.next();
                        continue;
                    }
                    if (l < 0) {
                        System.out.println("Число " + l + " в бинарном коде, в типе данных Long будет представленно так " + "\n" + "\n"
                                + binnegint(l, 64) + "\n");
                    } else {
                        System.out.println("Число " + l + " в бинарном коде, в типе данных Long будет представленно так " + "\n" + "\n"
                                + binint(l, 64) + "\n");
                    }
                }
                else {
                    System.out.println("Вы неправильно ввели тип данных");
                }
            } else if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                System.out.println("Введите в каком типе данных вы хотите получить число в бинарном коде" + "\n"
                        + "1 Float/2 Double");
                typevesh = sc.next();
                if (typevesh.equals("1")) {
                    System.out.println("Число " + d + " в бинарном коде, в типе данных Float будет представленно так " + "\n" + "\n"
                            + floatbin((float) d) + "\n");
                } else if (typevesh.equals("2")) {
                    System.out.println("Число " + d + " в бинарном коде, в типе данных Float будет представленно так " + "\n" + "\n"
                            + doubin(d) + "\n");
                }
            }
            System.out.println("Если вы хотите ввести новое число, введите 'n'" + "\n"
                    + "Если вы хотите выйти из программы введите любой символ");
            e = sc.next();
        }
        System.exit(0);
    }
}