package com.ac.datastructure.easy.classarray;

/**
 * 对象数组
 */
public class ClassArray {

    /**声明数组*/
    private Person[] p;
    /**数组元素总数*/
    private int nElems;

    public ClassArray(int max) {
        p = new Person[max];
        nElems =0;
    }

    /**
     * 按姓查询(线性查找)
     * @param searchName
     * @return
     */
    public Person find(String searchName){

        int j;

        for (j=0;j<nElems;j++){
            if(p[j].getLastName().equals(searchName))break;
        }

        if(j==nElems)return null;//未找到返回 null

        else{
            return p[j]; //找到 返回对象
        }
    }

    /**
     * 向数组中插入
     * @param last
     * @param first
     * @param age
     */
    public void insert(String last,String first,int age){
        p[nElems] = new Person(last,first,age);
        nElems++;
    }

    /**
     * 删除数组中某一元素
     * @param last
     * @return
     */
    public boolean delete(String last){
        int j;

        for (j = 0; j <nElems ; j++) //线性查找
            if(p[j].getLastName().equals(last))break; //找到则跳出循环

            if(j==nElems) return false; //未找到

            else{
                for (int i=0;i<nElems;i++){
                    p[i] = p[i+1];
                }
                nElems --;
                return true;
            }
    }

    /**
     * 遍历显示数组
     */
    public void displayP(){
        for (int i = 0; i <nElems ; i++) {
            p[i].dispalyPerson();
        }
    }

}
