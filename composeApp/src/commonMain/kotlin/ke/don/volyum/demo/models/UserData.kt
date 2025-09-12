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

data class UserData(
    val id: String = "",
    val name: String = "",
    val profileUrl: String = "",
) {
    fun getRandom(): UserData {
        val newId = (2..1000).random().toString()
        return UserData(
            id = newId,
            name = FauxData.randomNames.random(),
            profileUrl = "https://picsum.photos/200?seed=$newId",
        )
    }

    fun toMetadata(): UserMetadata {
        return UserMetadata(
            username = name,
            profileUrl = profileUrl,
        )
    }
}
