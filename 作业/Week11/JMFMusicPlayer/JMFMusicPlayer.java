import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.ControllerClosedEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;
import javax.media.Time;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class JMFMusicPlayer extends JFrame implements ActionListener, ControllerListener, ItemListener
{
    // JMF的播放器
    Player player;
    // 标示是否是第一次打开播放器
    boolean first = true;
    // 标示是否需要循环
    boolean loop = false;
    // 文件当前目录
    String currentDirectory;
    // 构造方法
    public JMFMusicPlayer(String title)
    {
        super(title);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // 用户点击窗口系统菜单的关闭按钮
                // 调用dispose以执行windowClosed
                dispose();
            }
            public void windowClosed(WindowEvent e) {
                if (player != null) {
                    // 关闭JMF播放器对象
                    player.close();
                }
                System.exit(0);
            }
        });

        // 创建播放器的菜单
        JMenu fileMenu = new JMenu("文件");
        JMenuItem openMemuItem = new JMenuItem("打开");
        openMemuItem.addActionListener(this);
        fileMenu.add(openMemuItem);
        // 添加一个分割条
        fileMenu.addSeparator();
        // 创建一个复选框菜单项
        JCheckBoxMenuItem loopMenuItem = new JCheckBoxMenuItem("循环", false);
        loopMenuItem.addItemListener(this);
        fileMenu.add(loopMenuItem);
        fileMenu.addSeparator();
        JMenuItem exitMemuItem = new JMenuItem("退出");
        exitMemuItem.addActionListener(this);
        fileMenu.add(exitMemuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
        this.setSize(200, 200);

        try
        {
            // 设置界面的外观，为系统外观
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        this.setVisible(true);
    }
    /**
    * 实现了ActionListener接口，处理组件的活动事件
    */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("退出"))
        {
            // 调用dispose以便执行windowClosed
            dispose();
            return;
        }
        FileDialog fileDialog = new FileDialog(this, "打开媒体文件", FileDialog.LOAD);
        fileDialog.setDirectory(currentDirectory);
        fileDialog.setVisible(true);
        // 如果用户放弃选择文件，则返回
        if (fileDialog.getFile() == null)
        {
            return;
        }
        currentDirectory = fileDialog.getDirectory();
        if (player != null)
        {
            // 关闭已经存在JMF播放器对象
            player.close();
        }
        try
        {
            // 创建一个打开选择文件的播放器
            player = Manager.createRealizedPlayer(
                new MediaLocator("file:"
                    + fileDialog.getDirectory() + fileDialog.getFile()));
        }
        catch (javax.media.CannotRealizeException ex)
        {
            System.out.println("不能创建播放器");
        }
        catch (java.io.IOException e2)
        {
            e2.printStackTrace();
            return;
        }
        catch (NoPlayerException e2)
        {
            e2.printStackTrace();
            return;
        }
        if (player == null)
        {
            System.out.println("无法创建播放器.");
            return;
        }
        first = false;
        this.setTitle(fileDialog.getFile());
        
		// 播放器的控制事件处理
        player.addControllerListener(this);
        // 预读文件内容
        player.prefetch();
    }
    /**
    * 实现ControllerListener接口的方法，处理播放器的控制事件
    */
    public void controllerUpdate(ControllerEvent e)
    {
        // 如果是媒体文件到达尾部事件
        if (e instanceof EndOfMediaEvent)
        {
            if (loop)
            {
                // 如果允许循环，则重新开始播放
                player.setMediaTime(new Time(0));
                player.start();
            }
            return;
        }
        // 如果是播放器预读事件
        if (e instanceof PrefetchCompleteEvent)
        {
            // 启动播放器
            player.start();
            return;
        }
    }

    // 处理“循环”复选框菜单项的点击事件
    public void itemStateChanged(ItemEvent e)
    {
        loop = !loop;
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->{
			new JMFMusicPlayer("JMF音乐播放器");
        });
    }
}
