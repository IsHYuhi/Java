import java.lang.reflect.*;
import java.io.IOException;

class RunToTest{
  public static void main(String [] args)throws ClassNotFoundException, NoSuchMethodException{
    Class<?> test = Class.forName(args[0]);

    //Iterate through all methods in tested
    // and check if the annotation ToTest is present
    for(Method m : test.getMethods()){
      if(m.isAnnotationPresent(ToTest.class)){//annotationがついてるメソッドを実行
        //perform so tasks
        try{
          m.invoke(null);//このMethodオブジェクトによって表される基本となるメソッドを、指定したオブジェクトに対して指定したパラメータで呼び出します
          //可変長引数を 利用すると、呼び出すメソッドに引数が無い場合は、getMethodおよびinvokeの第2引数以降を指定する必要が無い。
          //staticメソッドを呼び出す場合、invokeの第1引数にはnullを指定する。
          System.out.println(m.getName()+"  success ");
        }catch(Throwable ex){
          System.out.println(m.getName()+"  failed "+ex.getCause());
        }
      }
    }

    //Iterate through all constructors in tested
    //and check if the annotation ToTest is present'
    //Constructor<?> cst = test.getConstructor();
    for(Constructor<?> cst : test.getConstructors()){ //getDeclaredConstructors()でもいい、むしろこっちの方がいいかもConstructor"s"じゃないとforループできない//コンストラクタに引数がないため引数なし
      if(cst.isAnnotationPresent(ToTest.class)){
        //perform so tasks
        try{
          cst.newInstance();//引数がStringなどならString.classと引数に入れる
          System.out.println(cst.getName()+" success");
        }catch(Throwable ex){
          System.out.println(cst.getName()+" failed"+ ex.getCause());
        }
      }
    }
  }
}
