package com.ac.designpatterns.behavioral.command;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author anchao
 * @date 2020/9/7 17:49
 **/
public class Staff {
    private List<Command> commandList = new CopyOnWriteArrayList<Command>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void executeCommands(){
        //遍历执行命令
        commandList.forEach(Command::execute);
        commandList.clear();
    }
}
