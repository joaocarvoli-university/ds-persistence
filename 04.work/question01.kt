import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

fun main(args: Array<String>){
    compactToZip(args[0], args[1])
}

fun compactToZip(zipFilePath: String, filePath: String){
    val directory = File(filePath)
    val files = directory.listFiles()

    if(files != null) {
        val fileOutputStream = FileOutputStream(zipFilePath)
        val zipOutputStream = ZipOutputStream(fileOutputStream)

        files.forEach { file ->
            addFileIntoZip(zipOutputStream, file, "")
        }

        zipOutputStream.close()
        fileOutputStream.close()
    }
}

private fun addFileIntoZip(zipOutputStream: ZipOutputStream, file: File, baseDirectory: String, bufferSize: Int = 1024){
    val inputName = if(baseDirectory.isEmpty()) file.name else "$baseDirectory/${file.name}"

    if(file.isDirectory) {
        val subFiles = file.listFiles()
        subFiles?.forEach { file ->
            addFileIntoZip(zipOutputStream, file, inputName)
        }
    } else {
        val input = FileInputStream(file)
        val zipInput = ZipEntry(inputName)
        zipOutputStream.putNextEntry(zipInput)

        val buffer = ByteArray(bufferSize)
        var size : Int

        while (input.read(buffer).also { size = it } > 0){
            zipOutputStream.write(buffer, 0, size)
        }

        input.close()
        zipOutputStream.closeEntry()
    }
}