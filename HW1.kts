// -*- coding: utf-8 -*-

// -- Sheet --

// ## Домашняя работа 1
// 
// 1. Взять свою фамилию латинскими буквами, сконвертировать каждый символ в фамилии в число (код по таблице ASCII, используя методы типа Char). Посчитать сумму полученных чисел.


val surname: String = "Kleimenov"

fun surnameSum(sn: String): Int {
    val symCodes = sn.map { sym -> sym.code }

    return symCodes.sum()
}

surnameSum(surname)

val path: String = "ks-2022-1/data/numbers.txt"

// 2. Взять число, полученное в пункте 1 по модулю 10. Полученное число обозначим за a. Взять данные из файла data/numbers.txt c номерами строк от a*100 до (a + 1)*100 и сконвертировать их в числа. Посчитать среднее значение, дисперсию и медиану для полученных чисел.


import java.io.File

fun readFileDouble(fileName: String): List<Double> = File(fileName).readLines().map { it.toDouble() }

fun avg(dataList: List<Double>): Double = dataList.sum() / dataList.size

fun dispersion(dataList: List<Double>): Double {
    val a = avg(dataList)
    return dataList.map { (it - a).pow(2) }.sum().pow(0.5) / dataList.size
}

fun median(dataList: List<Double>): Double {
    val len = dataList.size
    if (dataList.size % 2 == 0)
        return (dataList.get(len/2) + dataList.get(len/2 + 1)) / 2
    return dataList.get(len/2)
}

fun result(dataList: List<Double>){
    println("""
        Average = ${avg(dataList)}
        Dispersion = ${dispersion(dataList)}
        Median = ${median(dataList)}
        """.trimIndent()
        )
    return
}

fun fileOperations(num: Int) {
    val a: Int = num % 10

    val dataFromFile: List<Double> = readFileDouble(path).slice(a*100..(a+1)*100).sorted()

    result(dataFromFile)
    return
}

fileOperations(surnameSum(surname))

// 3. Для полного набора данных из data/numbers.txt составить набор пар (самое большое числое, самое маленькое число), (второе по величине, - второе по малости) и так далее. Посчитать для каждой пары сумму и вывести полученные значения в результат ячейки или новый файл. Посчитать среднее, дисперсию и медиану для полученного списка.


fun writeData(dataList: List<Any>, fileName: String) {
    File(fileName).printWriter().use { out -> out.println(dataList.joinToString(separator="\n")) }
    return
}

fun pairOperations() {
    val dataFromFile: List<Double> = readFileDouble(path).sorted()
    val len: Int = dataFromFile.size
    
    var i = 1;
    val pairSumList = List(len/2, { dataFromFile[i] + dataFromFile[len - 1 - i++] })

    writeData(pairSumList, "ks-2022-1/data/pairsums.txt")

    result(pairSumList)

    return
}

pairOperations()

// 4. (со *, творческая). Экспериментально исследовать точность сравнения чисел с плавающей точкой (Double) в разных диапазонах этих чисел.


