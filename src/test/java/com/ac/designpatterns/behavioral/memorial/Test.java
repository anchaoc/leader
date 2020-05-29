package com.ac.designpatterns.behavioral.memorial;

/**
 * 备忘录模式
 * @author anchao
 * @date 2020/5/29 13:53
 **/
public class Test {

    public static void main(String[] args) {
        ArticleMementoManager articleMementoManager = new ArticleMementoManager();
        Article article = new Article("标题A", "内容A", "图片A");
        ArticleMemento articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);
        System.out.println("文章完整信息:"+article);

        System.out.println("修改文章信息start");
        article.setTitle("标题B");
        article.setContent("内容B");
        article.setImgs("图片B");
        System.out.println("修改文章信息end");
        articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);
        System.out.println("文章完整信息:"+article);


        System.out.println("撤销文章信息start");
        articleMemento= articleMementoManager.getMemento();
        article.undoFromMemento(articleMemento);
        System.out.println("撤销文章信息end");
        System.out.println("文章完整信息:"+article);

        System.out.println("撤销文章信息start");
        articleMemento= articleMementoManager.getMemento();
        article.undoFromMemento(articleMemento);
        System.out.println("撤销文章信息end");
        System.out.println("文章完整信息:"+article);


    }
}
