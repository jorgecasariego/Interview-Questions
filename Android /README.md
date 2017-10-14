# What is Android?
Android is an Open Source mobile operating system developed by Google and based on the Linux Kernel. Android is design primarily for touchscreen devices (smartphones and tablets).

# What is the APK format?
Android Application Package (APK) is the package file format used to distributed and install application software onto Android.

![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/Android%20/android-interview-apk-structure.jpg)

# What is Dalvik?
Dalvik is a register-based Virtual Machine (VM). Every Android app runs in its own proccess with its own isntance of the Dalvik VM.

Note: Dalvik was entirely replaced by ART in Android 5.0 Lollipop

# What is ART?

ART (Android Runtime) is the new runtine enviroment for Android apps. ART improves the execution efficiency by using AOT(Ahead Of Time) compilation.

# What is the “UI thread”?

An Android app runs in its own process and can use multiple threads. The thread that the app will be executed upon, most of the time, is called the “main thread” or the “UI thread”.


# What is Instant Run?

Instant Run has the intention to increase the development speed of Android apps. Instead of rebuilding the whole app, Android is trying to patch the existing app on the Android device to reflect your changes.

# What is an Android manifest file?

Every Android app must have an AndroidManifest.xml file in its root directory. The AndroidManifest.xml file provides essential information about the application to the Android system, which the system must have before it can run any of the application’s code.

## Background: It contains information about:

 - the Java package of the application
 - app components like activities, services, broadcast receivers and content providers
 - necessary permissions

 # What is ADB?

 Android Debug Bridge (adb)  is a command-line tool that lets you communicate with an Android device. It provides a variety of device actions, such as installing and debugging apps.

# What is an Intent?

An Intent is basically a message that is passed between components like Activities or Services. It acts as a trigger to do something.

## Background: Intents are asynchronous and allow you to interact with components from the same application as well as with components from other applications. The primary pieces of information in an Intent are:

 - Action: The generic action to perform (ACTION_VIEW -> view, ACTION_EDIT -> edit, …)
 - Extras: The data to operate on, stored in a key-value mapping (Bundle)
 - Component name: The name of the component to start. This value makes an Intent explicit (e.g. com.example.AnotherActivity.class)
 - Flags: Optional metadata for the Intent







