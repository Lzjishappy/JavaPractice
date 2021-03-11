package Practice;

import java.util.*;

//斗地主，放牌，洗牌，发牌
//牌是放到
public class Poker {
    //初始化牌
    private static void getPoker(ArrayList<Integer> stringList,HashMap<Integer,String> hashMap){
        String[]color={"♠","♦","♥","♣"};
        String[]poker={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //把所有的牌按顺序添加hashMap到中,stringList存放的是牌的编号
        int flag=0;
            for(String s1:poker){
                for(String s2:color){
                    hashMap.put(flag,s2+s1);
                    stringList.add(flag);
                    flag++;
                }
            }
         stringList.add(flag);
         hashMap.put(flag,"大王");
         stringList.add(flag+1);
         hashMap.put(flag+1,"小王");

        //洗牌，即把stringList的编号打乱
        Collections.shuffle(stringList);
        //把牌和编号放到hashMap中
    }

    private static void playPoker(ArrayList<Integer> stringList, Set<Integer>... sets){
        for(int i=0;i<stringList.size();i++){
            Integer it=stringList.get(i);
            if(i>=stringList.size()-3){
                sets[3].add(it);
                continue;
            }
            if(i%3==0){
                sets[0].add(it);
            }else if(i%3==1){
                sets[1].add(it);
            }else if(i%3==2){
                sets[2].add(it);
            }
        }
    }
    private static void lookPoker(String name,Set<Integer> set,HashMap<Integer,String> hashMap){
        System.out.println(name+"的牌是：");
        for(Integer it:set){
            System.out.print(hashMap.get(it));
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        HashMap<Integer,String> hashMap=new HashMap<>();
        getPoker(arrayList,hashMap);
        Set<Integer> player1=new TreeSet<>();
        Set<Integer> player2=new TreeSet<>();
        Set<Integer> player3=new TreeSet<>();
        Set<Integer> remain=new TreeSet<>();
        playPoker(arrayList,player1,player2,player3,remain);
        lookPoker("小红",player1,hashMap);
        lookPoker("小张",player2,hashMap);
        lookPoker("小明",player3,hashMap);
        lookPoker("底牌",remain,hashMap);




    }
}
