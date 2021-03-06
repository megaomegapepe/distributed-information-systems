package ru.safenreiter.lab1

import javax.xml.stream.XMLEventReader
import ru.safenreiter.lab1.config.Properties.FILE_NAME
import ru.safenreiter.lab1.service.OpenStreetMapReaderHandler
import ru.safenreiter.lab1.service.StaxStreamProcessor


class Lab1Application

fun main() {
    getXmlEventReaderFromFile().let { eventReader ->
        OpenStreetMapReaderHandler.processTheReader(eventReader)
        eventReader.close()
    }
}

private fun getXmlEventReaderFromFile(): XMLEventReader {
    return Lab1Application::class.java.classLoader.getResourceAsStream(FILE_NAME)
        .let { inputStreamOfXmlFile ->
            StaxStreamProcessor.getXmlEventReader(
                inputStreamOfXmlFile
                    ?: throw RuntimeException("File not found")
            )
        }
}