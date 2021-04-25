
![Version](https://img.shields.io/badge/LastVersion-1.1.0-blue) [![LibSource Badge](https://img.shields.io/badge/LibSource-BottomSheet-brightgreen)](https://github.com/kr-OL/BottomDrawer) [![Blog Badge](https://img.shields.io/badge/ExampleGuide(KR)-Blog-brightgreen)](https://devhyeon0312.tistory.com/10)

# Android BottomDrawer
BottomDrawer helps you customize bottom sheets easily.
Simply create and insert a Fragment into the supplied Frame.
The minsdk in this library is set to 21.

---

<img src= "https://user-images.githubusercontent.com/72678200/115966275-c299b580-a567-11eb-9911-98c33910131a.gif" width="30%" height="30%"> <img src= "https://user-images.githubusercontent.com/72678200/115983253-15f91b80-a5db-11eb-9d1a-1366392442fc.gif"> <img src= "https://user-images.githubusercontent.com/72678200/115983254-172a4880-a5db-11eb-9df5-1897de102f1a.gif">

---

# Installation

- Add in your root build.gradle at the end of repositories
```java
allprojects {
    repositories {
        google()
        jcenter()
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

- Add the dpendency
```java
    implementation 'com.github.kr-OL:BottomDrawer:1.1.0'
```

#### Java
```java
TitleFragment titleFragment = new TitleFragment();
BodyFragment bodyFragment = new BodyFragment();

new BasicBottomSheet.Begin(this)
        .hide(false)
        .peekHeight(60)
        .addTitle(titleFragment)
        .addContents(bodyFragment)
        .commit();
```
#### Kotlin
```
val titleFragment = TitleFragment()
val bodyFragment = BodyFragment()

BasicBottomSheet
        .Begin(this@BasicActivity)
        .hide(false)
        .peekHeight(60)
        .addTitle(titleFragment)
        .addContents(bodyFragment)
        .addCallBack(callback)
        .commit()
```

---

# Note
#### BottomDrawer uses Coordinator Layout. so, Activity.xml you want to use should be filled out as below.
```html
<?xml version="1.0" encoding="utf-8"?>
<androidx.coordinatorlayout.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#d8d8d8"
    tools:viewBindingIgnore="false">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Activity"
            android:textSize="24sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
    </androidx.constraintlayout.widget.ConstraintLayout>

    <include layout="@layout/layout_basic_bottom_sheet" />

</androidx.coordinatorlayout.widget.CoordinatorLayout>
```
#### BottomDrawer uses BottomShee. Therefore, to register Callback, you must create it as below.
java
```java
BottomSheetBehavior.BottomSheetCallback callback = (new BottomSheetBehavior.BottomSheetCallback() {
    @Override
    public void onSlide(@NonNull View bottomSheet, float slideOffset) {

    }

    @Override
    public void onStateChanged(@NonNull View bottomSheet, int newState) {
        switch (newState) {
            case BottomSheetBehavior.STATE_COLLAPSED : {}
            case BottomSheetBehavior.STATE_EXPANDED : {}
            case BottomSheetBehavior.STATE_DRAGGING : {}
            case BottomSheetBehavior.STATE_SETTLING : {}
            case BottomSheetBehavior.STATE_HIDDEN : {}
            default: {}
        }
    }
});
```
kotlin
```kotlin
val callback = (object : BottomSheetBehavior.BottomSheetCallback() {
    override fun onSlide(bottomSheet: View, slideOffset: Float) {
    }

    override fun onStateChanged(bottomSheet: View, newState: Int) {
        when (newState) {
            BottomSheetBehavior.STATE_COLLAPSED -> {}
            BottomSheetBehavior.STATE_EXPANDED -> {}
            BottomSheetBehavior.STATE_DRAGGING -> {}
            BottomSheetBehavior.STATE_SETTLING -> {}
            BottomSheetBehavior.STATE_HIDDEN -> {}
            else -> {}
        }
    }
})
```
# BottomSheet State
#### 1️⃣ STATE_COLLAPSED  
This state indicates that the BottomSheet is collapsed.
    
#### 2️⃣ STATE_EXPANDED  
This state indicates that the BottomSheet is fully expanded to its maximum height and all the content of the BottomSheet is visible.
    
#### 3️⃣ STATE_DRAGGING  
This state indicates that the BottomSheet is dragging either in the upward direction or in the downward direction.
    
#### 4️⃣ STATE_SETTLING  
This state indicates that the BottomSheet is settling either to the max height or to the peek height.
    
#### 5️⃣ STATE_HIDDEN  
This state indicates that the BottomSheet is hidden


# Builder Methods 
### 🔴 Must 🟠 Sometimes Fource 🟢 Select

🔴 Begin(activity). 
begin

#### 🟠 hide(boolean)  
If you type true, you cannot return the fragment if it disappears from the screen.

#### 🟢 peekHeight(int)  
Sets the height shown on the screen without being hidden (if the height is 30dp, enter 30).

#### 🟢 addTitle(fragment)  
Generally, this is a fragment that corresponds to the title you want to show at the top.

#### 🟢 addContents(fragment)  
Fragment corresponding to contents that are usually hidden and appear.

#### 🟢 titleMargin(int,int,int,int)  
If you want to apply the margin to the title fragment, pass dp in order (left, top, right, bottom). (30 dp = 30 delivered)

#### 🟢 contentsMargin(int,int,int,int)  
If you want to apply the margin to the contents fragment, pass the dp in order (left, top, right, bottom). (30 dp = 30 delivered)

#### 🟢 addCallback(callback)  

#### 🟢 hidden(isHidden)  

#### 🔴 commit()  
commit


# License
```
Copyright 2021 DevHyeon

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
