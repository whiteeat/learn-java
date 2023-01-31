import java.net.URL;

import java.io.*;

import java.util.Date;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;



class Unit8Downloader

{

    public static void main(String[] args)

            throws Exception

    {

        final URL[] urls = {

                new URL("https://www.pku.edu.cn"),

                new URL("https://www.baidu.com"),

                new URL("https://www.sina.com.cn"),

                new URL("https://www.dstang.com")

        };

        final String[] files = {

                "pku.htm",

                "baidu.htm",

                "sina.htm",

                "study.htm",

        };

        long begin = new Date().getTime();

        ExecutorService pool = Executors.newCachedThreadPool();//创建一个线程池，并用begin记录创建时间

        for(int i=0; i<urls.length; i++){

            final int idx = i;

            pool.execute(()-> {

                try{

                    System.out.println( urls[idx] );

                    download( urls[idx], files[idx]);

                }catch(Exception ex){

                    ex.printStackTrace();

                }

            });

        }

        pool.shutdown();

        while (true) {

            if (pool.isTerminated()) {  //如果线程池成功关闭，用end记录关闭时间，并打印end-begin

                long end = new Date().getTime();

                System.out.println(end-begin + " ms");

                break;

            }

        }



    }

    static void download( URL url, String file)

            throws IOException

    {

        long end;

        try(InputStream input = url.openStream();

            OutputStream output = new FileOutputStream(file))

        {

            byte[] data = new byte[1024];

            int length;

            while((length=input.read(data))!=-1){

                output.write(data,0,length);

            }

        }

    }

}

