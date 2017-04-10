package com.jaxsen.xianghacaipu.ui.cook.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */

public class DinnerList {

    /**
     * res : 2
     * data : [{"name":"肉酱意大利面","code":87814778,"img":"http://s1.cdn.xiangha.com/caipu/201608/2920/292024369257.jpg/MzAweDIwMA","isExclusive":"2","type":0,"isToday":2,"allClick":"9.6万","favorites":"1647","nickName":"浤辰","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":18947488081,"nickName":"浤辰","img":"http://s1.cdn.xiangha.com/i/201604/2001/57166e0b607b9.jpg/MTAweDEwMA","isGourmet":"2"}},{"name":"柠檬西瓜汁","code":87889952,"img":"http://s1.cdn.xiangha.com/caipu/201608/3017/301755405764.jpg/MzAweDIwMA","isExclusive":"2","type":0,"isToday":2,"allClick":"1.8万","favorites":"918","nickName":"辛墨墨","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":8665333745,"nickName":"辛墨墨","img":"http://s1.cdn.xiangha.com/i/201511/0612/563c28294094d.jpg/MTAweDEwMA","isGourmet":"2"}},{"name":"生煎饺子","code":87762980,"img":"http://s1.cdn.xiangha.com/caipu/201608/2911/291105463470.jpg/MzAweDIwMA","isExclusive":"2","type":0,"isToday":2,"allClick":"9.0万","favorites":"1691","nickName":"深谷幽兰","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":2580264104,"nickName":"深谷幽兰","img":"http://s1.cdn.xiangha.com/i/201510/3014/56330b265ba93.jpg/MTAweDEwMA","isGourmet":"2"}},{"name":"莲子百合红豆粥","code":87567533,"img":"http://s1.cdn.xiangha.com/caipu/201608/2708/27083701654.jpg/MzAweDIwMA","isExclusive":"2","type":0,"isToday":2,"allClick":"5.1万","favorites":"1411","nickName":"欣绿","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":55041993441,"nickName":"欣绿","img":"http://s1.cdn.xiangha.com/i/201608/1419/57b058c745f6e.jpg/MTAweDEwMA","isGourmet":"2"}},{"name":"陕西腊汁肉夹馍","code":87761068,"img":"http://s1.cdn.xiangha.com/caipu/201608/2910/291041089681.jpg/MzAweDIwMA","isExclusive":"2","type":0,"isToday":2,"allClick":"2.0万","favorites":"311","nickName":"悍匪夫人","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":6192564153,"nickName":"悍匪夫人","img":"http://s1.cdn.xiangha.com/i/201703/0919/58c1384b062ab.jpg/MTAweDEwMA","isGourmet":"2"}},{"name":"蛋饼","code":87701080,"img":"http://s1.cdn.xiangha.com/caipu/201608/2814/281444414270.jpg/MzAweDIwMA","isExclusive":"2","type":0,"isToday":2,"allClick":"6.4万","favorites":"1269","nickName":"深谷幽兰","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":2580264104,"nickName":"深谷幽兰","img":"http://s1.cdn.xiangha.com/i/201510/3014/56330b265ba93.jpg/MTAweDEwMA","isGourmet":"2"}},{"name":"牛肉番茄沙司意大利面","code":87695952,"img":"http://s1.cdn.xiangha.com/caipu/201608/2814/281403538317.jpg/MzAweDIwMA","isExclusive":"2","type":0,"isToday":1,"allClick":"5.9万","favorites":"2287","nickName":"辛墨墨","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":8665333745,"nickName":"辛墨墨","img":"http://s1.cdn.xiangha.com/i/201511/0612/563c28294094d.jpg/MTAweDEwMA","isGourmet":"2"}},{"name":"水煎饺","code":87648081,"img":"http://s1.cdn.xiangha.com/caipu/201608/2721/272135116684.jpg/MzAweDIwMA","isExclusive":"2","type":0,"isToday":1,"allClick":"10.3万","favorites":"1968","nickName":"睿睿麻","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":63361358331,"nickName":"睿睿麻","img":"http://s1.cdn.xiangha.com/i/201605/2120/5740501048a66.jpg/MTAweDEwMA","isGourmet":"2"}},{"name":"芝麻糊","code":87783360,"img":"http://s1.cdn.xiangha.com/caipu/201608/2914/291424423795.jpg/MzAweDIwMA","isExclusive":"1","type":0,"isToday":1,"allClick":"15.4万","favorites":"2182","nickName":"MM_玫玫","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":3139202527,"nickName":"MM_玫玫","img":"http://s1.cdn.xiangha.com/i/201702/0320/58947ae604d12.jpg/MTAweDEwMA","isGourmet":"2"}},{"name":"奶油小馒头","code":87684110,"img":"http://s1.cdn.xiangha.com/caipu/201608/2812/281234021408.jpg/MzAweDIwMA","isExclusive":"2","type":0,"isToday":1,"allClick":"8.6万","favorites":"2490","nickName":"郁郁yuyu","isFav":1,"level":3,"isFine":2,"hasVideo":"1","customer":{"code":11143709180,"nickName":"郁郁yuyu","img":"http://s1.cdn.xiangha.com/i/201604/2517/571dea5cbf15a.jpg/MTAweDEwMA","isGourmet":"2"}}]
     * append : []
     */

    private int res;
    private List<DinnerData> data;
    private List<?> append;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<DinnerData> getData() {
        return data;
    }

    public void setData(List<DinnerData> data) {
        this.data = data;
    }

    public List<?> getAppend() {
        return append;
    }

    public void setAppend(List<?> append) {
        this.append = append;
    }

    public static class DinnerData {
        /**
         * name : 肉酱意大利面
         * code : 87814778
         * img : http://s1.cdn.xiangha.com/caipu/201608/2920/292024369257.jpg/MzAweDIwMA
         * isExclusive : 2
         * type : 0
         * isToday : 2
         * allClick : 9.6万
         * favorites : 1647
         * nickName : 浤辰
         * isFav : 1
         * level : 3
         * isFine : 2
         * hasVideo : 1
         * customer : {"code":18947488081,"nickName":"浤辰","img":"http://s1.cdn.xiangha.com/i/201604/2001/57166e0b607b9.jpg/MTAweDEwMA","isGourmet":"2"}
         */

        private String name;
        private int code;
        private String img;
        private String isExclusive;
        private int type;
        private int isToday;
        private String allClick;
        private String favorites;
        private String nickName;
        private int isFav;
        private int level;
        private int isFine;
        private String hasVideo;
        private CustomerBean customer;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getIsExclusive() {
            return isExclusive;
        }

        public void setIsExclusive(String isExclusive) {
            this.isExclusive = isExclusive;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIsToday() {
            return isToday;
        }

        public void setIsToday(int isToday) {
            this.isToday = isToday;
        }

        public String getAllClick() {
            return allClick;
        }

        public void setAllClick(String allClick) {
            this.allClick = allClick;
        }

        public String getFavorites() {
            return favorites;
        }

        public void setFavorites(String favorites) {
            this.favorites = favorites;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getIsFav() {
            return isFav;
        }

        public void setIsFav(int isFav) {
            this.isFav = isFav;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getIsFine() {
            return isFine;
        }

        public void setIsFine(int isFine) {
            this.isFine = isFine;
        }

        public String getHasVideo() {
            return hasVideo;
        }

        public void setHasVideo(String hasVideo) {
            this.hasVideo = hasVideo;
        }

        public CustomerBean getCustomer() {
            return customer;
        }

        public void setCustomer(CustomerBean customer) {
            this.customer = customer;
        }

        public static class CustomerBean {
            /**
             * code : 18947488081
             * nickName : 浤辰
             * img : http://s1.cdn.xiangha.com/i/201604/2001/57166e0b607b9.jpg/MTAweDEwMA
             * isGourmet : 2
             */

            private long code;
            private String nickName;
            private String img;
            private String isGourmet;

            public long getCode() {
                return code;
            }

            public void setCode(long code) {
                this.code = code;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getIsGourmet() {
                return isGourmet;
            }

            public void setIsGourmet(String isGourmet) {
                this.isGourmet = isGourmet;
            }
        }
    }
}
