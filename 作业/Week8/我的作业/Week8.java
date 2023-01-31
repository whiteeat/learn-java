import java.net.URL;
import java.io.*;
import java.util.Date;

class Week8 
{
	public static void main(String[] args)
		throws Exception
	{
		final URL[] urls = {
			new URL("https://www.pku.edu.cn"),
			new URL("https://www.baidu.com"),
			new URL("https://www.sina.com.cn"),
			new URL("http://www.dstang.com")
		};

        // Filenames for singlethreaded
		final String[] files = {
			"pku.htm", 
			"baidu.htm",
			"sina.htm", 
			"study.htm",
		};

        // Filenames for multithreaded
        final String[] files1 = {
            "pku1.htm", 
			"baidu1.htm",
			"sina1.htm", 
			"study1.htm",
        };

        // Singlethreaded
        System.out.println("Singlethreaded download");
        long start = new Date().getTime();
		for(int idx=0; idx<urls.length; idx++){
			try{
				System.out.println( urls[idx] );
				download( urls[idx], files[idx]);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
        System.out.println("It takes " + (new Date().getTime() - start) + " milliseconds ");

        // Multithreaded
        System.out.println("Multithreaded download");
        Thread[] threads = new Thread[urls.length];
        start = new Date().getTime();
        for(int idx=0; idx<urls.length; idx++){
            final int i = idx;
            Thread t = new Thread( ()-> {
				try{
					System.out.println( urls[i] );
					download( urls[i], files1[i]);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			});
            t.start();
            threads[i] = t;
		}
        for(Thread thread : threads)
        {
            thread.join();
        }
        System.out.println("It takes " + (new Date().getTime() - start) + " milliseconds ");
	}
	static void download( URL url, String file)
		throws IOException
	{
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