import kotlin.random.Random

fun main() {
    ex3()
}

fun ex1(){
    val choices = arrayOf("Камень", "Ножницы", "Бумага")

    while (true) {
        println("Выберите ваш ход:")
        println("1 - Камень")
        println("2 - Ножницы")
        println("3 - Бумага")

        val my = when (readlnOrNull()) {
            "1" -> "Камень"
            "2" -> "Ножницы"
            "3" -> "Бумага"
            else -> {
                println("Некорректный выбор. Попробуйте еще раз.")
                continue
            }
        }

        val his = choices[Random.nextInt(choices.size)]
        println("Выбор оппонента: $his")
        println("Ваш выбор: $my")

        choiceWinner(his, my)

        println("Желаете сыграть еще раз? (y/n)")
        if (readlnOrNull()?.lowercase() != "y")
            break
    }
}

fun choiceWinner(first: String, second: String){
    when {
        (first == "Камень" && second == "Ножницы") || (first == "Ножницы" && second == "Бумага")
                || (first == "Бумага" && second == "Камень")
        -> println("Поражение")

        (second == "Камень" && first == "Ножницы") || (second == "Ножницы" && first == "Бумага")
                || (second == "Бумага" && first == "Камень")
        -> println("Победа")

        else -> println("Ничья")
    }
}

fun ex3() {
    println("Введите строку для шифрования: ")
    val inputString = readln()
    println("Введите код для шифрования: ")
    val enteredCode = readln()
    var code = ""

    while (code.length < inputString.length) {
        code += enteredCode
    }

    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    for (i in inputString.indices) {
        val begin = findIndex(inputString[i], alphabet)
        val offset = findIndex(code[i], alphabet)
        print(alphabet[(begin + offset) % 33])
    }
}

fun findIndex(ch : Char, alphabet : String) : Int
{
    for (i in alphabet.indices){
        if (ch == alphabet[i])
            return i
    }
    return -1;
}
