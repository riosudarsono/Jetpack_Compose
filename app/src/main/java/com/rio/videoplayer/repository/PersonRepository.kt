package com.rio.videoplayer.repository

import com.rio.videoplayer.model.Person

class PersonRepository {

    fun getAllDAta(): List<Person> {
        return listOf(
            Person(
                id = 1,
                firstName = "Rio",
                lastName = "Sudarsono",
                age = 28
            ),
            Person(
                id = 2,
                firstName = "Rio 2",
                lastName = "Sudarsono",
                age = 28
            ),
            Person(
                id = 3,
                firstName = "Rio 3",
                lastName = "Sudarsono",
                age = 28
            ),
            Person(
                id = 4,
                firstName = "Rio 4",
                lastName = "Sudarsono",
                age = 28
            ),
            Person(
                id = 5,
                firstName = "Rio 5",
                lastName = "Sudarsono",
                age = 28
            ),
            Person(
                id = 6,
                firstName = "Rio 6",
                lastName = "Sudarsono",
                age = 28
            ),
        )
    }
}