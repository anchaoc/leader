package com.ac.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anchao
 * @date 2020/9/7 17:49
 **/
public class Staff {
    private List<Command> commandList = new ArrayList<Command>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void executeCommands(){
        //遍历执行命令
        commandList.forEach(Command::execute);
    }
}
