package ru.safenreiter.lab1.exception

import java.io.FileNotFoundException

class ScriptNotFoundException(fileName: String) :
    FileNotFoundException("Файл-скрипт для миграций схемы БД не найден. Имя запрашиваемого файла: $fileName")
