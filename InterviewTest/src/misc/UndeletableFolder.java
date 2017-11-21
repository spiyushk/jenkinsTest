package misc;


public class UndeletableFolder {

    public static void main(String[] args) {

        Runtime runtime=Runtime.getRuntime();
        try {
            Process process= runtime.exec("cmd.exe /c  start cacls D:/undeletableText.txt /e /d %username%");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 


}