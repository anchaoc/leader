package com.ac.algorithm.recursion;

import java.util.*;

/**
 * @author anchao
 * @date 2020/12/12 22:15
 **/
public class RecursionTest {

    public static void main(String[] args) {
        City jiangsu = City.builder().id(1).name("江苏省").level(1).pid(0).build();
        City jiangning = City.builder().id(5).name("江宁区").level(3).pid(4).build();
        City peixian = City.builder().id(3).name("沛县").level(3).pid(2).build();
        City nanjing = City.builder().id(4).name("南京市").level(2).pid(1).build();
        City xuzou = City.builder().id(2).name("徐州市").level(2).pid(1).build();
        City beijing = City.builder().id(6).name("北京").level(1).pid(0).build();
        City haidian = City.builder().id(7).name("海淀").level(2).pid(6).build();
        City xisanqi = City.builder().id(8).name("西三旗").level(3).pid(7).build();
        ArrayList<City> cityArrayList = new ArrayList<>();
        cityArrayList.add(jiangsu);
        cityArrayList.add(xuzou);
        cityArrayList.add(peixian);
        cityArrayList.add(nanjing);
        cityArrayList.add(jiangning);
        cityArrayList.add(beijing);
        cityArrayList.add(haidian);
        cityArrayList.add(xisanqi);
        List<City> cityList = findTree(cityArrayList);
        System.out.println(cityList);
    }

    public static List<City> findTree(List<City> cityList) {
        try {//查询所有菜单
            //根节点
            List<City> rootMenu = new ArrayList<City>();
            for (City city : cityList) {
                if (city.getPid().equals(0)) {//父节点是0的，为根节点。
                    rootMenu.add(city);
                }
            }
            //为根菜单设置子菜单，getClild是递归调用的
            for (City nav : rootMenu) {
                /* 获取根节点下的所有子节点 使用getChild方法*/
                List<City> childList = getChild(nav.getId(), cityList);
                //给根节点设置子节点
                nav.setChildCity(childList);
            }
            return rootMenu;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * 获取子节点
     * @param id      父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public static List<City> getChild(Integer id, List<City> allMenu) {
        //子菜单
        List<City> childList = new ArrayList<City>();
        for (City nav : allMenu) {
            if (nav.getPid().equals(id)) {
                childList.add(nav);
            }
        }
        for (City nav : childList) {
            //递归
            nav.setChildCity(getChild(nav.getId(), allMenu));
        }
        return childList;
    }
}

