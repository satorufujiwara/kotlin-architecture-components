kotlin-architecture-components
====

This is a sample app that uses Android Architecture Components with Kotlin and Dagger 2.

Architecture Components
---
Architecture Components version is 1.1.*

Kotlin
----
Kotlin version is 1.2.*

Dagger2
----
Dagger version is 2.14.*

Using [dagger.android](https://google.github.io/dagger//android.html).

Other Libraries
---------

 * DataBinding - https://developer.android.com/topic/libraries/data-binding/index.html
 * OkHttp - http://square.github.io/okhttp
 * Retrofit - http://square.github.io/retrofit
 * Moshi - https://medium.com/square-corner-blog/kotlins-a-great-language-for-json-fcd6ef99256b
 * Glide - https://github.com/bumptech/glide
 * RxJava - https://github.com/ReactiveX/RxJava
 * RxAndroid - https://github.com/ReactiveX/RxAndroid
 * Timber - http://github.com/JakeWharton/timber

Tips
----

#### Multibinding

To use Multibinding for ViewModel's injection like [this](https://github.com/googlesamples/android-architecture-components/commit/619ef780f2989a1925f05a3801272b3b9d27bf03),
use `@JvmSuppressWildcards` for inject `creators`.

```kotlin
class ViewModelFactory @Inject
constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
    : ViewModelProvider.Factory {
```
[Here](https://github.com/satorufujiwara/kotlin-architecture-components/blob/master/app/src/main/java/jp/satorufujiwara/kotlin/di/ViewModelFactory.kt) is all code.

#### DataBinding

To use DataBinding with Kotlin, use `com.android.databinding:compiler` like below.

```Groovy
dependencies {
    kapt 'com.android.databinding:compiler:3.0.0'
}
```

Thanks
------
* Android Architecture Components samples - https://github.com/googlesamples/android-architecture-components

License
-------
    Copyright 2017 Satoru Fujiwara

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
