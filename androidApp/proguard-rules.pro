

# Keep entire package
-keep class com.karthik.android.techtestkmp.** { *; }

# For libraries that use reflection (like Gson, Moshi, etc.)
-keep class org.koin.serialization.** { *; }
#-keepclassmembers class * {
#    @com.google.gson.annotations.SerializedName <fields>;
#}

# For Koin, Hilt, or DI frameworks
-keep class org.koin.** { *; }
-keepclassmembers class * {
    public <init>(...);
}

# io.ktor dependencies
-dontwarn io.netty.**
-dontwarn io.ktor.**
-dontwarn com.typesafe.**

-keep class org.slf4j.** { *; }
-dontwarn org.slf4j.**

# Keep all Ktor core packages
-keep class io.ktor.** { *; }
-keep class io.ktor.util.** { *; }

# CIO engine
#-keep class io.ktor.client.engine.cio.** { *; }

# OkHttp engine
-keep class io.ktor.client.engine.okhttp.** { *; }

# Ktor serialization with kotlinx.serialization
-keep class kotlinx.serialization.** { *; }
#-keepclassmembers class ** {
#    @kotlinx.serialization.SerialName <fields>;
#}
#-keepclassmembers class ** {
#    @kotlinx.serialization.Serializable <fields>;
#}

#JsonFeature or ContentNegotiation
-keep class io.ktor.client.plugins.contentnegotiation.** { *; }
-keep class io.ktor.serialization.** { *; }

# Prevent Ktor HTTP engine config issues
-keepclassmembers class io.ktor.client.** {
    public <init>(...);
}

# Inspecting HTTP traffic
-keep class io.ktor.client.plugins.logging.** { *; }