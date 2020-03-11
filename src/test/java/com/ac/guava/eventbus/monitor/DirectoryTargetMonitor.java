package com.ac.guava.eventbus.monitor;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.*;

/** 目录监控
 * @author anchao
 * @date 2020/3/11 15:02
 */
@Slf4j
public class DirectoryTargetMonitor implements TargetMonitor {


    private WatchService watchService;

    private EventBus eventBus;

    private  Path path;

    private volatile  boolean start = false ;

    public DirectoryTargetMonitor(EventBus eventBus,String targetPath) {
        this(eventBus,targetPath,"");
    }

    public DirectoryTargetMonitor(EventBus eventBus,String targetPath,String... more) {
        this.eventBus = eventBus;
        this.path = Paths.get(targetPath,more);
    }

    //启动
    @Override
    public void startMonitor() throws Exception {
        this.watchService = FileSystems.getDefault().newWatchService();
        this.path.register(watchService,StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE);
        log.info("The directory [{}] is monitoring ...",path);
        start =true;
        while (start){
            WatchKey watchKey = null;
            try {
                watchKey =watchService.take();
                watchKey.pollEvents().forEach(ev ->{
                    WatchEvent.Kind<?> kind = ev.kind();
                    Path p = ((Path) ev.context());
                    Path child = DirectoryTargetMonitor.this.path.resolve(p);
                    eventBus.post(new FileChangeEvent(child,kind));


                });
            } catch (InterruptedException e) {
                this.start=false;
            }finally {
                if (watchKey!=null) {
                    watchKey.reset();
                }
            }
        }
    }


    //停止
    @Override
    public void stopMonitor() throws Exception {
        log.info("The directory [{}] monitor will be stop ...",path);
        Thread.currentThread().interrupt();//中断
        this.start=false;
        this.watchService.close();
        log.info("The directory [{}] monitor will be stop done",path);


    }
}
