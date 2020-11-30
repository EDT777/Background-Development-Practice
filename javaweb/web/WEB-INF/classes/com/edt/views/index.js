
//普通函数定义
function doWork(username){
    console.log(username);
    return username;
}
// 匿名函数 需要作为一个值给一个变量
var add = function(a,b){
    console.log(a+b);
}
//定义一个函数来接收另一个函数,然后再当前函数中来调用传入的函数
function fun2(fun1){
    fun1(1,5);
}

fun2(add);
doWork(1,2,3);
add(1,3);







//&& 与 || 用法
console.log("&&:从左往右依次判断,返回第一个 为false的值,否则返回最后一个 为true的值");
console.log("|| :从左往右判断,返回第一个 为true的值,否则返回最后一个false的值");
console.log(true&&true);  //true
console.log(1 && true); //true
console.log(1 && 2); //2
console.log("A"&&2); //2
console.log(""&& 2); //空字符串
console.log(null && "8"); //null
console.log("A"&& "B");//B
console.log(1&&2&&3); //3

console.log("=========");
console.log(true || true); //true
console.log(1 ||true); //1
console.log(1||2); //1
console.log("A"||2);//A
console.log(""||2);//2
console.log(null || "8");//8
console.log("A" || "B");//A
console.log(1||2|| 3);//1
console.log(1 ||null ||3); //1
console.log("" || null || 0);//0