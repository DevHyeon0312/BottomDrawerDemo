### ⭐️ give me strength. :)

# What is BottomDrawer?
- "BottomDrawer" is a library that uses Coordinator Layout and BottomSheet to insert custom Fragment only for easier use.
- "BottomDrawer" 는 CoordinatorLayout 과 BottomSheet 를 이용하여, Fragment만을 삽입하여 더욱 쉽게 사용할 수 있도록 만든 라이브러리 입니다.
---

### Try using it easily now and let me know the issue.
### 사용해보시고, 이슈 or 요청사항이 있다면 알려주세요


---
# Demo App
<img src= "https://user-images.githubusercontent.com/72678200/115966275-c299b580-a567-11eb-9911-98c33910131a.gif" width="30%" height="30%"> <img src= "https://user-images.githubusercontent.com/72678200/115966278-cd544a80-a567-11eb-9f64-1596b2415dbd.gif" width="30%" height="30%"> <img src= "https://user-images.githubusercontent.com/72678200/115966280-ce857780-a567-11eb-85c1-26ab994a6ca5.gif" width="30%" height="30%">
<img src= "https://user-images.githubusercontent.com/72678200/115966282-cf1e0e00-a567-11eb-9bdc-1010fb4f2b17.gif" width="30%" height="30%"> <img src= "https://user-images.githubusercontent.com/72678200/115966283-cfb6a480-a567-11eb-87f6-288b2ee1613c.gif" width="30%" height="30%">

<img src= "https://user-images.githubusercontent.com/72678200/115983253-15f91b80-a5db-11eb-9d1a-1366392442fc.gif"> <img src= "https://user-images.githubusercontent.com/72678200/115983254-172a4880-a5db-11eb-9df5-1897de102f1a.gif">

---
# Setup
- Add in your root build.gradle at the end of repositories
```
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
```
    implementation 'com.github.kr-OL:BottomDrawer:1.1.0'
```

# Use

### 1. Create Fragment (If you don't have experience in creating a fragment, check the demo project.)

### 2. YourActivity.xml
```
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

### 3. If you want a callback
```
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

STATE_COLLAPSED : BottomSheet가 축소되었음 (peek 높이만큼은 보여짐)
STATE_EXPANDED : BottomSheet가 최대 높이까지 완전히 확장되고 BottomSheet의 모든 내용이 표시됨
STATE_DRAGGING : BottomSheet가 위쪽 또는 아래쪽 방향으로 끌고 있음
STATE_SETTLING : BottomSheet가 최대 높이 또는 peek 높이로 정착 중
STATE_HIDDEN : BottomSheet가 숨겨져 있음

BasicBottomSheet
        .Begin(activity = this@MainActivity)
        .hide(false)
        .peekHeight(60)
        .addTitle(titleFragment)
        .addContents(bodyFragment)
        .addCallBack(callback)
        .commit()
```
### 3. If you don't want a callback
```
BasicBottomSheet
        .Begin(activity = this@MainActivity)
        .hide(false)
        .peekHeight(60)
        .addTitle(titleFragment)
        .addContents(bodyFragment)
        .commit()
        
```

### 3. If you hidden start
```
BasicBottomSheet
        .Begin(activity = this@MainActivity)
        .hide(false)
        .peekHeight(60)
        .addTitle(titleFragment)
        .addContents(bodyFragment)
        .hidden(true)   // Must with hide(true)
        .commit()
        
```

# Description

<img src="https://user-images.githubusercontent.com/72678200/115965083-684a2600-a562-11eb-9f6f-c8bfebf65eb5.png"  width="80%" height="80%">

- a. Begin(activity)                  : begin
- b. hide(boolean)                    : If you type true, you cannot return the fragment if it disappears from the screen.
- c. peekHeight(int)                  : Sets the height shown on the screen without being hidden (if the height is 30dp, enter 30).
- d. addTitle(fragment)               : Generally, this is a fragment that corresponds to the title you want to show at the top.
- e. addContents(fragment)            : Fragment corresponding to contents that are usually hidden and appear.
- f. titleMargin(int,int,int,int)     : If you want to apply the margin to the title fragment, pass dp in order (left, top, right, bottom). (30 dp = 30 delivered)
- g. contentsMargin(int,int,int,int)  : If you want to apply the margin to the contents fragment, pass the dp in order (left, top, right, bottom). (30 dp = 30 delivered)
- h. commit()                         : commit

---

- a. Begin(activity)                  : 준비
- b. hide(boolean)                    : true 로 설정하면, fragment 가 화면에서 사라진경우 (바닥으로 슝슝) 되돌릴 수 없습니다.
- c. peekHeight(int)                  : 숨겨지지 않고 화면에 보여지는 높이를 설정합니다 (만약 높이가 30dp 라면, 30 을 입력하세요.)
- d. addTitle(fragment)               : 일반적으로 상단에 보여주고 싶은 title 에 해당하는 fragment 입니다.
- e. addContents(fragment)            : 일반적으로 가려져있다가 나타나는 contents 에 해당하는 fragment 입니다.
- f. titleMargin(int,int,int,int)     : title fragment 에 마진을 적용하고 싶다면 (left, top, right, bottom ) 순으로 dp 를 전달하세요. (30dp = 30 전달)
- g. contentsMargin(int,int,int,int)  : contetns fragment 에 마진을 적용하고 싶다면 (left, top, right, bottom ) 순으로 dp 를 전달하세요. (30dp = 30 전달)
- h. commit()                         : 적용

---

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
