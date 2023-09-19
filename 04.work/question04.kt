import java.io.File
import java.io.FileOutputStream
import java.security.MessageDigest
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {

    val inputFile = File(args[0])
    val outputFile = File(args[1])

    val md5Hash = calculateHash(inputFile, "MD5")
    val sha1Hash = calculateHash(inputFile, "SHA-1")
    val sha256Hash = calculateHash(inputFile, "SHA-256")

    val outputString = """
        MD5: $md5Hash
        SHA-1: $sha1Hash
        SHA-256: $sha256Hash
    """.trimIndent()

    writeToFile(outputFile, outputString)
}

fun calculateHash(file: File, algorithm: String): String {
    val startTime = System.currentTimeMillis()

    measureTimeMillis {
        val messageDigest = MessageDigest.getInstance(algorithm)
        val inputStream = file.inputStream()
        val buffer = ByteArray(4096)
        var bytesRead: Int

        while (inputStream.read(buffer).also { bytesRead = it } != -1) {
            messageDigest.update(buffer, 0, bytesRead)
        }

        val bytes = messageDigest.digest()
        val hexString = bytes.joinToString("") { "%02x".format(it) }

        println("$algorithm calculated in ${System.currentTimeMillis() - startTime} ms")

        return hexString
    }
}

fun writeToFile(file: File, content: String) {
    FileOutputStream(file).use { output ->
        output.write(content.toByteArray())
    }
}
