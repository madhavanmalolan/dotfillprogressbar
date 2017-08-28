# dotfillprogressbar

 [ ![Download](https://api.bintray.com/packages/madhavanmalolan/android/dotfillprogress/images/download.svg) ](https://bintray.com/madhavanmalolan/android/dotfillprogress/_latestVersion) 

A simple progressbar for everyday use :)
Easy to customize!

![screenshot](https://github.com/madhavanmalolan/dotfillprogressbar/blob/master/screenshot.png "Screenshot of demo")

## Gradle Build

Project level build.gradle

```
allprojects {
	repositories {
		...
		maven { url 'http://dl.bintray.com/madhavanmalolan/android' }
	}
}

```

App level build.gradle

```
    compile 'com.madhavanmalolan.android:dotfillprogress:0.1.1'

```

## Usage

### XML

```
    <com.madhavanmalolan.dotfillprogress.DotFillProgressbar
        android:id="@+id/test"
        indicator:circleBorderWidth="1dp"
        indicator:circles="10"
        indicator:circleRadius="5dp"
        indicator:circleSpacing="15dp"
        indicator:circleBorderColor="#ff0000"
        indicator:circleFillColor="#00ff00"
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


### Java

```java
        dotProgressIndicator = (DotFillProgressbar) findViewById(R.id.test);
	dotProgressIndicator.setCircles(10, 0); //setCircles(totalNumberOfCircles, numberOfFilledCircles)
        dotProgressIndicator.setFilled(3);
```

### License
This project is bound by the MIT license. Feel free to use it and not tell others about it! Please be nice, and do tell others though :)
