import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.internal.declarativedsl.analysis.AssignmentMethod
import org.gradle.internal.serialize.graph.singleton

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}


android {
    namespace = "org.quarksutils.iconpack"
    compileSdk = 34

    defaultConfig {
        minSdk = 30
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        aarMetadata {
            minCompileSdk=30
        }
    }

   testFixtures{
       enable=true
   }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}




publishing{

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/subham008/ExtensionIconPack")
            credentials {
                username = System.getenv("GIT_USER_NAME")
                password = System.getenv("GIT_ACCESS_TOKEN")
            }
        }
    }

    publications{
        register<MavenPublication>("release") {
            groupId = "com.subham008"
            artifactId = "extensioniconpack"
            version = "1.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }


}