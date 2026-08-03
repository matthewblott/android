plugins {
  alias(libs.plugins.android.application)
  id("org.jetbrains.kotlin.plugin.serialization") version "2.3.0" apply false
}

android {
  namespace = "com.matthewblott.jimlog"
  compileSdk {
    version = release(37)
  }

  defaultConfig {
    applicationId = "com.matthewblott.jimlog"
    minSdk = 28
    targetSdk = 37
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    release {
      optimization {
        enable = false
      }
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

dependencies {
  implementation(libs.androidx.activity.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.androidx.core.ktx)
  implementation(libs.material)
  implementation("dev.hotwire:core:1.3.1")
  implementation("dev.hotwire:navigation-fragments:1.3.1")
  implementation("com.github.joemasilotti:bridge-components:0.14.0")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")
}