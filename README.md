
# Recipe App KMP Compose Multiplatform

This app is built using Kotlin Multiplatform using Jetpack Compose based UI Framework Compose Multiplatform for sharing the UI between Android, iOS, Web and Desktop all platforms. 
It demonstrates the use of Koin for Dependency Injection, Ktor for Networking, SQLDelight for Persitence and Compose Navigation for navigation and Compose ViewModel for business logic in Kotlin Multiplatform for Android, iOS, Web and Desktop platforms. 
It features minimal features of Recipe App such as List of Recipes, Recipe Detail, Search Recipes, Favorite Recipes, Login and Profile Screens etc..

## Libraries used


* [Kotlin Multiplatform](https://www.jetbrains.com/kotlin-multiplatform/)
* [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
* [Koin](https://github.com/InsertKoinIO/koin)
* [SQLDelight](https://github.com/cashapp/sqldelight)
* [Coil](https://coil-kt.github.io/coil/)
* [KTOR Client](https://ktor.io/docs/client-create-new-application.html)
* [Multiplatform Settings](https://github.com/russhwolf/multiplatform-settings)
* [Compose Navigation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html)

## Screenshots

#### Mobile
| | | | |
|:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:|
|<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/sunildhiman90/RecipeApp-KMP-Compose-Multiplatform/blob/initial/screenshots/screenshot1_home.jpg">  |  <img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/sunildhiman90/RecipeApp-KMP-Compose-Multiplatform/blob/initial/screenshots/screenshot2_search.jpg">|<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/sunildhiman90/RecipeApp-KMP-Compose-Multiplatform/blob/initial/screenshots/screenshot3_detail.jpg">|<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/sunildhiman90/RecipeApp-KMP-Compose-Multiplatform/blob/initial/screenshots/screenshot4_login.jpg">|
|<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/sunildhiman90/RecipeApp-KMP-Compose-Multiplatform/blob/initial/screenshots/screenshot5_profile.jpg">|<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/sunildhiman90/RecipeApp-KMP-Compose-Multiplatform/blob/initial/screenshots/screenshot6_profile.jpg">|<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/sunildhiman90/RecipeApp-KMP-Compose-Multiplatform/blob/initial/screenshots/screenshot7_fav.jpg">|<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/sunildhiman90/RecipeApp-KMP-Compose-Multiplatform/blob/initial/screenshots/screenshot8_popup.jpg">

#### Desktop/Web
| | |
|:-------------------------:|:-------------------------:|
|<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/sunildhiman90/RecipeApp-KMP-Compose-Multiplatform/blob/initial/screenshots/screenshot1_desktop_home.jpg">  |

## Pre-requisites

* Kotlin
* Java JDK 17+
* Latest stable version of Android Studio IDE
* Latest XCode (for iOS)
* Kotlin Multiplatform Plugin in Android Studio



## Setup

* Clone this repository.
* Open in the latest version of Android Studio and You are ready to Go.

## Data Source

* The app uses [Recipe API](https://www.themealdb.com/api.php) for fetching the recipes.
* All Ingredients[Here](https://www.themealdb.com/api/json/v1/1/list.php?i=list)
* All Categories[Here](https://www.themealdb.com/api/json/v1/1/list.php?c=list)
* All Areas[Here](https://www.themealdb.com/api/json/v1/1/list.php?a=list)
* Filter by ingredient[Here](https://www.themealdb.com/api/json/v1/1/filter.php?i=chicken_breast)
* Filter by Category[Here](https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood)
* Ingredient Image
  * www.themealdb.com/images/ingredients/lime.png
  * www.themealdb.com/images/ingredients/lime-small.png
  * www.themealdb.com/images/ingredients/lime-medium.png
  * www.themealdb.com/images/ingredients/lime-large.png