package ru.safenreiter.lab1.service

import java.io.FileNotFoundException
import java.sql.Connection
import ru.safenreiter.lab1.config.Properties
import ru.safenreiter.lab1.exception.ScriptNotFoundException
import ru.safenreiter.lab1.service.PreloadSchemaService.deleteTableScript


object PreloadSchemaService {

    private val createTableScript = """
        create table if not exists node (
	id BIGSERIAL primary key,
	lat float8,
	lon float8,
	username VARCHAR(100),
	uid BIGINT,
	version BIGINT,
	changeset BIGINT,
	date_time TIMESTAMP
);
"""

    private val deleteTableScript = "drop table if exists node cascade;"

    fun preloadSchema() {
        ConnectionPool.getConnection()
            .let { connection ->
                clearAllData(connection)
                migrateNodeTable(connection)
                connection.close()
            }
    }

    private fun migrateNodeTable(connection: Connection) {
        connection.prepareStatement(createTableScript).execute()
    }

    private fun clearAllData(connection: Connection) {
        connection.prepareStatement(deleteTableScript).execute()
    }

}