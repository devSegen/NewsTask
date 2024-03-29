plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
}

android {
  namespace = "com.app.data"
  compileSdk = 33

  defaultConfig {
    minSdk = 24

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      buildConfigField("String", "BASE_URL", "\"https://newsapi.org/v2/\"")

    }
    debug {
      buildConfigField("String", "BASE_URL", "\"https://newsapi.org/v2/\"")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures{
    buildConfig = true
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.9.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.google.android.material:material:1.11.0")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

  //koin
  implementation("io.insert-koin:koin-core:3.4.3")
  implementation( "io.insert-koin:koin-annotations:1.1.1")
  implementation( "io.insert-koin:koin-ksp-compiler:1.1.1")

  // Retrofit for networking
  api("com.squareup.retrofit2:retrofit:2.9.0")
  api ("com.squareup.retrofit2:converter-moshi:2.9.0")
  api("com.squareup.retrofit2:converter-scalars:2.8.1")
  api ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
  api ("com.squareup.okhttp3:logging-interceptor:4.11.0")
  api("com.squareup.okhttp3:logging-interceptor:4.11.0")
  api ("com.google.code.gson:gson:2.10.1")
  api ("com.squareup.retrofit2:converter-gson:2.9.0")

}