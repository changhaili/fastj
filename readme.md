# Fastj���ݶ�����

Fastj����Javaʵ�ֵĽű����ԣ��﷨�����Java��Python������������Ϊ��̬���͡�

## ����

class V {
	
	v=20;
	
	def this(){ // Ĭ�Ϲ��캯��
		v=32;
	}
	
	def setValue(newV){
	    v = newValue;
	}
	
	def + (o){	// ���������+
		
		return v+o;
	}	
}

println( new V() + 4);  // ��� 36


## �﷨
### �ؼ���

var: ��������

boolean��byte��char��short��int��long��float��double�� �������ͣ���Javaһ��

string��java.lang.String�ı���
object��java.lang.Object�ı���

instanceof �� ͬjava��instanceof

class: �����࣬���ȡ���class����

def�����庯��
return�� ��������ֵ��ͬjava
synchronized: ͬJava


import�� ���������
include�� ��������fastjԴ�ļ�������ִ��

this�� ������������ã� ���캯������
null��true��false�� ͬJava
super�����������
new����������ͬJava
delete�� ɾ���������壬���ڿ��ܻ�ɾ��
defined���жϱ����Ƿ���

try��catch��throw��finally�� ͬjava���쳣
assert�� ͬjava assert���ùؼ���һֱ��Ч

if��else��ͬJava
for�� ͬjava
while: ͬJava
do�� ͬJava
switch�� case �� ͬJava
default�� switch��default�飬 default(int) �� ���͵�Ĭ��ֵ
break�� continue�� ͬJava, ��Ŀǰ�����������ǰѭ����switch 
as: ����ת���� ��Java����ת���ǵ���ConvertUtils.convertʵ��

##### fastj�����˴���Java��C++���������ԵĹؼ���
������Щ���д�ʵ�֣�����ؼ���Ŀǰû��ʵ�ֵļƻ�

auto��static��external��volatile��register��asm��transient

unsigned
decimal��strictfp
enum��struct��lambda��delegate
extends��implements
override��native��yield


public��protected��private��internal
virtual��abstract
final��const��ref��out��in

using��package��namespace

define

goto��elif��foreach
alias��global


### ��������
�������ͣ� ͬJava�� ֧��boolean, byte, char, short, int, long, float, double
�����ֻ����������װ����

��java.lang.String����Ϊstring, java.lang.Object����Ϊobject

֧�����е�Java�ࡢ�ӿڼ�ö�����ͣ� ��Ĭ�ϵ���java.util�� java.lang��



### �����

FastJ���������ͬjavaһ�£��У�

+��-��*��/��%

++�� --

~�� &��|��^

<<��>>��>>>


==��!=

!�� &&��||

>��>=��<<=


** �� �������

===�� ֵ�������java������� .equals����

!==:  ֵ�����

~= �� ������ʽ����ֵ�� ʹ�÷�ʽ��  expression ~= regex

?? :  �ջ������  var v = a ?? 10,  ��a û�ж����ֵΪnullʱv��ֵΪ10������ֵa

. �� �������

, �� ���������

?: �� ���������

[] : ��������������

() : ���������

{} �� ���map�����

�� �� �ֺ�����������ڱ��ʽ����

=  �� ��ֵ�����


#### һЩ������Ԫ�����֧�ָ�ֵ����

+=�� -=�� *=�� /=�� %=�� **=�� &=�� |=�� ^=�� <<=�� >>=�� >>>=

### ע��

��Javaһ���� ֧�� /*  */ ���ע�� �� // ���ע��

### ����
var varName = xxxx , ����һ��������ΪvarName�ı���, ����var�ؼ��ֿ���ʡ��

Fastj֧��ȫ�ֱ������ֲ���������Ա����

### ���

����ԣ�����

#### ��ֵ
var name=... ;

name = ... ;

#### {}
�����

#### if ... else .... 
ͬjava

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

### ����
Fastj֧��ȫ�ֺ�������Ա����

#### ��������
def functionName(arg1, arg2, arg3,.... argN)  {
    // function body
}

functionName: ������

arg1, arg2, arg3, ..., argN: �β�

functionBody : ������

��û�к�������ú���Ϊ���麯��
