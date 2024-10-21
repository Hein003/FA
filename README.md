 Sports Dashboard Android App

Overview

The Sports Dashboard app is an Android application designed to provide users with an intuitive interface to log in and explore a list of sports. Each sport entry offers details such as the number of players, field type, and whether it is an Olympic sport. Users can tap on individual sports to view more detailed information.

Features

User Authentication: Secure login using user credentials.
Sports List: Fetch and display a list of sports from a REST API.
Sport Detail View: Detailed information for each sport, including player count, field type, and Olympic status.
Seamless Navigation: Easy navigation between the dashboard and detailed views of each sport.
Requirements
To build and run this project, ensure you have the following:

Android Studio (latest version recommended)
Hilt for dependency injection
Retrofit2 for API communication
Dependencies
Add the following dependencies to your build.gradle.kts file:

// Retrofit dependencies

implementation("com.squareup.retrofit2:retrofit:2.11.0")

implementation("com.squareup.retrofit2:converter-moshi:2.11.0")

implementation("com.squareup.moshi:moshi-kotlin:1.15.1")

implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

implementation("com.squareup.retrofit2:converter-gson:2.11.0")

implementation ("com.google.code.gson:gson:2.11.0")

// Hilt dependencies

implementation("com.google.dagger:hilt-android:2.52")

// RecyclerView

implementation(libs.androidx.recyclerview)

Getting Started

Follow these steps to set up and run the project on your local machine:

Clone the Repository:

Clone this repository to your local development environment using the following command:

Install Dependencies:

Ensure that the required dependencies (Hilt, Retrofit, etc.) are already installed. If not, add them to your project as described above.

API Configuration:

The API URL and endpoints are pre-configured. No additional setup is needed for the API.

Run the Application:

Open the project in Android Studio and click on the "Run" button to build and deploy the app to your preferred Android emulator or connected device.
