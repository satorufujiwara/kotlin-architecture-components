# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /adt-bundle-mac/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

## dagger

# dagger2 https://github.com/google/dagger/issues/645
-dontwarn com.google.errorprone.annotations.*

## data

# moshi
# okhttp3
-dontwarn okio.**
-dontwarn javax.annotation.**


# moshi https://github.com/square/moshi
-keepclasseswithmembers class * {
    @com.squareup.moshi.* <methods>;
}
-keep @com.squareup.moshi.JsonQualifier interface *
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}

# retrofit2 http://square.github.io/retrofit/
-dontnote retrofit2.Platform
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions

# okhttp3 https://github.com/square/okhttp/issues/2230
-dontwarn okhttp3.**

# glide https://github.com/krschultz/android-proguard-snippets/blob/master/libraries/proguard-glide.pro
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class com.bumptech.glide.integration.okhttp3.OkHttpGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}
