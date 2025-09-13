/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.volyum.demo.models

import ke.don.volyum.feedback.model.table.UserMetadata

/**
 * Represents user data.
 *
 * @property id The unique identifier for the user. Defaults to an empty string.
 * @property name The name of the user. Defaults to an empty string.
 * @property profileUrl The URL of the user's profile picture. Defaults to an empty string.
 */
data class UserData(
    val id: String = "",
    val name: String = "",
    val profileUrl: String = "",
) {
    /**
     * Generates a random [UserData] object.
     * The ID is a random number between 2 and 1000, converted to a string.
     * The name is a randomly selected name from [FauxData.randomNames].
     * The profile URL is generated using picsum.photos with the generated ID as the seed.
     *
     * @return A new [UserData] instance with randomized data.
     */
    fun getRandom(): UserData {
        val newId = (2..1000).random().toString()
        return UserData(
            id = newId,
            name = FauxData.randomNames.random(),
            profileUrl = "https://picsum.photos/200?seed=$newId",
        )
    }

    /**
     * Converts this UserData object to a UserMetadata object.
     *
     * @return A UserMetadata object containing the username and profile URL from this UserData.
     */
    fun toMetadata(): UserMetadata {
        return UserMetadata(
            username = name,
            profileUrl = profileUrl,
        )
    }
}
