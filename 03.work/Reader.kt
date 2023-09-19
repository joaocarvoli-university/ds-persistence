object Reader {
    private val summaryCSV = Report()

    /**
     *
     * */
    fun readCSV(filePath: String, delimiter: String, columnsToProcess: String){
        val inputStream = Helper.createFileInputStream(filePath = filePath)
        val reader = inputStream.bufferedReader()
        val header = reader.readLine()
        val selectedColumnsIndexes = Helper.indexesFromSelectedColumns(header, columnsToProcess, delimiter)

        reader.forEachLine { line ->
            val lineItems = line.split(delimiter)
            val filteredLine = lineItems.filterIndexed { index, _ -> selectedColumnsIndexes.contains(index)}
            Helper.summaryReport(newLine = filteredLine, selectedColumns = selectedColumnsIndexes, report = summaryCSV)
        }

        println(summaryCSV)
    }
}