
import java.io.*;

/*
 *
 * 创建初始化spring boot project
 *
 * author ：bamboo
 * time： 2019-6-27
 *
 * */
public class InitSpringbootProject {

    public static void main(String[] args) throws IOException {

//        System.out.println(args[0]);
       // String[]  args={"D:\\mnt\\work_space\\java\\springboot-tool\\springboot-demo","D:\\mnt\\work_space\\java\\springboot-tool\\test","srping-1"};

        if(args.length <2){
            System.out.printf("args is empty,eg: java -jar  demo.jar  d:/test  d:/target fileName");
            System.exit(0);
        }
        if(args.length <3){
            args[2]=null;
        }


        File srcFile=new File(args[0]);//"D:\\mnt\\workspace-js\\server client -springboot dubbo 项目源码，报空指针异常\\springboot-demo");
        File destFile=new File(args[1]);//"D:\\mnt\\workspace-js\\server client -springboot dubbo 项目源码，报空指针异常\\test1");

        if(args.length <3)
            args[2]= srcFile.getName();

        copyFolder(srcFile,destFile,args[2]);
        //update pom
        if (!srcFile.getName().equals(args[2])){
            //springboot-demo
            String filePath = args[1]+File.separator+args[2]+File.separator+"pom.xml";
            readTxtFile(filePath,"springboot-demo",args[2]);
        }

        System.out.println("\ncreate springboot project success \n-----------------------------\n ");
        System.out.printf("proeject name :%s \n", args[2]);
        System.out.printf("project path :%s\n",args[1]);
        System.out.println("\n-----------------------------\n ");

    }


    //把一个文件拷贝到一个新的路径，如果有重命名则以重命名为主
    private static void copyFolder(File srcFile, File destFile,String fileName) throws IOException {

        if(srcFile.isDirectory()){
            if(fileName == null)
                fileName = srcFile.getName();

            File newFolder=new File(destFile,fileName);
            newFolder.mkdirs();
            File[] fileArray=srcFile.listFiles();

            for(File file:fileArray){
                copyFolder(file, newFolder,null);
            }

        }else{
            File newFile=new File(destFile,srcFile.getName());
            copyFile(srcFile,newFile);
        }

    }

    private static void copyFile(File srcFile, File newFile) throws IOException{
        // TODO Auto-generated method stub
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newFile));

        byte[] bys=new byte[1024];
        int len=0;
        while((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }
        bos.close();
        bis.close();

    }


    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static void readTxtFile(String filePath,String oldStr, String newStr){
        System.out.printf(filePath);
        try {
            String encoding="UTF-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                CharArrayWriter caw = new  CharArrayWriter();
                int sum=0;
                while((lineTxt = bufferedReader.readLine()) != null){
                    //System.out.println(lineTxt);
                    //判断是否包含目标字符，包含则替换
                    if(lineTxt.contains(oldStr)){
                        lineTxt = new String(lineTxt.replace(oldStr, newStr));
                        sum++;
                    }
                    //写入内容并添加换行
                    caw.write(lineTxt);
                    caw.write("\r\n");
                }
                read.close();


                // 替换文件写入
                BufferedWriter bw_File = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(file)));
                caw.writeTo(bw_File);
                caw.close();
                bw_File.close();



            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

}
