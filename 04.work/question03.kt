import java.io.FileInputStream
import java.io.FileOutputStream
import javax.crypto.Cipher

fun main(args: Array<String>){
    decryptFile(args[0], args[1], args[2])
}

fun decryptFile(encryptedFile: String, decryptedFile: String, key: String, bufferSize: Int = 1024) {
    try {
        val key = generateSecretKey(key)
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, key)

        val input = FileInputStream(encryptedFile)
        val output = FileOutputStream(decryptedFile)

        val buffer = ByteArray(bufferSize)
        var size : Int

        while (input.read(buffer).also { size = it } != -1) {
            val decryptedText = cipher.update(buffer, 0, size)
            output.write(decryptedText)
        }

        val finalTextDecrypted = cipher.doFinal()
        output.write(finalTextDecrypted)

        input.close()
        output.close()

    }  catch (e: Exception) {
        println(e.message)
    }
}