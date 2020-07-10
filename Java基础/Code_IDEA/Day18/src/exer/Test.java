package exer;

/**
 * @author zzq
 * @creat 2020-05-25 10:26
 */
public class Test {
    public static void main(String[] args) {

    }
}

class eHan{

    private eHan(){

    }

    private static eHan instance = null;

    public static eHan getInstance(){
        if(instance == null){
            synchronized (Test.class){
                if(instance == null)
                    instance = new eHan();
            }
        }
        return instance;
    }
}
