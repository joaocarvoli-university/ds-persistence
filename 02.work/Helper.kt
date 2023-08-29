import java.io.*
import java.nio.charset.Charset
import java.util.Scanner

object Helper {
    private const val BASE_PATH = "../resources/"

    /**
     * Receive the path of a file and copy it to other path
     */
    fun copyFile(basePath: String = BASE_PATH,
                   sourcePath: String, destinationPath: String){
        try {
            val sourceFile = File(basePath + sourcePath)
            val destinationFile = File(basePath + destinationPath)

            FileInputStream(sourceFile).use { fileInputStream ->
                FileOutputStream(destinationFile).use { fileOutputStream ->
                    var byte: Int
                    while (fileInputStream.read().also { byte = it } != -1) {
                        fileOutputStream.write(byte)
                    }
                }
            }
        } catch(exception: Exception) {
            println(exception)
        }
    }

    /**
     * Receive the path of a file and copy it to other path consider the size of the block of bytes during this process
     */
    fun copyFileByBlockSize(basePath: String = BASE_PATH,
                              sourcePath: String, destinationPath: String, blockSize: Int = 8192
    ){
        try {
            val sourceFile = File(basePath + sourcePath)
            val destinationFile = File(basePath + destinationPath)

            FileInputStream(sourceFile).use { fileInputStream ->
                FileOutputStream(destinationFile).use { fileOutputStream ->
                    val buffer = ByteArray(blockSize)
                    var len: Int
                    while (fileInputStream.read(buffer).also { len = it } != -1) {
                        fileOutputStream.write(buffer, 0, len)
                    }
                }
            }
        } catch (exception: Exception){
            println(exception)
        }
    }


    /**
     * Receive the path of a file in the ISO-8859-1 codification and convert it to UTF-8
     */
    fun readAsIsoAndConvertToUTF(basePath: String = BASE_PATH,
                                 sourcePath: String, destinationPath: String, blockSize: Int = 1024)
    {
        try {
            val sourceFile = File(basePath + sourcePath)
            val destinationFile = File(basePath + destinationPath)

            FileInputStream(sourceFile).use { fileInputStream ->
                InputStreamReader(fileInputStream, Charset.forName("ISO-8859-1")).use { inputStreamReader ->
                    FileOutputStream(destinationFile).use { fileOutputStream ->
                        OutputStreamWriter(fileOutputStream, Charset.forName("UTF-8")).use { outputStreamReader ->
                            val buffer = CharArray(blockSize)
                            var charsRead: Int
                            while (inputStreamReader.read(buffer).also { charsRead = it } != -1) {
                                outputStreamReader.write(buffer, 0, charsRead)
                            }
                        }
                    }
                }
            }
        } catch (exception: Exception){
            println(exception)
        }
    }

    /**
     * Read the keyboard input from terminal until the insertion of a stopCharacter and insert it in a file
     */
    fun readInputUntilACharacterAndSave(basePath: String = BASE_PATH,
                                 destinationPath: String, stopCharacter: String = "END"){
        try {
            val reader = Scanner(System.`in`)

            while (true) {
                val line = reader.nextLine()
                if (line == stopCharacter) break
                appendLineToFile(
                    filePath = basePath + destinationPath,
                    content = line
                )
            }
        } catch (exception: Exception){
            println(exception)
        }
    }

    private fun appendLineToFile(filePath: String, content: String){
        try {
            val file = File(filePath)

            FileOutputStream(file, true).use { fileOutputStream ->
                fileOutputStream.write("$content\n".toByteArray())
            }
        } catch (exception: Exception){
            println(exception)
        }
    }
}