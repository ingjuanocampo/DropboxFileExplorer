# DropboxFileExplorer

This is simple Android - showcase. The application is a File Explorer system and allows the user to login with its own Dropbox account. When the user is logged in, he will be driven into a list screen where he can vizualize and navigate the list of the files. 

## Clean Architecture 

The use of clean architecture may seem over-complicated for this sample project. However, this allows us to keep the amount of boilerplate code to a minimum and also demonstrate the approach in a simpler form. This sample follows SOLID principles, keeping the code as a cleaner as possible. 

<img src="https://github.com/ingjuanocampo/DropboxFileExplorer/blob/master/dependencyDesign.png" 
alt="Drawing" style="width: 5px;"/>

# Modules 

This is constructed using modules in Android, which helps a lot in the structuration and uncoupling of the layers. 

<img src="https://github.com/ingjuanocampo/DropboxFileExplorer/blob/master/modules_image.png" 
alt="Drawing" style="width: 5px;"/>

#### App 
App module integrates all modules, it is the main Android Project and only contains all files related to Activities, Fragments, and Adapters. It also is in charge to resolve the dependencies of the project by creating the Main Dagger component. 
Dependecies: Presentation, Domain, Data, Cache, Remote 

#### Presentation 
Presentation is an Android Module, which is in charge of coordinate the view and model. Using an MVP presentation pattern it holds the contracts with the view and model. 
Dependencies: Domain 

#### Domain 
Domain is a Kotlin Module and it is designed to hold off the CORE-features of the app. This is only a logic module and should always be a Kotlin Module. This module has no dependency on other modules. Also, Domain creates contracts (Repository contracts) that should be implemented in the Data layer to full fill the requirement of the features. 
Dependency: Nothing 

#### Data 
Data is Kotlin Module that implements the contracts specified in the domain layer. With the contract, Data should coordinate all the data sources and uncouple the domain from the data layer. This module creates contracts for RemoteDataSource and LocalDataSources. 
Dependency: Domain 

#### Chache 
This is a simple Kotlin module that allows us to keep in memory the cached information, for now, this DONT write any in persistency, however as this is an external module it can be modified easily. 
Dependency: Data

#### Remote(file_explorer_sdk)
Android Module that integrates the external SDK, in this case, the Dropbox SDK. This allows the app to do authentication and fetch of file from Dropbox
Dependency: Data

## Languages, libraries and tools used

* [Kotlin](https://kotlinlang.org/)
* [AndroidX](https://developer.android.com/jetpack/androidx)
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Dagger 2 (2.11)](https://github.com/google/dagger)
* [DropboxSdk](https://blogs.dropbox.com/developers)
* [Gson](https://github.com/google/gson)
* [Picasso](https://square.github.io/picasso/)
