# Android Clearable EditText
Android library for logging only in debug mode.

[![Release](https://jitpack.io/v/jitpack/maven-simple.svg)](https://jitpack.io/#ashwindmk/Android-Clearable-EditText-Library)

Clearable EditText library allows you to display close icon at right end of your edittext, which helps to clear the user entered text.

### Setup

Add the jitpack.io repository in your project-level build.gradle file:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the following dependency in your app/build.gradle file:
```gradle
compile 'com.github.ashwindmk:Android-Clearable-EditText-Library:0.2'
```

### Usage

In your xml file:
```xml
<com.ashwin.clearableedittext.ClearableEditText
    android:id="@+id/clearableedittext"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    clearedit:hintText="Full Name"
    android:inputType="textPersonName"
    android:imeOptions="actionNext"
    android:maxLines="1"
    clearedit:whiteClearButton="false" />
```

In your activity or fragment:
```java
public class MainActivity extends AppCompatActivity {

    private ClearableEditText mClearableEditText;

    @Override
    public void onCreate() {
        super.onCreate();
        setContentView(R.layout.activity_main);

        mClearableEditText = (ClearableEditText) findViewById(R.id.clearableedittext);
        String str = mClearableEditText.getText();
    }
}
```
