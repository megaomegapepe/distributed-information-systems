package ru.safenreiter.lab1.service

import ru.safenreiter.lab1.Node
import ru.safenreiter.lab1.dao.NodeDAO

object DataInserterService {

    fun insertDataFromIterable(nodes: Iterable<Node>) {
        nodes.forEach { node -> NodeDAO.insertNode(node) }
    }
}