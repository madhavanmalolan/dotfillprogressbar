# DotFillProgressbar

 [ ![Download](https://api.bintray.com/packages/madhavanmalolan/android/dotfillprogress/images/download.svg) ](https://bintray.com/madhavanmalolan/android/dotfillprogress/_latestVersion) 

A simple progressbar for everyday use :)
Easy to customize!

![screenshot](https://github.com/madhavanmalolan/dotfillprogressbar/blob/master/screenshot.png?raw=true "Screenshot of demo")
![screenshot](https://github.com/madhavanmalolan/dotfillprogressbar/blob/master/screenshot2.png?raw=true "Screenshot of demo")

## Gradle Build

Library available over `jcenter()`

App level build.gradle

```
    compile 'com.madhavanmalolan.android:dotfillprogress:0.1.4'

```

## Usage

### XML

```
    <com.madhavanmalolan.dotfillprogress.DotFillProgressbar
        android:id="@+id/test"
        app:circleBorderWidth="1dp"
        app:circles="10"
        app:circleRadius="5dp"
        app:circleSpacing="15dp"
        app:circleBorderColor="#ff0000"
        app:circleFillColor="#00ff00"
        app:locusRadius="50dp"
        android:layout_width="wrap_content"
        android:layout_height="64dp" />

```
Parameters
* circles : Number of circles to show. Required.
* circleBorderWidth : width of the stroke of the circle circumference
* circleRadius : radius of each of the circles
* circleSpacing : Space between the centers of adjacent circles. Used only when layout width is wrap content. 
* circleBorderColor : color of the stroke of the circle circumference
* circleFillColor : color of the circle filling
* locusRadius : define this field if you want the dots to be arranged on the circumference of a circle. Mention the radius of that circle here. If you ignore this field, the dots will be laid out in a straight line. Optional.


### Java

```java
        dotProgressIndicator = (DotFillProgressbar) findViewById(R.id.progress);
	dotProgressIndicator.setCircles(10, 0); //setCircles(totalNumberOfCircles, numberOfFilledCircles)
        dotProgressIndicator.setFilled(3);
```


## Production apps using this library
1. [Emotia](https://play.google.com/store/apps/details?id=com.socionity.socialcam "Download on Playstore")

## Contribute
Feel free to modify this (overly simple) library to suit your needs. PRs accepted!


## License
This project is bound by the MIT license. Feel free to use it and not tell others about it! Please be nice, and do tell others though :)
