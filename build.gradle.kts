// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    extra.apply {
        set("nav_version", "2.5.3")
        set("room_version", "2.5.2")
    }
    dependencies{
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}
plugins {
    id("com.android.application") version "8.1.3" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
