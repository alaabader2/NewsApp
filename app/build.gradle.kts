plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.todayinpalestine"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.todayinpalestine"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.android.volley:volley:1.2.0")
    implementation ("androidx.fragment:fragment:1.3.6")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    implementation("com.github.bumptech.glide:glide:4.12.0")
    testImplementation("junit:junit:4.12")
   // annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")
}

