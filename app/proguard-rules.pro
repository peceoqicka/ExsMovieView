# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SocdrceFile

# -----------------------Part.Glide---------------------------
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keepnames class com.bumptech.glide.** { *; }
#-------------------------------------------------------------

#-------------------Part.Retrofit N RxJava--------------------
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions
#-------------------------------------------------------------

#-------------------------------------------------------------
-dontwarn javax.annotation.**
-dontwarn org.codehaus.**
-dontwarn java.nio.**
-dontwarn java.lang.invoke.**
-dontwarn rx.**
#-------------------------------------------------------------

#----------------------------Others---------------------------
# rxjava2
#-keepnames class io.** { *; }
# okio
#-keepnames class okio.** { *; }
# okhttp3
#-keepnames class okhttp3.** { *; }
#-keepnames class com.google.gson.** { *; }
#-keepnames class retrofit2.** { *; }

#-keepnames class kotlin.** { *; }
#-keepnames class android.** { *; }
-keepnames class com.android.databinding.** { *; }
-keepnames class com.em.exsmovieview.data.HotList { *; }
-keepnames class com.em.exsmovieview.data.HotList$MovieData { *; }
-keepnames class com.em.exsmovieview.data.HotList$Control { *; }
-keepnames class com.em.exsmovieview.data.HotList$Movie { *; }
#-------------------------------------------------------------