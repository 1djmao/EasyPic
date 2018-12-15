# EasyPic
实现图片常用功能
## 导入
Add the JitPack repository to your build file
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency
```
dependencies {
	        implementation 'com.github.1djmao:EasyPic:1.0'
	}
```
## 多图片展示
支持左右滑动和放大缩小手势操作
```
ShowPics.show(Context context, List<String> list, int position)
```
