# ks-2022-1
Первое задание в 2022 году по Kotlin

1. Взять свою фамилию латинскими буквами, сконвертировать каждый символ в фамилии в число (код по таблице ASCII, используя методы типа [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/)). Посчитать сумму полученных чисел.

2. Взять число, полученное в пункте 1 [по модулю](https://ru.wikipedia.org/wiki/%D0%94%D0%B5%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5_%D1%81_%D0%BE%D1%81%D1%82%D0%B0%D1%82%D0%BA%D0%BE%D0%BC) 10. Полученное число обозначим за `a`. Взять данные из файла `data/numbers.txt` c номерами строк от `a*100` до `(a + 1)*100` и сконвертировать их в числа. Посчитать среднее значение, дисперсию и медиану для полученных чисел.

3. Для полного набора данных из `data/numbers.txt` составить набор пар (самое большое числое, самое маленькое число), (второе по величине, - второе по малости) и так далее. Посчитать для каждой пары сумму и вывести полученные значения в результат ячейки или новый файл. Посчитать среднее, дисперсию и медиану для полученного списка.

4. (со *, творческая). Экспериментально исследовать точность сравнения чисел с плавающей точкой (`Double`) в разных диапазонах этих чисел.