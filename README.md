# Request
## 说明
在任何地方实现startActivityForResult->onActivityResult
## 使用
### 依赖
```
implementation 'com.shouzhong:Request:1.0.0'
```
### 代码
```
Intent intent = new Intent(this, SecondActivity.class);
intent.putExtra("data", "aabbcc");
new Request().with(activity).setIntent(intent).setCallback(new Callback() {
    @Override
    public void call(int resultCode, Intent data) {

    }
}).start();
```