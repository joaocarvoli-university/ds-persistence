import kotlin.system.measureTimeMillis

fun main(args: Array<String>){
    println("------------------ First Question ------------------")
    val timeExecutionFirst = measureTimeMillis {
        //Helper.copyFile(sourcePath = args[0], destinationPath = args[1])
    }
    println("first question time in ms: $timeExecutionFirst\n")

    println("------------------ Second Question ------------------")
    val timeExecutionSecond = measureTimeMillis {
        //Helper.copyFileByBlockSize(sourcePath = args[0], destinationPath = args[1])
    }
    println("second question time in ms: $timeExecutionSecond\n")

    println("------------------ Third Question ------------------")
    val timeExecutionThird = measureTimeMillis {
        //Helper.readAsIsoAndConvertToUTF(sourcePath = args[0], destinationPath = args[1])
    }
    println("third question time in ms: $timeExecutionThird\n")

    println("------------------ Fourth Question ------------------\n")
    val timeExecutionFourth = measureTimeMillis {
        //Helper.readInputUntilACharacterAndSave(destinationPath = args[0])
    }
    println("fourth question time in ms: $timeExecutionFourth\n")
}