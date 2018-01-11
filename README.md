# Note: This is not the original Iconify project, but a fork that I have created with the intentions of updating the font packs that are most often used. The contents of this readme, as well as certain project assets have been modified to reflect the fact that this is not the original project. You can find the original Iconify project by Joan Zapata [here](https://github.com/joanzapata/android-iconify). All project namespaces/ usage will remain the same for the foreseeable future. Thank you so much to Joan Zapata for all of his hard work on this incredible project!

# Update - 01/11/2018 - Fontawesome v4.7 is supported and a Snapshot has been deployed to sonatype. You can use this Snapshot by adding the following gradle dependencies:

In your top level gradle project file:
```
allprojects {
    repositories {
        mavenCentral()
        maven {
            url 'https://oss.sonatype.org/content/repositories/snapshots'
        }
    }
}
```
And in your application gradle file, add specific dependencies e.g.
```
dependencies {
    compile 'com.blackboardtheory:android-iconify-fontawesome:3.0.1-SNAPSHOT'
}
```

<img src="graphics/logo.jpg" height="154" align="center">

[<img src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" width="121">](https://play.google.com/store/apps/details?id=com.joanzapata.android.icons.sample)

**Iconify** offers you a **huge collection of vector icons** to choose from, and an intuitive way to **add and customize them in your Android app**. It has been introduced in [**this blog post**](http://blog.joanzapata.com/iconify-just-got-a-lot-better/) which is a good place to get started. 

-----

### Install

Pick any number of modules and declare them in your `Application`.

```gradle
dependencies {
    compile 'com.blackboardtheory:android-iconify-fontawesome:3.0.1-SNAPSHOT' // (v4.7; updated by bdevereaux on 01/10/2018)
    compile 'com.blackboardtheory:android-iconify-entypo:3.0.1-SNAPSHOT' // (v3,2015)
    compile 'com.blackboardtheory:android-iconify-typicons:3.0.1-SNAPSHOT' // (v2.0.7)
    compile 'com.blackboardtheory:android-iconify-material:3.0.1-SNAPSHOT' // (v2.0.0)
    compile 'com.blackboardtheory:android-iconify-material-community:3.0.1-SNAPSHOT' // (v1.4.57)
    compile 'com.blackboardtheory:android-iconify-meteocons:3.0.1-SNAPSHOT' // (latest)
    compile 'com.blackboardtheory:android-iconify-weathericons:3.0.1-SNAPSHOT' // (v2.0)
    compile 'com.blackboardtheory:android-iconify-simplelineicons:3.0.1-SNAPSHOT' // (v1.0.0)
    compile 'com.blackboardtheory:android-iconify-ionicons:3.0.1-SNAPSHOT' // (v2.0.1)
}
```

```java
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify
            .with(new FontAwesomeModule())
            .with(new EntypoModule())
            .with(new TypiconsModule())
            .with(new MaterialModule())
            .with(new MaterialCommunityModule())
            .with(new MeteoconsModule())
            .with(new WeathericonsModule())
            .with(new SimpleLineIconsModule())
            .with(new IoniconsModule());
    }
}
```

### Show icons in text widgets

If you need to put an icon on a ```TextView``` or a ```Button```, use the ```{ }``` syntax. The icons act exactly like the text, so you can apply shadow, size and color on them!

```xml
<com.joanzapata.iconify.widget.IconTextView
    android:text="I {fa-heart-o} to {fa-code} on {fa-android}"
    android:shadowColor="#22000000"
    android:shadowDx="3"
    android:shadowDy="3"
    android:shadowRadius="1"
    android:textSize="40sp"
    android:textColor="#FF..."
    ... />
```

<img src="graphics/androids.png" height="347">

### Icon options

* Shall you need to override the text size of a particular icon, the following syntax is supported `{fa-code 12px}`, `{fa-code 12dp}`, `{fa-code 12sp}`, `{fa-code @dimen/my_text_size}`, and also `{fa-code 120%}`.
* In the same way you can override the icon color using `{fa-code #RRGGBB}`, `{fa-code #AARRGGBB}`, or `{fa-code @color/my_color}`.
* You can even easily spin an icon like so `{fa-cog spin}`.

<img src="graphics/spinning.gif" height="37">

### Show an icon where you need a `Drawable`

If you need an icon in an ```ImageView``` or in your ```ActionBar``` menu item, then you should use ```IconDrawable```. Again, icons are infinitely scalable and will never get fuzzy!

```java
// Set an icon in the ActionBar
menu.findItem(R.id.share).setIcon(
   new IconDrawable(this, FontAwesomeIcons.fa_share)
   .colorRes(R.color.ab_icon)
   .actionBarSize());
```

## Extensibility

In case you can't find the icon you want, you can extend the available icon directly from your app. All you need to do is to implement `IconFontDescriptor` with a `.ttf` file in your assets and provide the mapping between keys and special characters, then give it to `Iconify.with()`. You can use the  [FontAwesomeModule](https://github.com/bdevereaux/android-iconify/blob/master/android-iconify-fontawesome/src/main/java/com/joanzapata/iconify/fonts/FontAwesomeModule.java) as an example.

There are no constraints on the icon keys, but I strongly suggest you use a unique prefix like `my-` or anything, to avoid conflicts with other modules. FYI, if there **is** a conflict, the first module declared with `Iconify.with()` has priority.

The only dependency you need if you want to use a custom icon is Iconify core.

```gradle
compile 'com.blackboardtheory:android-iconify:3.0.1-SNAPSHOT'
```

-----

# Thank You very much to the original contributors to this project!

## Contributions

* Joan Zapata [@JoanZapata](https://github.com/JoanZapata)
* Damien Villeneuve [@DayS](https://github.com/DayS)
* Mike Penz [@mikepenz](https://github.com/mikepenz)

## License

```
Copyright 2018 Brandon Devereaux

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

It uses FontAwesome font by Dave Gandy, licensed under OFL 1.1, which is compatible
with this library's license.

    http://scripts.sil.org/cms/scripts/render_download.php?format=file&media_id=OFL_plaintext&filename=OFL.txt
    
```
