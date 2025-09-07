/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */
package ke.don.birdie.feedback.network.api

import ke.don.birdie.feedback.BuildKonfig

private val URL = BuildKonfig.SUPABASE_URL

sealed class Endpoint(val route: String) {
    open val baseUrl = "${URL}/rest/v1/"

    val url: String
        get() = buildString {
            append(baseUrl)
            append(route)
        }

    /** Test table */
    object TestTable : Endpoint(route = "test_table")

    sealed class PostgresFunctions(route: String) : Endpoint(route) {
        override val baseUrl = "${URL}/rest/v1/rpc/"

        object AddFeedback : PostgresFunctions(route = "add_feedback")

    }
}
