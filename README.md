Sports Dashboard Android App

Overview

The Sports Dashboard app allows users to log in using their credentials and view a list of sports, each with relevant details such as player count, field type, and Olympic status. Users can click on a specific sport to view more details about it.

Features

- User authentication via a login screen.
- Displays a list of sports from a REST API.
- Detail view for each sport, showing additional information.
- Navigation between dashboard and detail screens.
---
Requirements
- Android Studio (latest version recommended)
- Hilt library (used for dependency injection)
- Retrofit2 (used for communication with the API)

  To install retrofit and hilt just paste this in the buil.gradle.kts:
  // Retrofit dependancies
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("com.google.code.gson:gson:2.11.0")



    // Hilt dependancies
    implementation("com.google.dagger:hilt-android:2.52")
    implementation(libs.androidx.recyclerview)

Getting Started

Follow these steps to get the project running on your local machine:

1. Clone the Repository

Clone the project to your local machine:

2.Intall Hilt and Retrofit (it should already be installed in the proyect)

4. Set The API url and endpoints (It is already set)

3. Run the application
