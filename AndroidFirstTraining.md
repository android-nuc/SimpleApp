# Android 第一次培训

## Android Studio 常用快捷键介绍

 + ctrl + alt + L : 格式化代码
 + ctrl + d : 复制一整行到下一行
 + alt + enter : 错误提示
 + alt + 鼠标左键 : 选中一个区域
 + ctrl + alt + m : 为选中的一个区域创建方法
 + shift + F6 : 重命名，可以全局替换变量名，方法名，文件名等
 + shift + shift ：双击 shift 可以全局查找文件，包括 sdk 或者第三方库文件
 + ctrl + F12 : 可以查看当前文件结构，可以搜索方法名并跳转到对应的方法

## 常用控件及属性介绍

### View

即我们常说的控件，View 是所有控件的父类

+ `android:layout_width`  ：设置 View 的宽度 （必须）
  +  `match_parent`
  +  `wrap_content`
+ `android:layout_height`  ：设置 View 的高度 （必须）
  + `match_parent`
  + `wrap_content`
+ `android:id`  ：设置 View 的 id ，在同一个布局文件中应该是唯一的 
  + `@+id/name` 当创建一个新的 id 时使用
  + `@id/name` 使用当前文件已存在的 view 时使用
+ `android:layout_margin` ：设置 View 的外边距，通俗的说就是当前控件与周围的控件和父布局的距离
+ `android:padding` ：这个 View 的内边距，通俗的说就是当前控件与自身内容的距离
+ `android:background` 设置 view 的背景
+ `android:layout_gravity` ：这个 view 在当前布局的位置，该属性跟布局有关
+ `android:gravity` 设置 view 的内容的位置

### ViewGroup

可以理解为我们常说的布局的父类，比如后面会提到的 `LinearLayout`（线性布局）、`RelativeLayout` （相对布局）等布局，同时 ViewGroup 的父类是 View 

所以，对 ViewGroup 来说，View 有的属性，它也有，比如 `layout_width`、`layout_height`、`id` 等

### TextView

> 用于显示文字信息

+ `android:text ` ：需要显示的文字
+ `android:textSize` ：文字大小
+ `android:textColor` ： 字体颜色
+ `android:textStyle` ：文字的样式
  +  `normal` 默认
  +  `bold` 加粗
  +  `italic` 斜体
+ ... ...

```xml
 <TextView
        android:id="@+id/text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:textColor="#336699"
        android:textSize="16sp"
        android:textStyle="bold"/>
```



### Button

> 按钮，其直接父类是 TextView， 所以 TextView 有的属性它也能使用

```xml
<Button
    android:id="@+id/button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:background="#336699"
    android:text="click"/>
```



### EditText

>  输入框，其直接父类也是 TextView。

+ `android:hint` 输入框的提示信息
+ `android:inputType` 输入类型

```xml
<EditText
        android:id="@+id/edit_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Input what you want"
        android:inputType="text"/>
```



### ImageView

> 显示图片

+ `android:src` 设置图片资源
+ `android:scaleType` 图片规模类型

这里需要注意 src 与 background 的区别

+ 两者都能显示图片，但是 src 是显示前景图片，background 是背景图片，如果两个都设置图片资源，前者会把后者覆盖
+ `scaleType` 只对 src 起作用，对 background 没用

```xml
 <ImageView
        android:id="@+id/image_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:scaleType="center"
        android:src="@drawable/ic_launcher_background"/>
```



### LinearLayout

> 线性布局，可以设置为水平线性还是垂直线性

+ `android:orientation` ：设置线性方向
  + `horizontal` 水平 （默认）
  + `vertical` 垂直

```xml
 <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

    </LinearLayout>
```



### RelativeLayout

> 相对布局

在 RelativeLayout 中的控件有以下属性

+ `android:layout_alignParentLeft` 
+ `android:layout_alignParentTop`
+ `android:layout_alignParentRight`
+ `android:layout_alignParentBottom`
+ `android:layout_centerInParent`

以上属性，接收的参数为 boolean 值。分别表示当前控件在整个 RelativeLayout 的左边、上边、右边、下边、中心

```xml
<RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent">
				
  			<Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_alignParentBottom="true"
                    android:layout_alignParentLeft="true"/>
              <!-- Button 在整个布局的左下位置 -->
                
</RelativeLayout>
```



+  `android:layout_above`
+  `android:layout_below`
+  `android:layout_toRightOf`
+  `android:layout_toLeftOf`

以上属性，接收的参数为空间 id (i.e. `@id/button`)，假设有一个控件 id 为 button，如果对以上属性传入该 id ，那么分别表示当前控件在 id 为 button 的控件的 上面、下面、右边、左边

```xml
<!-- 有一个 button -->
<Button 
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

<TextView
          android:id="@+id/text_view"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_above="@id/button"
          android:layout_toLeftOf="@id/button"/>
<!-- TextView 现在在 Button 的左上 -->
```

... ...



## 常用的消息提示的几种方式

### 使用 Toast

> 一般用于短小信息的提示，一定时间后会自动消失，使用方便

```java
Toast.make(MainActivity.this, "Hello World", Toast.LENGTH_SHORT).show();
```

接收三个参数

+ 上下文 Context，一般就是当前类的实例
+ 字符串或者字符串资源 id
+ 显示时长，由两个参数可选
  + Toast.LENGTH_LONG    长时间
  + Toast.LENGTH_SHORT   短时间

注意只有调用 show() 方法才能显示 toast



### 使用 AlertDialog

> AlertDialog 会弹出一个对话框，上面会有自己设置的信息

```java
AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
dialog.setTitle("This is title.");		// 设置标题
dialog.setMessage("Somethis.");			// 设置显示信息
// 用户点击 ok 按钮后会调用
dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
  @Override
  public void onClick(DialogInterface dialogInterface, int i) {
    // if ok, you will do ...
  }
});
// 用户点击 Cancel 按钮后会调用
dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
  @Override
  public void onClick(DialogInterface dialogInterface, int i) {
    // if you cancel this dialog, you will do ...
  }
});
// 显示 dialog
dialog.show();
```



## 页面跳转及数据传递

在两个 Activity 中使用  `Intent` 来传递数据

e.g. 从 FirstActivity 跳转到 SecondActivity

```java
Intent intent = new Intent(FirstActivity.this, SecondActivty.class); // 初始化intent
intent.putExtra("Key", "Value");	// 以键值对的形式传参
startActivity(intent);				// Activity 跳转，从 FirstActivity 跳转到 SecondActivity
```

1. 此时 intent 相当于连接两个 Activity 的桥梁，所以在**页面间跳转传递数据时**创建 intent 需要传入当前 Activity 的上下文和要跳转的 Activity 的类对象。
2. intent 保存要传递的参数是以键值对的形式保存的，其中键是 String 类型的，值可以是 基本类型，String，Serializable 的子类，Parcelable 的子类（具体请查看方法签名）
3. 活动的跳转有两个方法：startActivity(intent) 和 startActivityForResult(intent, requestCode)
   + startActivity(intent) 就是普通的跳转
   + startActivityForResult(intent, requestCode) 如果需要拿到 SecondActivity 回传的数据那么需要调用该方法，并在 `protected void onActivityResult(int requestCode, int resultCode, Intent data) ` 方法中处理回传数据




## 配置文件 AndroidManifest

> 配置文件

+ 给四大组件（Activity、Service、Content Provider、Broadcast Receiver) 申明
+ 申请权限