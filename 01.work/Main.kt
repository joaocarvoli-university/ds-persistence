import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStream
import java.io.InputStreamReader

private const val BASE_PATH = "../resources/"

fun main(args: Array<String>){
    try {
        println("------------------ First Question ------------------")
        //readTextFile(fileName = args[0], linesLimit = 10)

        println("\n------------------ Second Question ------------------")
        //readTextFileWithString(fileName = args[0], word = args[1])

        println("\n------------------ Third Question ------------------")
        //readMultipleTextFiles(args)
    } catch (exceptionIndexOutOfBound: IndexOutOfBoundsException){
        println("You don't sent the args!")
    }
}

private fun readTextFile(basePath: String = BASE_PATH, fileName: String, linesLimit: Int? = null){
    val inputStream: InputStream = FileInputStream(basePath + fileName)
    val inputStreamReader = InputStreamReader(inputStream)
    val bufferedReader = BufferedReader(inputStreamReader)
    var fileContent = bufferedReader.readLine()
    var counter = linesLimit

    while(fileContent != null){
        if (counter != null) {
            counter -= 1
        }
        if(counter == -1) break
        println(fileContent)
        fileContent = bufferedReader.readLine()
    }

    bufferedReader.close()
}

private fun readTextFileWithString(basePath: String = BASE_PATH, fileName: String, word: String, linesLimit: Int? = null){
    val inputStream: InputStream = FileInputStream(basePath + fileName)
    val inputStreamReader = InputStreamReader(inputStream)
    val bufferedReader = BufferedReader(inputStreamReader)
    var fileContent = bufferedReader.readLine()
    var counter = linesLimit

    while(fileContent != null){
        if (counter != null) {
            counter -= 1
        }
        if(counter == -1) break
        if(fileContent.contains(word)){
            println(fileContent)
        }
        fileContent = bufferedReader.readLine()
    }

    bufferedReader.close()
}

private fun readMultipleTextFiles(fileNames: Array<String>){
    fileNames.forEach { fileName ->
        readTextFile(fileName = fileName)
        println()
    }
}