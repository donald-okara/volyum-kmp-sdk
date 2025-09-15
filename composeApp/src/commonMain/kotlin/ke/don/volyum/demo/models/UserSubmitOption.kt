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

/**
 * Represents the options available to a user when submitting feedback.
 *
 * Each option has a human-readable [description].
 *
 * - [MyProfile]: Allows the user to submit feedback associated with their own profile.
 * - [Anonymous]: Allows the user to submit feedback without revealing their identity.
 * - [RandomUser]: Allows submitting feedback as a randomly generated user. **This option
 *   should only be used for testing or development purposes and never in a production environment.**
 */
enum class UserSubmitOption(val description: String) {
    MyProfile(
        "Submit feedback with my profile",
    ),
    Anonymous(
        "Submit feedback anonymously",
    ),
    RandomUser(
        "Submit feedback with a random user. 🚩 Do not use in production",
    ),
}
