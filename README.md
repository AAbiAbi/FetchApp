# Fetch API Android App

This Android app retrieves data from the Fetch API and displays the list of items grouped by `listId`. It filters out any items where `name` is blank or null and sorts the results by `listId` and `name`.

## Features
- Retrieve data from the [Fetch Hiring API](https://fetch-hiring.s3.amazonaws.com/hiring.json).
- Display items grouped by `listId`.
- Filter out items with null or blank `name`.
- Sort items first by `listId` and then by `name`.
- User-friendly UI using Jetpack Compose.

## Table of Contents
- [Installation](#installation)
- [Running the App](#running-the-app)
- [Screenshots](#screenshots)
- [Tech Stack](#tech-stack)
- [API Details](#api-details)
- [License](#license)

## Installation

To set up this project locally, follow these steps:

1. Clone the repository:
   Open the project in Android Studio.

2. Sync the project with Gradle files to ensure all dependencies are downloaded.

3. Build and Run the project:

4. You can either run the app on a physical Android device or an Android emulator.

## Running the App

Requirements
- Android Studio: Latest stable version.
- Android SDK: API 34 (Android 14) as the target SDK.
- Java: JDK 17 for development.

## Screenshots

## Tech Stack

- Kotlin: The programming language used to build the app.
- Jetpack Compose: For building the UI in a modern declarative way.
- Retrofit: For making network requests to fetch the JSON data.
- Gson: For converting JSON data to Kotlin objects.
- Material 3: For the user interface styling.


## API Details

## License

This project is licensed under the MIT License - see the LICENSE file for details.
