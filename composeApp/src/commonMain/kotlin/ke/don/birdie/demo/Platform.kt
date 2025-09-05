package ke.don.birdie.demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform