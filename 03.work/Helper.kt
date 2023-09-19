import java.io.File
import java.io.FileInputStream

object Helper {
    private const val BASE_PATH = "../resources/"
    private lateinit var indexesMapped: Map<String, Int>

    fun summaryReport(
        newLine: List<String>,
        selectedColumns: ArrayList<Int>,
        columnsMapped: Map<String, Int> = indexesMapped,
        report: Report): Report {

        val sum = hashMapOf<String, Float>()
        val mean = hashMapOf<String, Float>()





        report.sum = sum
        report.mean = mean

        return report
    }

    fun createFileInputStream(basePath: String = BASE_PATH, filePath: String): FileInputStream {
        val file = File(basePath + filePath)
        return FileInputStream(file)
    }

    fun indexesFromSelectedColumns(headerLine: String, selectedColumns: String, delimiter: String): ArrayList<Int> {
        indexesMapped = mapIndex(headerLine.split(delimiter))
        val indexes = arrayListOf<Int>()
        selectedColumns.split(delimiter).forEach { column ->
            indexesMapped[column]?.let { indexes.add(it) }
        }
        return indexes
    }

    private fun mapIndex(line: List<String>): Map<String, Int> {
        var index = 0
        val map = line.map {item ->
            Pair(item, index++)
        }
        return map.toMap()
    }
}