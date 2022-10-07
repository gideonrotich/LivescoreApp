# Livescore
This allows us to easily define specifications in a clear, understandable, human-readable way. This framework allows you to describe tests and expected behaviors in a more readable way.

To run tests in Android Studio you need to install Spek Framework plugin (search for Spek Framework).

The UI test run normally, either on a device or an emulator, without any special plugin or dependency.


### How it's built

* Technologies used
    * [Kotlin](https://kotlinlang.org/)
    * [Compose](https://developer.android.com/jetpack/compose) Because **COMPOSE IS FINALLY STABLE**
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
    * [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html)
    * [KOIN](https://insert-koin.io/)
    * [Retrofit](https://square.github.io/retrofit/)
    * [Chucker](https://github.com/ChuckerTeam/chucker)
    * [Jetpack](https://developer.android.com/jetpack)
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    * [Timber](https://github.com/JakeWharton/timber)
    * [Leak Canary](https://github.com/square/leakcanary)

* Architecture
    * MVVM - Model View View Model

* Tests
    * [JUnit5](https://junit.org/junit5/)
    * [Spek](https://www.spekframework.org/)
    * [MockK](https://github.com/mockk/mockk)
    * [Turbine](https://github.com/cashapp/turbine)

* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    * Plugins
        * [Spotless](https://github.com/diffplug/spotless)
        * [Dokka](https://github.com/Kotlin/dokka)
        * [jacoco](https://github.com/jacoco/jacoco)
        * [Ktlint](https://github.com/JLLeitschuh/ktlint-gradle)
        * [Detekt](https://github.com/detekt/detekt)

* CI/CD
    * Github Actions
    * [Fastlane](https://fastlane.tools)


### Screenshots

I added some screenshots in the `screenshots` folder, in the root directory of the project. Added some GIFs to also show end to end test on the app

Light | Dark | GIF
--- | --- | ---
<img src="https://github.com/jumaallan/apollo-agriculture/blob/master/screenshots/weather_light.png" width="280"/> | <img src="https://github.com/jumaallan/apollo-agriculture/blob/master/screenshots/weather_dark.png" width="280"/> | <img src="https://github.com/jumaallan/apollo-agriculture/blob/master/screenshots/weather.gif" width="280"/>
