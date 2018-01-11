# Migration from the original [Iconify Project](https://github.com/joanzapata/android-iconify) 2.X.X to 3.x.x

Iconify 3.X.X introduces some key changes from the 2.x.x version of Iconify maintained by [Joan Zapata](https://github.com/joanzapata)

*Mininum SDK version is now 14
*Gradle distribution upgraded to 4.1
*Build tools upgraded to 27.0.3
*Android Studio 3.0+ support
*Java upgraded from 1.6 to 1.8

**In build file**

- `compile 'com.joanzapata.iconify:android-iconify-fontawesome:2.X.X'` -> `compile 'com.blackboardtheory:android-iconify-fontawesome:3.0.1-SNAPSHOT'`

**In layouts**

- No layout/ widget changes! Use layout components as you did previously with `com.joanzapata.iconify.widget...`

**In code**

- No namespace changes! Import components as you did previously with `com.joanzapata.iconify...`
