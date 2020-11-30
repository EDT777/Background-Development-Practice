//数组的使用
//直接new的方法去得到一个数组对象
var arr = new Array();
console.log(typeof arr);
// 声明直接给数组赋值
var arr2 = new Array("陈冠希","吴亦凡","迪丽热巴");
console.log(arr2);
//创建长度
var arrr =new Array(3);
arrr[0]="呀呀呀";
arrr[5]="哈哈哈"; //不会越界,因为不是定长的
console.log(arrr);
console.log(arrr[5]);
//简写
var arr3 =["A","B","C"];

console.log(arr3.join(","));
arr3.reverse();//翻转
arr3.splice(1,1);
console.log(arr3.length)
console.log(arr3);
console.log("======================遍历数组=========================");
// 遍历数组
var a = ["1",'2',"3","4"];
//1.使用for
for (var i=0;i<a.length;i++){
    console.log(a[i]);
}
console.log("===========");
//2 使用forEach来遍历数组
a.forEach(function (ele,index,arr){
    console.log(ele,index);
}
);
console.log("=============");
//3 使用map 来遍历数组
var newArr =a.map(function (ele,index,arr) {
    return index + ":" +ele;
});
console.log(newArr);
console.log("===for-in获取下标====");
//4 使用for-in 来遍历数组
for (var i in a){
    console.log(a[i]);
}
console.log("====for-of====");
// for-of
for (var elee of a){
    console.log(elee);
}
console.log("===for in 来获取对象的属性名====")
//使用for in 来获取对象的属性名
var obj = new Object();
obj.username ="小狼";
obj.age = 18;

for (var name in obj){
    console.log(name);
}
console.log("==========")
