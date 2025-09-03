package suponev.ilya.tutor_db

class Platform {
    val name: String = "Java ${System.getProperty("java.version")}"
}

fun getPlatform() = Platform()
