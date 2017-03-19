# Fastj（暂定名）

Fastj是用Java实现的脚本语言，语法本身仿Java和Python，但变量类型为动态类型。

## 例子

class V {
	
	v=20;
	
	def this(){ // 默认构造函数
		v=32;
	}
	
	def setValue(newV){
	    v = newValue;
	}
	
	def + (o){	// 重载运算符+
		
		return v+o;
	}	
}

println( new V() + 4);  // 输出 36


## 语法
### 关键字

var: 声明变量

boolean、byte、char、short、int、long、float、double： 基本类型，与Java一致

string：java.lang.String的别名
object：java.lang.Object的别名

instanceof ： 同java的instanceof

class: 定义类，或获取类的class对象

def：定义函数
return： 函数返回值，同java
synchronized: 同Java


import： 导入包或类
include： 包括其他fastj源文件并加载执行

this： 对象自身的引用， 构造函数名，
null、true、false： 同Java
super：父类的引用
new：创建对象，同Java
delete： 删除变量定义，后期可能会删除
defined：判断变量是否定义

try，catch，throw，finally： 同java的异常
assert： 同java assert但该关键字一直有效

if，else：同Java
for： 同java
while: 同Java
do： 同Java
switch， case ： 同Java
default： switch的default块， default(int) ， 类型的默认值
break， continue： 同Java, 但目前跳出或结束当前循环或switch 
as: 类型转换， 对Java类型转换是调用ConvertUtils.convert实现

##### fastj保留了大量Java，C++或其他语言的关键字
其中有些是有待实现，更多关键字目前没有实现的计划

auto，static，external，volatile，register，asm，transient

unsigned
decimal，strictfp
enum，struct，lambda，delegate
extends，implements
override，native，yield


public，protected，private，internal
virtual，abstract
final，const，ref，out，in

using，package，namespace

define

goto，elif，foreach
alias，global


### 数据类型
基本类型， 同Java， 支持boolean, byte, char, short, int, long, float, double
不区分基本类型与包装类型

将java.lang.String别名为string, java.lang.Object别名为object

支持所有的Java类、接口及枚举类型， 并默认导入java.util， java.lang表



### 运算符

FastJ运算符大体同java一致，有：

+，-，*，/，%

++， --

~， &，|，^

<<，>>，>>>


==，!=

!， &&，||

>，>=，<<=


** ： 幂运算符

===： 值运算符，java对象访问 .equals函数

!==:  值运算符

~= ： 正则表达式运算值， 使用方式：  expression ~= regex

?? :  空或运算符  var v = a ?? 10,  当a 没有定义或值为null时v赋值为10，否则赋值a

. ： 点运算符

, ： 逗号运算符

?: ： 条件运算符

[] : 数组或索引运算符

() : （）运算符

{} ： 块或map运算符

； ： 分号运算符，用于表达式结束

=  ： 赋值运算符


#### 一些多数二元运算符支持赋值定义

+=， -=， *=， /=， %=， **=， &=， |=， ^=， <<=， >>=， >>>=

### 注释

和Java一样， 支持 /*  */ 风格注释 及 // 风格注释

### 变量
var varName = xxxx , 定义一个变量名为varName的变量, 其中var关键字可以省略

Fastj支持全局变量，局部变量，成员变量

### 语句

语句以；结束

#### 赋值
var name=... ;

name = ... ;

#### {}
代码块

#### if ... else .... 
同java

if( condition expression ) {     
    ....  
}  
else {  
    ....  
}  

#### while
while( condition express) {  
...  
}

#### do ... while
#### break
#### continue
#### for
#### try ... catch ... finally
#### throw

### 函数
Fastj支持全局函数，成员函数

#### 函数定义
def functionName(arg1, arg2, arg3,.... argN)  {
    // function body
}

functionName: 函数名

arg1, arg2, arg3, ..., argN: 形参

functionBody : 函数体

如没有函数，则该函数为纯虚函数
