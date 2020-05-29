package com.ac.designpatterns.behavioral.memorial;

import java.util.Stack;

/**
 * @author anchao
 * @date 2020/5/29 13:35
 **/
public class ArticleMementoManager {
    private final Stack<ArticleMemento> ARTICEL_MEMENTO_STACK= new Stack<>();

    public ArticleMemento getMemento(){
        ArticleMemento articleMemento = ARTICEL_MEMENTO_STACK.pop();
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento){
        ARTICEL_MEMENTO_STACK.push(articleMemento);
    }
}
