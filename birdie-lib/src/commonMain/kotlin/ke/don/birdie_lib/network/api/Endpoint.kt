package ke.don.birdie_lib.network.api

import ke.don.birdie_lib.BuildKonfig

sealed class SupabaseEndpoint(val route: String) {
    open val baseUrl = "${BuildKonfig.SUPABASE_URL}/rest/v1/"

    val url: String
        get() = buildString {
            append(baseUrl)
            append(route)
        }

    /** Test table */
    object TestTable : SupabaseEndpoint(route = "test_data")
}
