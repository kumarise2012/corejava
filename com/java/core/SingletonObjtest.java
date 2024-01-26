package org.example;

class SingletonTest {

    public static void main(String[] args){

        SingletonObjTest singletonObjTest1;
        SingletonObjTest singletonObjTest2;

        singletonObjTest1 = SingletonObjTest.getSingleInstance();
        singletonObjTest2 = SingletonObjTest.getSingleInstance();

        System.out.println("Singleton Object Test via equals "+ singletonObjTest1.equals(singletonObjTest2));
        System.out.println("Singleton Object Test via == "+ (singletonObjTest1==singletonObjTest2));



    }



}

 class SingletonObjTest{
     private static SingletonObjTest singletonTest = null;

     private SingletonObjTest(){

     }
     public static SingletonObjTest getSingleInstance(){
         if(singletonTest == null)
             singletonTest =  new SingletonObjTest();
         return singletonTest;
     }


}


