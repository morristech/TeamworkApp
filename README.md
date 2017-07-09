# TeamworkApp
An Open Source teamwork Quick tasks app, to allow users easily Create Tasks, Edit Tasks and List Tasks.

-  Uses Teamwork API https://developer.teamwork.com/api
-  Clean, Simple and Minimalist design
-  Follows MVP architectural pattern
-  Uses Dagger2 for DI
-  Rxjava and Retrofit for Network calls
-  Use Gradle to build, jCenter/Maven Central for dependencies (no .jar dependencies)

## For usage and test purpose, please change the URL in Api Class


```
public class Api {

    // Change this URL to your own URL and Build the project
    public static final String BASE_URL = "https://tosinmath.teamwork.com/";

}
```

## Functionalities in this App

-  List Task ( Displays task content and description,  displays details when click on an item )
-  You can Create Task ( Set Project, Set TaskList, Set Start Date, Set Due Date, Set Progress )
-  You can Edit Task ( Set Project, Set TaskList, Set Start Date, Set Due Date, Set Progress )