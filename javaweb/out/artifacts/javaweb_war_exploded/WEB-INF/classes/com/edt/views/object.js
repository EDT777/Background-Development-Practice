//定义一个构造函数
function Person(username,age) {
        //定义属性
    this.username = username;
    this.age = age ;
    //定义行为(功能,方法
    this.sleep = function (time) {
            console.log("睡觉"+time);
    }
}

//使用构造函数来创建对象
var p =new Person("小明",18);
console.log(p,typeof p);
//操作对象的成员
console.log(p.username,p.age);
//给p对象的username设置数据
p.username = "小码";
p.age=19
console.log(p);

p.sleep(3);
//给对象新增新成员
p.oo ="xxx";
p.do = function () {
console.log("敲代码!!!!");
}