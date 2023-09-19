import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.Key
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun main(args: Array<String>){
    encryptFile(args[0], args[1], args[3])
}

fun encryptFile(sourceFile: String, encryptedFile: String, key: String, bufferSize: Int = 1024){
    try {
        val key = generateSecretKey(key)
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, key)

        val input = FileInputStream(sourceFile)
        val output = FileOutputStream(encryptedFile)

        val buffer = ByteArray(bufferSize)
        var size : Int

        while (input.read(buffer).also { size = it } != -1) {
            val encryptedText = cipher.update(buffer, 0, size)
            output.write(encryptedText)
        }

        val finalTextEncrypted = cipher.doFinal()
        output.write(finalTextEncrypted)

        input.close()
        output.close()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun generateSecretKey(key: String): Key {
    val keyBytes = key.toByteArray(charset("UTF-8"))
    val sha256 = MessageDigest.getInstance("SHA-256")
    val hashKey = sha256.digest(keyBytes)
    return SecretKeySpec(hashKey, "AES")
}